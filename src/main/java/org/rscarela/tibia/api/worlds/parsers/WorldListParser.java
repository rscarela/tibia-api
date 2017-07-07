package org.rscarela.tibia.api.worlds.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.rscarela.tibia.ResponseParser;
import org.rscarela.tibia.api.worlds.World;
import org.rscarela.tibia.api.worlds.WorldLocation;
import org.rscarela.tibia.api.worlds.WorldProperties;
import org.rscarela.tibia.api.worlds.WorldType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Renan Scarela
 */
public class WorldListParser implements ResponseParser<List<World>> {

	@Override
	public List<World> parse(Document response) {
		List<World> worlds = new ArrayList<>();

		Element table = response.getElementsByClass("TableContent").last();
		Elements rows = table.select("tr");

		for(int i = 1; i < rows.size(); i++) {
			Element row = rows.get(i);
			Elements columns = row.select("td");

			String name = columns.get(0).text();
			Integer currentPlayers = Integer.valueOf(columns.get(1).text());
			WorldLocation location = WorldLocation.valueOf(columns.get(2).text().toUpperCase().replaceAll("\\xA0"," ").replace(" ", "_"));
			WorldType type = WorldType.valueOf(columns.get(3).text().toUpperCase().replace(" ", "_"));
			WorldProperties properties = new WorldProperties(Arrays.asList(columns.get(4).text().split(", ")));

			worlds.add(new World(name, currentPlayers, location, type, properties));
		}

		return worlds;
	}

}
