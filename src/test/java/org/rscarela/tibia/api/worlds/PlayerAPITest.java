package org.rscarela.tibia.api.worlds;

import org.junit.Assert;
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

	public void setup() throws InterruptedException {
		Thread.sleep(750);
	}

	@Test
	public void mustFetchAllPlayersOnlineOnGivingWorld() {
		TibiaClient tibia = new TibiaClientBuilder().build();

		List<Player> players = tibia.players().fetchOnlinePlayersOn(WorldName.ANTICA);

		Assert.assertNotNull(players);
		Assert.assertFalse(players.isEmpty());
	}

	@Test
	public void mustFetchAllPlayersOnlineOnGivingWorldPassingAWorldAsParameters() {
		TibiaClient tibia = new TibiaClientBuilder().build();

		World world = World.representationOf("Antica");

		List<Player> players = tibia.players().fetchOnlinePlayersOn(world);

		Assert.assertNotNull(players);
		Assert.assertFalse(players.isEmpty());
	}

	@Test
	public void mustFetchAllPlayersOnlineOnGivingWorldPassingAStringAsParameters() {
		TibiaClient tibia = new TibiaClientBuilder().build();

		List<Player> players = tibia.players().fetchOnlinePlayersOn("Antica");

		Assert.assertNotNull(players);
		Assert.assertFalse(players.isEmpty());
	}

	@Test
	public void mustFetchAPlayerFullProfile() {
		TibiaClient tibia = new TibiaClientBuilder().build();

		Player player = tibia.players().fetchPlayer("Shadow Azir");

		Assert.assertNotNull(player);
	}

}
