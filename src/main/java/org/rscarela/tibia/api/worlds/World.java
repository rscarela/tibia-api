package org.rscarela.tibia.api.worlds;

/**
 * @author Renan Scarela
 */
public class World {

	private final String name;

	private final Integer currentPlayers;

	private final WorldType type;

	private final WorldProperties properties;

	public World(String name, Integer currentPlayers, WorldType type, WorldProperties properties) {
		this.name = name;
		this.currentPlayers = currentPlayers;
		this.type = type;
		this.properties = properties;
	}

	public static World representationOf(String name) {
		return new World(name, 0, WorldType.UNDEFINED, null);
	}

	public String getName() {
		return name;
	}

	public Integer getCurrentPlayers() {
		return currentPlayers;
	}

	public WorldType getType() {
		return type;
	}

	public WorldProperties getProperties() {
		return properties;
	}

}
