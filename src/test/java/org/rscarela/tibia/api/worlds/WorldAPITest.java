package org.rscarela.tibia.api.worlds;

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
	public void fetchAll() throws Exception {
		TibiaClient tibia = new TibiaClientBuilder().build();

		List<World> worlds = tibia.worlds().fetchAll();

		return;
	}

	@Test
	public void fetchByName() throws Exception {

	}

	@Test
	public void featchByName() throws Exception {

	}

}