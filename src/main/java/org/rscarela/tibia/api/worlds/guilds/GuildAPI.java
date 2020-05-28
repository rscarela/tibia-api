package org.rscarela.tibia.api.worlds.guilds;

import java.util.List;
import org.rscarela.tibia.TibiaConnector;
import org.rscarela.tibia.TibiaParameters;
import org.rscarela.tibia.api.worlds.World;
import org.rscarela.tibia.api.worlds.guilds.parsers.GuildParser;
import org.rscarela.tibia.api.worlds.guilds.parsers.WorldGuildsParser;

public class GuildAPI {

    private final TibiaConnector connector;
    private final World world;

    public GuildAPI(TibiaConnector connector, World world) {
        this.connector = connector;
        this.world = world;
    }

    public List<Guild> fetchAll() {
        TibiaParameters parameters = new TibiaParameters();
        parameters.setParameter("world", world.getName());

        return connector.post("/community/?subtopic=guilds", parameters, new WorldGuildsParser());
    }

    public Guild fetchGuild(String name) {
        TibiaParameters parameters = new TibiaParameters();
        parameters.setParameter("GuildName", name);

        return connector.post("/community/?subtopic=guilds&page=view", parameters, new GuildParser(name, world));
    }

}
