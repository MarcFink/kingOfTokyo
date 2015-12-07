package KingOfTokyoModel;

import java.io.Serializable;

import KingOfTokyo.ClientController;

public class Player implements Serializable {
	private int playerId;
	private String playername = null;
	private String gamename;
	private String monster;
	private boolean isInTokyo;
	private boolean isTurn;

	private int gloryPoints;
	private int lifePoints;

	public Player(int playerId) {
		this.playerId=playerId;
		
		lifePoints=20;
		gloryPoints=0;
		isTurn=false;
		isInTokyo=false;
		
		if (this.playerId == 1){ // Spieler 1 beginnt
			this.isTurn = true;
		//	this.isAufTokyo = true;
			
		}
		
		
		

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
		this.gamename = gamename;
	}

	public String getMonster() {

		return monster;
	}

	public void setMonster(String monster) {
		this.monster = monster;
	}

	public boolean isInTokyo() {
		return isInTokyo;
	}

	public void setInTokyo(boolean isInTokyo) {
		this.isInTokyo = isInTokyo;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	

	public String toString(){
		String id;
		id=String.valueOf(playerId);
		return id;
	}
}
