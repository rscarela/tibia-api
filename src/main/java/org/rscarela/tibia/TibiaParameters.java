package org.rscarela.tibia;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Renan Scarela
 */

public class TibiaParameters {

	private final Map<String, String> parameters;

	public TibiaParameters() {
		this.parameters = new HashMap<>();
	}

	public static TibiaParameters empty() {
		return new TibiaParameters();
	}

	public TibiaParameters setParameter(String key, String value) {
		parameters.put(key, value.replaceAll("\\xA0","%20").replaceAll("'", "%27"));
		return this;
	}

	public Set<String> keys() {
		return parameters.keySet();
	}

	public String valueOf(String key) {
		return parameters.get(key);
	}

	public boolean isEmpty() {
		return parameters.isEmpty();
	}

}
