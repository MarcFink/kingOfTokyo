package KingOfTokyoModel;

public class GameState {
	
	private int numofGloryPoints;
	private int numofLifePoints;
	private int playerId;

	public GameState(){
		
	}

	public int getNumofGloryPoints() {
		return numofGloryPoints;
	}

	public void setNumofGloryPoints(int numofGloryPoints) {
		this.numofGloryPoints = numofGloryPoints;
	}

	public int getNumofLifePoints() {
		return numofLifePoints;
	}

	public void setNumofLifePoints(int numofLifePoints) {
		this.numofLifePoints = numofLifePoints;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
}
