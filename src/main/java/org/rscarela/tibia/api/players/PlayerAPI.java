package org.rscarela.tibia.api.players;

import org.rscarela.tibia.TibiaConnector;
import org.rscarela.tibia.TibiaParameters;
import org.rscarela.tibia.api.players.parsers.OnlinePlayersParser;
import org.rscarela.tibia.api.players.parsers.PlayerProfileParser;
import org.rscarela.tibia.api.worlds.World;
import org.rscarela.tibia.api.worlds.WorldName;

import java.util.List;

/**
 * @Author Renan Scarela
 */
public class PlayerAPI {

	private final TibiaConnector connector;

	public PlayerAPI(TibiaConnector connector) {
		this.connector = connector;
	}

	public List<Player> fetchOnlinePlayersOn(World world) {
		return fetchOnlinePlayersOn(world.getName());
	}

	public List<Player> fetchOnlinePlayersOn(WorldName world) {
		return fetchOnlinePlayersOn(world.getFormattedName());
	}

	public List<Player> fetchOnlinePlayersOn(String world) {
		World representativeWorld = World.representationOf(world);

		TibiaParameters parameters = new TibiaParameters();
		parameters.setParameter("world", world);

		return connector.get("/community/?subtopic=worlds", parameters, new OnlinePlayersParser(representativeWorld));
	}

	public Player fetchPlayer(String name) {
		TibiaParameters parameters = new TibiaParameters();
		parameters.setParameter("name", name);

		return connector.get("/community/?subtopic=characters", parameters, new PlayerProfileParser());
	}

}
