package org.rscarela.tibia.api.players;

public enum AccountStatus {

	FREE_ACCOUNT, PREMIUM_ACCOUNT;
	
	public static AccountStatus getStatusByName(String name) {
		if(name.equals("Free Account")) return AccountStatus.FREE_ACCOUNT;
		
		return AccountStatus.PREMIUM_ACCOUNT;
	}
	
}
