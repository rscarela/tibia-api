package org.rscarela.tibia;

/**
 * @since 1.0.0
 * @author Renan Scarela
 */

public class TibiaClientBuilder {

	private static final String DEFAULT_TIBIA_URL = "http://www.tibia.com";

	private String baseURL;

	public final TibiaClient build() {
		return new TibiaClient(getConnector());
	}

	private String getBaseURL() {
		return baseURL == null ? DEFAULT_TIBIA_URL : baseURL;
	}

	private TibiaConnector getConnector() {
		return new TibiaConnector(getBaseURL());
	}

	public TibiaClientBuilder setBaseURL(String baseURL) {
		this.baseURL = baseURL;
		return this;
	}

}
