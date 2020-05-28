package org.rscarela.tibia.api.worlds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.rscarela.tibia.TibiaClient;
import org.rscarela.tibia.TibiaClientBuilder;
import org.rscarela.tibia.api.players.Player;

import java.util.List;

/**
 * @Author Renan Scarela
 */

@RunWith(JUnit4.class)
public class PlayerAPITest {

	private TibiaClient tibia;

	@Before
	public void setup() {
		tibia = new TibiaClientBuilder()
				.setHandleForbiddenStatus(true)
				.build();
	}

	@Test
	public void mustFetchAllPlayersOnlineOnGivenWorld() {
		List<Player> players = tibia.players().fetchOnlinePlayersOn(WorldName.ANTICA);

		Assert.assertNotNull(players);
		Assert.assertFalse(players.isEmpty());
	}

	@Test
	public void mustFetchAllPlayersOnlineOnGivenWorldPassingAWorldAsParameters() {
		World world = World.representationOf("Antica");

		List<Player> players = tibia.players().fetchOnlinePlayersOn(world);

		Assert.assertNotNull(players);
		Assert.assertFalse(players.isEmpty());
	}

	@Test
	public void mustFetchAllPlayersOnlineOnGivenWorldPassingAStringAsParameters() {
		List<Player> players = tibia.players().fetchOnlinePlayersOn("Antica");

		Assert.assertNotNull(players);
		Assert.assertFalse(players.isEmpty());
	}

	@Test
	public void mustFetchAPlayerFullProfile() {
		Player player = tibia.players().fetchPlayer("Scarela Knight");

		Assert.assertNotNull(player);
	}

	@Test
	public void mustReturnAnUnexistingPlayerWhenTryingToFetchAPlayerThatDoesntExists() {
		Player player = tibia.players().fetchPlayer("Shadow Azir 222");

		Assert.assertFalse(player.isValidPlayer());
	}

}
