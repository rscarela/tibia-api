package org.rscarela.tibia;

import org.rscarela.tibia.api.worlds.WorldAPI;

/**
 * @Author Renan Scarela
 */

public class TibiaClient {

	private final TibiaConnector connector;

	protected TibiaClient(TibiaConnector connector) {
		this.connector = connector;
	}

	public WorldAPI worlds() {
		return new WorldAPI(connector);
	}

}
