package org.rscarela.tibia.api.worlds;

import org.rscarela.tibia.TibiaConnector;
import org.rscarela.tibia.api.worlds.guilds.GuildAPI;

public class WorldDataAPI {

    private final TibiaConnector connector;
    private final World world;

    public WorldDataAPI(TibiaConnector connector, World world) {
        this.connector = connector;
        this.world = world;
    }

    public GuildAPI guilds() {
        return new GuildAPI(connector, world);
    }

}
