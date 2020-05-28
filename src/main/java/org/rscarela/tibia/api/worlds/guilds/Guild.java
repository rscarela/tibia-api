package org.rscarela.tibia.api.worlds.guilds;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.rscarela.tibia.api.players.Player;

public class Guild {

    private String name;
    private GuildDetails details;
    private List<Player> members;

    protected Guild() {
        this.members = new ArrayList<>();
    }

    public Guild(String name, GuildDetails details) {
        this();
        this.name = name;
        this.details = details;
    }

    public Guild(String name, GuildDetails details, List<Player> members) {
        this(name, details);
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return details.getDescription();
    }

    public String getOfficialHomePage() {
        return details.getOfficialHomePage();
    }

    public LocalDate getFoundingDate() {
        return details.getFoundingDate();
    }

    public boolean isActive() {
        return details.isActive();
    }

    public boolean isOpenedForApplications() {
        return details.isOpenedForApplications();
    }

    public List<Player> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public boolean isValid() {
        return name != null && !name.isBlank();
    }

}
