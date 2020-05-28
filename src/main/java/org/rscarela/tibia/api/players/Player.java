package org.rscarela.tibia.api.players;

import org.rscarela.tibia.api.worlds.World;

public class Player {

	private Long id;
	
	private String name;
	
	private World world;
	
	private AccountStatus accountStatus;
	
	private PlayerDetails details;

	private Residence residence;
	
	private GuildMembership guildMembership;

	protected Player() {
		this.residence = new Residence();
	}
	
	public Player(String name, World world, Integer level, String vocation) {
		this();
		this.name = name;
		this.world = world;
		this.details = new PlayerDetails(level, vocation);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public World getWorld() {
		return world;
	}

	public PlayerDetails getDetails() {
		return details;
	}
	
	public void setAchievementPoints(Integer achievementPoints) {
		details.setAchievementPoints(achievementPoints);
	}
	
	public void setResidence(String city) {
		residence.setCity(city);
	}
	
	public void setHouse(String house) {
		residence.setHouse(house);
	}

	public void setGuildMembership(GuildMembership guildMembership) {
		this.guildMembership = guildMembership;
	}

	public void setGuildMembership(String membership) {
		this.guildMembership = new GuildMembership(membership);
	}


	public GuildMembership getGuildMembership() {
		return guildMembership;
	}
	
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = AccountStatus.getStatusByName(accountStatus);
	}

	public boolean isValidPlayer() {
		return name != null;
	}
	
	public void setComment(String comment) {
		details.setComment(comment);
	}
	
}
