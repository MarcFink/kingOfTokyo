package KingOfTokyoClient;

import java.io.Serializable;

public class Player implements Serializable {
	/*
	 * @author Mäder David
	 */
	private static final long serialVersionUID = 1L;
	private int playerId;
	private boolean isInTokyo;
	private String playername = "";
	private String monster;
	private int gloryPoints = 0;
	private int lifePoints = 10;

	public Player(int playerId) {
		this.playerId = playerId;
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

	public String toString() {
		String id;
		id = String.valueOf(playerId);
		return id;
	}

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public void addGloryPoints(int points) {
		this.gloryPoints += points;
	}
}
