package org.rscarela.tibia.api.players;

public class Residence {

	private String city;
	
	private String house;
	
	protected Residence(){}

	public Residence(String city) {
		this.city = city;
	}
	
	public Residence(String city, String house) {
		this(city);
		this.house = house;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}
	
}
