package org.rscarela.tibia;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author Renan Scarela
 */
public class TibiaConnector {

	private final String baseURL;
	private final TibiaConnectorTimeout timeout;

	TibiaConnector(String baseURL, TibiaConnectorTimeout details) {
		this.baseURL = baseURL;
		this.timeout = details;
	}

	public <T> T get(String URI , ResponseParser<T> parser) {
		return get(URI, TibiaParameters.empty(), parser);
	}

	public <T> T get(String URI, TibiaParameters parameters, ResponseParser<T> parser) {
		try {
			String URL = handleURL(URI, parameters);

			Document document = Jsoup.connect(URL).get();

			return parser.parse(document);
		} catch (HttpStatusException e) {
			if(e.getStatusCode() != 403) throw new RuntimeException(e);

			if(!timeout.mustHandleForbiddenStatus()) throw new RuntimeException("Unable to reach Tibia data.", e);

			return get(URI, parameters, parser);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public <T> T post(String URI, TibiaParameters parameters, ResponseParser<T> parser){
		try {
			String URL = handleURL(URI);

			Document document = formData(URL, parameters).post();

			return parser.parse(document);
		} catch (HttpStatusException e) {
			if(e.getStatusCode() != 403) throw new RuntimeException(e);

			if(!timeout.mustHandleForbiddenStatus()) throw new RuntimeException("Unable to reach Tibia data.", e);

			return post(URI, parameters, parser);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private String handleURL(String URI) {
		return handleURL(URI, TibiaParameters.empty());
	}

	private String handleURL(String URI, TibiaParameters parameters) {
		StringBuilder url = new StringBuilder(baseURL + URI);

		if(parameters.isEmpty()) {
			return url.toString();
		}

		StringBuilder queryString = new StringBuilder();

		for(String parameter: parameters.keys()) {
			queryString.append("&");
			queryString.append(parameter);
			queryString.append("=");
			queryString.append(parameters.valueOf(parameter));
		}

		return url.append(queryString.toString()).toString();
	}

	private Connection formData(String URL, TibiaParameters parameters) {
		Connection connection = Jsoup.connect(URL);

		parameters
				.keys()
				.forEach(key -> connection.data(key, parameters.valueOf(key)));

		return connection;
	}

}
