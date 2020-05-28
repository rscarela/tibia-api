package org.rscarela.tibia.api.worlds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.rscarela.tibia.TibiaClient;
import org.rscarela.tibia.TibiaClientBuilder;
import org.rscarela.tibia.api.worlds.guilds.GuildAPI;

public class WorldDataAPITest {

    private TibiaClient tibia;

    @Before
    public void setup() {
        tibia = new TibiaClientBuilder()
                .setHandleForbiddenStatus(true)
                .build();
    }

    @Test
    public void mustReturnAnInstanceOfGuildAPIForGivenWorld() {
        GuildAPI guildAPI = tibia
                .worlds()
                .from(WorldName.BELOBRA)
                .guilds();

        assertNotNull(guildAPI);
    }

}
