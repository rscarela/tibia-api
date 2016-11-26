package org.rscarela.tibia.api.worlds.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.rscarela.tibia.ResponseParser;
import org.rscarela.tibia.api.worlds.World;
import org.rscarela.tibia.api.worlds.WorldProperties;
import org.rscarela.tibia.api.worlds.WorldType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Renan Scarela
 */
public class WorldParser implements ResponseParser<World> {

	private final String worldName;

	public WorldParser(String worldName) {
		this.worldName = worldName;
	}

	@Override
	public World parse(Document response) {
		List<World> worlds = new WorldListParser().parse(response);

		World world = worlds
							.stream()
							.filter(p -> p.getName().toLowerCase().equals(worldName.toLowerCase()))
							.findFirst()
							.get();

		return world;
	}
}
