package org.rscarela.tibia.api.players;

public class PlayerDetails {

	private Integer level;
	
	private String vocation;
	
	private Integer achievementPoints;

	private String comment;
	
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
