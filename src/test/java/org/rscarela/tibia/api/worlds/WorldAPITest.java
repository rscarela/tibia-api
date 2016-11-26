package org.rscarela.tibia.api.worlds;

import org.junit.Assert;
import org.junit.Test;
import org.rscarela.tibia.TibiaClient;
import org.rscarela.tibia.TibiaClientBuilder;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Renan Scarela
 */
public class WorldAPITest {

	@Test
	public void mustListAllGameWorlds() throws Exception {
		TibiaClient tibia = new TibiaClientBuilder().build();

		List<World> worlds = tibia.worlds().fetchAll();

		Assert.assertNotNull(worlds);
		Assert.assertFalse(worlds.isEmpty());
	}

	@Test
	public void mustGetAWorldByItsNameProvidingAWorldNameAsParameter() throws Exception {
		TibiaClient tibia = new TibiaClientBuilder().build();

		World world = tibia.worlds().fetchByName(WorldName.ANTICA);

		Assert.assertEquals(world.getName(), "Antica");
	}

	@Test
	public void mustGetAWorldByItsNameProvidingAStringAsParameter() throws Exception {
		TibiaClient tibia = new TibiaClientBuilder().build();

		World world = tibia.worlds().fetchByName("Serdebra");

		Assert.assertEquals(world.getName(), "Serdebra");
	}

}