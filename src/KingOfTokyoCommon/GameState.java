package KingOfTokyoCommon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import KingOfTokyoClient.MapLocation;
import KingOfTokyoClient.Player;

public class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Player> players = new ArrayList<Player>();
	boolean playerTurn1 = true;
	MapLocation location = MapLocation.insideTokyo;

	private static GameState instance = null;

	private GameState() {

	}

	public static synchronized GameState getInstance() {
		// Singleton, das Objekt wird nur einmal erstellt.
		if (GameState.instance == null) {
			GameState.instance = new GameState();
			System.out.println("GameState wurde erstellt");
		}
		return GameState.instance;
	}

	public static void setInstance(GameState w) {
		GameState.instance = w;
	}

	public void addPlayer(int playerId) {

		Player player = new Player(playerId);
		this.players.add(player);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void attack(int playerID) {

		int currentLifePoints = this.getPlayer(playerID).getLifePoints();
		currentLifePoints -= 1;
		// nimm Lebenspunkt weg
		this.getPlayer(playerID).setLifePoints(currentLifePoints);
		System.out.println("Current life points of player " + this.getPlayer(playerID).getPlayername() + " is "
				+ currentLifePoints);

	}

	public void heal(int playerID) {
		int currentLifePoints = this.getPlayer(playerID).getLifePoints();
		currentLifePoints += 1;
		this.getPlayer(playerID).setLifePoints(currentLifePoints);
		System.out.println("Current life points of player " + this.getPlayer(playerID).getPlayername() + " is "
				+ currentLifePoints);
	}

	public Player getPlayer(int id) {

		for (Player player : players) {
			if (player.getPlayerId() == id) {
				return player;
			}
		}
		return new Player(id);
	}

	public boolean isPlayerTurn1() {
		return playerTurn1;
	}

	public void setPlayerTurn1(boolean playerTurn1) {
		this.playerTurn1 = playerTurn1;
	}

	public void getWinner() {

		// Playerliste iterieren
		for (Player player : players) {

			if (player.getGloryPoints() == 20) {

				System.out.println(player + " is the winner!");
			}
		}

	}

	@Override
	public String toString() {
		StringBuffer stringVal = new StringBuffer();

		for (Player player : players) {
			stringVal.append("Player Name: " + player.getPlayername() + " Life points: " + player.getLifePoints()
					+ " Glory points: " + player.getGloryPoints() + "\n");
		}
		stringVal.append("Current location:  " + location.name());
		return stringVal.toString();
	}

}
