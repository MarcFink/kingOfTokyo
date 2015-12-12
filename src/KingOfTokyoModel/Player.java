package KingOfTokyoModel;

import java.io.Serializable;

import KingOfTokyo.ClientView;

public class Player implements Serializable {
	private int playerId;
	private boolean isInTokyo=false;
	private boolean isTurn=false;
	private String playername;
	private String monster;

	private int gloryPoints=0;
	private int lifePoints=10;

	public Player(int playerId) {
		this.playerId=playerId;
	
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

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}
}
