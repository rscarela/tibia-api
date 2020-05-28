package org.rscarela.tibia.api.worlds.guilds.parsers;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.rscarela.tibia.ResponseParser;
import org.rscarela.tibia.api.worlds.guilds.Guild;
import org.rscarela.tibia.api.worlds.guilds.GuildDetails;

public class WorldGuildsParser implements ResponseParser<List<Guild>> {

    @Override
    public List<Guild> parse(Document response) {
        List<Guild> guilds = new ArrayList<>();

        Elements rows = response
                .getElementsByClass("TableContentContainer")
                .first()
                .getElementsByClass("TableContent")
                .first()
                .select("tr");

        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements columns = row.select("td");

            if (columns.size() < 4) continue;

            String name = columns.get(1).select("b").first().text();
            String description = columns.get(1).text().replace(name, "");

            guilds.add(new Guild(name, new GuildDetails(description)));
        }

        return guilds;
    }

}
