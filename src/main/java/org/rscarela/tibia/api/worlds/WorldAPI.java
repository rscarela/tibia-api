package org.rscarela.tibia.api.worlds;

import org.rscarela.tibia.TibiaConnector;
import org.rscarela.tibia.TibiaParameters;
import org.rscarela.tibia.api.worlds.parsers.WorldListParser;
import org.rscarela.tibia.api.worlds.parsers.WorldParser;

import java.util.List;

/**
 * @author Renan Scarela
 */
public class WorldAPI {

	private final TibiaConnector connector;

	public WorldAPI(TibiaConnector connector) {
		this.connector = connector;
	}

	public List<World> fetchAll() {
		return connector.get("/community/?subtopic=worlds", TibiaParameters.empty(), new WorldListParser());
	}

	public World fetchByName(WorldName name) {
		return fetchByName(name.name());
	}

	public World fetchByName(String name) {
		return connector.get("/community/?subtopic=worlds", TibiaParameters.empty(), new WorldParser(name));
	}

}
