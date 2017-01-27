package org.rscarela.tibia;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author Renan Scarela
 */
public class TibiaConnector {

	private final String baseURL;

	TibiaConnector(String baseURL) {
		this.baseURL = baseURL;
	}

	public <T> T get(String URI , ResponseParser<T> parser) {
		return get(URI, TibiaParameters.empty(), parser);
	}

	public <T> T get(String URI, TibiaParameters parameters, ResponseParser<T> parser) {
		try {
			String URL = handleURL(URI, parameters);

			Document document = Jsoup.connect(URL).get();

			return parser.parse(document);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
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

}
