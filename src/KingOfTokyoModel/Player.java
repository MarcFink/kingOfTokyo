package KingOfTokyoModel;

import KingOfTokyo.ClientController;

public class Player {
	int playerId;
	String playername;
	private String gamename;
	private ClientController clientController;

	private int gloryPoints=0;
	private int lifePoints=20;

	public Player(ClientController clientController) {
		this.clientController=clientController;
		
	
		

	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return playername;
	}

	public void setName(String name) {
		this.playername = name;
	}

	public int getGloryPoints() {
		return gloryPoints;
	}

	public void setGloryPoints(int gloryPoints) {
		this.gloryPoints = gloryPoints;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int LifePoints) {
		this.lifePoints = LifePoints;
	}

	public String getGamename() {
		return gamename;
	}

	public void setGamename(String gamename) {
		this.gamename=gamename;
	}
}
