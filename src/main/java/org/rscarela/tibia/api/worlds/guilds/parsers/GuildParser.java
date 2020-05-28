package org.rscarela.tibia.api.worlds.guilds.parsers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.rscarela.tibia.ResponseParser;
import org.rscarela.tibia.api.players.GuildMembership;
import org.rscarela.tibia.api.players.Player;
import org.rscarela.tibia.api.worlds.World;
import org.rscarela.tibia.api.worlds.guilds.Guild;
import org.rscarela.tibia.api.worlds.guilds.GuildDetails;
import org.rscarela.tibia.api.worlds.guilds.InvalidGuild;

public class GuildParser implements ResponseParser<Guild> {

    private String guildName;
    private World world;

    public GuildParser(String guildName, World world) {
        this.guildName = guildName;
        this.world = world;
    }

    @Override
    public Guild parse(Document response) {
        String[] guildInformation = getGuildInformation(response);

        if (guildInformation.length == 1) return new InvalidGuild();

        List<Player> players = getPlayerList(response);

        GuildDetails guildDetails = new GuildDetailsParser(guildInformation).parse();

        return new Guild(guildName, guildDetails, players);
    }

    private String[] getGuildInformation(Document document) {
        document.outputSettings(new OutputSettings().prettyPrint(false))
                .getElementsByClass("InnerTableContainer")
                .select("#GuildInformationContainer")
                .select("br")
                .append("\\n");

        return document
                .getElementsByClass("InnerTableContainer").select("#GuildInformationContainer")
                .text()
                .split("\\\\n");
    }

    private List<Player> getPlayerList(Document document) {
        Element table = document.getElementsByClass("InnerTableContainer").get(2);
        Elements rows = table.select("tr");

        List<Player> players = new ArrayList<>();
        String currentRank = null;

        for (int i = 2; i < rows.size(); i++) {
            Elements columns = rows.get(i).select("td");

            if (columns.size() != 6) continue;

            currentRank = columns.get(0).text().equals("") ? currentRank : columns.get(0).text();

            String[] nameWithTitle = rows.get(i).select("td").get(1).text().split(" \\(");
            String title = nameWithTitle.length == 2 ? nameWithTitle[0].replace(")", "") : null;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate joiningDate = LocalDate.parse(columns.get(4).text(), formatter);

            Player player = new Player(nameWithTitle[0], world, Integer.valueOf(columns.get(3).text()), columns.get(2).text());

            GuildMembership membership = new GuildMembership(currentRank, guildName, title, joiningDate);
            player.setGuildMembership(membership);

            players.add(player);
        }

        return players;
    }

}
