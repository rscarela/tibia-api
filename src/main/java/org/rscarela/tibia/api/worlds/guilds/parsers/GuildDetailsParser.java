package org.rscarela.tibia.api.worlds.guilds.parsers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.rscarela.tibia.api.worlds.guilds.GuildDetails;

public class GuildDetailsParser {

    private Supplier<Stream<String>> guildDetailsStream;
    private List<String> rawGuildDetails;

    public GuildDetailsParser(List<String> rawGuildDetails) {
        this.rawGuildDetails = rawGuildDetails;
        this.guildDetailsStream = () -> rawGuildDetails.stream();
    }

    public GuildDetailsParser(String[] rawGuildDetails) {
        this(List.of(rawGuildDetails));
    }

    public GuildDetails parse() {
        return new GuildDetails(
                getDescription(),
                getOfficialHomepage(),
                getFoundingDate(),
                isActive(),
                isOpenedForApplications()
        );
    }

    private String getDescription() {
        if (!hasDescription()) return null;

        return rawGuildDetails.get(0);
    }

    private LocalDate getFoundingDate() {
        Optional<String> foundedOn = guildDetailsStream
                .get()
                .filter(s -> s.contains("The guild was founded on"))
                .findFirst();

        String foundingDate = foundedOn.get().replaceAll("The guild was founded on .* on ", "").replace(". ", "").trim();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return LocalDate.parse(foundingDate, formatter);
    }

    private boolean isActive() {
        Optional<String> activeEntry = guildDetailsStream
                .get()
                .filter(s -> s.contains("It is currently active."))
                .findAny();

        return !activeEntry.isEmpty();
    }

    private boolean isOpenedForApplications() {
        Optional<String> openedEntry = guildDetailsStream
                .get()
                .filter(s -> s.equals("Guild is opened for applications."))
                .findAny();

        return !openedEntry.isEmpty();
    }

    private String getOfficialHomepage() {
        Optional<String> homepage = guildDetailsStream
                .get()
                .filter(s -> s.contains("The official homepage is at"))
                .findAny();

        return homepage.isEmpty() ? null : homepage.get().replace("The official homepage is at ", "");
    }

    private boolean hasDescription() {
        return guildDetailsStream
                .get()
                .filter(s -> s.equals(" "))
                .findAny()
                .isPresent();
    }

}
