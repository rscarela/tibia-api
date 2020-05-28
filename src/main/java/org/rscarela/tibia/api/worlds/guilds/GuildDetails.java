package org.rscarela.tibia.api.worlds.guilds;

import java.time.LocalDate;

public class GuildDetails {

    private String description;
    private String officialHomePage;
    private LocalDate foundingDate;
    private boolean active;
    private boolean openedForApplications;

    public GuildDetails(String description) {
        this.description = description;
    }

    public GuildDetails(String description, String officialHomePage, LocalDate foundingDate,
            boolean active, boolean openedForApplications) {
        this(description);
        this.officialHomePage = officialHomePage;
        this.foundingDate = foundingDate;
        this.active = active;
        this.openedForApplications = openedForApplications;
    }

    public String getDescription() {
        return description;
    }

    public String getOfficialHomePage() {
        return officialHomePage;
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isOpenedForApplications() {
        return openedForApplications;
    }

}
