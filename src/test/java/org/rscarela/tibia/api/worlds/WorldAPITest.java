package org.rscarela.tibia.api.worlds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rscarela.tibia.TibiaClient;
import org.rscarela.tibia.TibiaClientBuilder;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Renan Scarela
 */
public class WorldAPITest {

	private TibiaClient tibia;

	@Before
	public void setup() {
		tibia = new TibiaClientBuilder()
									.setHandleForbiddenStatus(true)
									.build();
	}

	@Test
	public void mustListAllGameWorlds() throws Exception {
		List<World> worlds = tibia.worlds().fetchAll();

		Assert.assertNotNull(worlds);
		Assert.assertFalse(worlds.isEmpty());
	}

	@Test
	public void mustGetAWorldByItsNameProvidingAWorldNameAsParameter() throws Exception {
		World world = tibia.worlds().fetchByName(WorldName.ANTICA);

		Assert.assertEquals(world.getName(), "Antica");
	}

	@Test
	public void mustGetAWorldByItsNameProvidingAStringAsParameter() throws Exception {
		World world = tibia.worlds().fetchByName("Serdebra");

		Assert.assertEquals(world.getName(), "Serdebra");
	}

	@Test
	public void mustListEuropeanGameServers() {
		List<World> worlds = tibia.worlds().fetchEuropean();

		Assert.assertFalse(worlds.isEmpty());
		for(World world : worlds) {
			Assert.assertEquals(WorldLocation.EUROPE, world.getLocation());
		}
	}

	@Test
	public void mustListNorthAmericanGameServers() {
		List<World> worlds = tibia.worlds().fetchNorthAmerican();

		Assert.assertFalse(worlds.isEmpty());
		for(World world : worlds) {
			Assert.assertEquals(WorldLocation.NORTH_AMERICA, world.getLocation());
		}
	}

	@Test
	public void mustListShoutAmericanGameServers() {
		List<World> worlds = tibia.worlds().fetchSouthAmerican();

		Assert.assertFalse(worlds.isEmpty());
		for(World world : worlds) {
			Assert.assertEquals(WorldLocation.SOUTH_AMERICA, world.getLocation());
		}
	}

}
