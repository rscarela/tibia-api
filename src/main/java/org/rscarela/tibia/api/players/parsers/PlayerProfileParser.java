package org.rscarela.tibia.api.players.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.rscarela.tibia.ResponseParser;
import org.rscarela.tibia.api.players.Player;
import org.rscarela.tibia.api.players.UnexistingPlayer;
import org.rscarela.tibia.api.worlds.World;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Renan Scarela
 */
public class PlayerProfileParser implements ResponseParser<Player> {

	@Override
	public Player parse(Document response) {
		Map<String, String> data = parseData(response);

		if(data.isEmpty()) {
			return new UnexistingPlayer();
		}

		Player player = getBasicProfile(data);
		setupDetailedProfile(player, data);

		return player;
	}

	private Map<String, String> parseData(Document response) {
		Element table = response.select("table").first();
		Elements rows = table.select("tr");

		if(rows.size() == 3) return Collections.EMPTY_MAP;

		HashMap<String, String> data = new HashMap<>();

		for(int i = 1; i < rows.size(); i++) {
			Element row = rows.get(i);
			Elements columns = row.select("td");

			data.put(columns.get(0).text().replace(":", "").replaceAll("\\xA0"," ").toLowerCase(), columns.get(1).text());
		}

		return data;
	}

	private Player getBasicProfile(Map<String, String> data) {
		return new Player(data.get("name"), World.representationOf(data.get("world")), Integer.valueOf(data.get("level")), data.get("vocation"));
	}

	private void setupDetailedProfile(Player player, Map<String, String> data) {
		player.setResidence(data.get("residence"));
		player.setHouse(data.get("house"));
		player.setAchievementPoints(Integer.valueOf(data.get("achievement points")));
		player.setGuildMembership(data.get("guild membership"));
		player.setAccountStatus(data.get("account status"));
		player.setComment(data.get("comment"));
	}

}
