package org.rscarela.tibia;

/**
 * @since 1.0.0
 * @author Renan Scarela
 */

public class TibiaClientBuilder {

	private static final String DEFAULT_TIBIA_URL = "http://www.tibia.com";

	private String baseURL;
	private boolean handleForbiddenStatus;
	private Integer forbiddenStatusDelay;
	private Integer retryAttempts;

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

	public TibiaClientBuilder setHandleForbiddenStatus(boolean handleForbiddenStatus) {
		this.handleForbiddenStatus = handleForbiddenStatus;
		return this;
	}

	public TibiaClientBuilder setForbiddenStatusDelay(Integer forbiddenStatusDelay) {
		this.forbiddenStatusDelay = forbiddenStatusDelay;
		return this;
	}

	public TibiaClientBuilder setRetryAttempts(Integer retryAttempts) {
		this.retryAttempts = retryAttempts;
		return this;
	}

}
