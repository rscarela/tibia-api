package org.rscarela.tibia.api.players.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.rscarela.tibia.ResponseParser;
import org.rscarela.tibia.api.players.Player;
import org.rscarela.tibia.api.worlds.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Renan Scarela
 */
public class OnlinePlayersParser implements ResponseParser<List<Player>> {

	private final World world;

	public OnlinePlayersParser(World world) {
		this.world = world;
	}

	@Override
	public List<Player> parse(Document response) {
		Element table = response.getElementsByClass("Table2").first();
		Elements rows = table.select("tr");

		List<Player> players = new ArrayList<>();

		for(int i = 2; i < rows.size(); i++) {
			Element row = rows.get(i);
			Elements columns = row.select("td");

			Player player = new Player(columns.get(0).text(), world, Integer.valueOf(columns.get(1).text()), columns.get(2).text());

			players.add(player);
		}

		return players;
	}

}
