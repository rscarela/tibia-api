package org.rscarela.tibia.api.players;

import java.time.LocalDate;

public class GuildMembership {

	private String rank;
	private String guild;
	private String title;
	private LocalDate joiningDate;
	
	protected GuildMembership(){}

	public GuildMembership(String rank, String guild) {
		this.rank = rank;
		this.guild = guild;
	}

	public GuildMembership(String rank, String guild, String title, LocalDate joiningDate) {
		this(rank, guild);
		this.title = title;
		this.joiningDate = joiningDate;
	}

	public GuildMembership(String profileMembership) {
		if(profileMembership == null || profileMembership.isEmpty()) return;
		
		String[] membership = profileMembership.split(" of the ");
		this.rank = membership[0];
		this.guild = membership[1];
	}

	public String getRank() {
		return rank;
	}

	public String getGuild() {
		return guild;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}
}
