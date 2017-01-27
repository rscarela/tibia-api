package org.rscarela.tibia.api.players;

public class GuildMembership {

	private String rank;
	
	private String guild;
	
	protected GuildMembership(){}

	public GuildMembership(String rank, String guild) {
		this.rank = rank;
		this.guild = guild;
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
	
}