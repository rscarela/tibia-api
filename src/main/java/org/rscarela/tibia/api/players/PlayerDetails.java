package org.rscarela.tibia.api.players;

public class PlayerDetails {

	private Integer level;
	
	private String vocation;
	
	private Integer achievementPoints;

	protected PlayerDetails() {
		this.achievementPoints = 0;
	}
	
	public PlayerDetails(Integer level, String vocation) {
		this();
		this.level = level;
		this.vocation = vocation;
	}

	public PlayerDetails(Integer level, String vocation, Integer achievementPoints) {
		this(level, vocation);
		this.achievementPoints = achievementPoints;
	}

	public Integer getLevel() {
		return level;
	}

	public String getVocation() {
		return vocation;
	}

	public Integer getAchievementPoints() {
		return achievementPoints;
	}

	public void setAchievementPoints(Integer achievementPoints) {
		this.achievementPoints = achievementPoints;
	}
	
}
