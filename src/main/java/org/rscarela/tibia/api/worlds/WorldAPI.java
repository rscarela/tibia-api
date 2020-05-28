package org.rscarela.tibia.api.worlds;

import org.rscarela.tibia.TibiaConnector;
import org.rscarela.tibia.TibiaParameters;
import org.rscarela.tibia.api.worlds.parsers.WorldListParser;
import org.rscarela.tibia.api.worlds.parsers.WorldParser;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Renan Scarela
 */
public class WorldAPI {

	private final TibiaConnector connector;

	public WorldAPI(TibiaConnector connector) {
		this.connector = connector;
	}

	public List<World> fetchAll() {
		return connector.get("/community/?subtopic=worlds", new WorldListParser());
	}

	public World fetchByName(WorldName name) {
		return fetchByName(name.name());
	}

	public World fetchByName(String name) {
		return connector.get("/community/?subtopic=worlds", new WorldParser(name));
	}

	public List<World> fetchEuropean() {
		return fetchAll()
				.stream()
				.filter(p -> p.getLocation().equals(WorldLocation.EUROPE))
				.collect(Collectors.toList());
	}

	public List<World> fetchNorthAmerican() {
		return fetchAll()
				.stream()
				.filter(p -> p.getLocation().equals(WorldLocation.NORTH_AMERICA))
				.collect(Collectors.toList());
	}

	public List<World> fetchSouthAmerican() {
		return fetchAll()
				.stream()
				.filter(p -> p.getLocation().equals(WorldLocation.SOUTH_AMERICA))
				.collect(Collectors.toList());
	}

	public WorldDataAPI from(WorldName worldName) {
		return new WorldDataAPI(connector, World.representationOf(worldName.getFormattedName()));
	}

}
