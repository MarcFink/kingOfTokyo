package KingOfTokyoModel;

public class Player {
	int playerId;
	String name;

	private int gloryPoints=0;
	private int lifePoints=20;

	public Player() {

	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGloryPoints() {
		this.gloryPoints=gloryPoints;
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
}
