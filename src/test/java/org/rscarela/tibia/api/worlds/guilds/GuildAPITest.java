package org.rscarela.tibia.api.worlds.guilds;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.rscarela.tibia.TibiaClient;
import org.rscarela.tibia.TibiaClientBuilder;
import org.rscarela.tibia.api.worlds.WorldName;

public class GuildAPITest {

    private TibiaClient tibia;

    @Before
    public void setup() {
        tibia = new TibiaClientBuilder()
                .setHandleForbiddenStatus(true)
                .build();
    }

    @Test
    public void mustReturnAListContainingAllGuildsFromCurrentWorld() {
        List<Guild> guilds = tibia
                .worlds()
                .from(WorldName.ANTICA)
                .guilds()
                .fetchAll();

        assertFalse(guilds.isEmpty());
    }

    @Test
    public void mustReturnAnInstanceOfGuildContainingAllDataFromIt() {
        Guild guild = tibia
                .worlds()
                .from(WorldName.ANTICA)
                .guilds()
                .fetchGuild("Red Rose");

        assertNotNull(guild);
    }

    @Test
    public void mustReturnAnInstanceOfAnInvalidGuildWhenNoGuildIsFoundForGivenName() {
        Guild guild = tibia
                .worlds()
                .from(WorldName.ANTICA)
                .guilds()
                .fetchGuild("Wrong Name");

        assertNotNull(guild);
        assertFalse(guild.isValid());
    }

}
