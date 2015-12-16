package KingOfTokyoCommon;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import KingOfTokyoClient.MapLocation;
import KingOfTokyoClient.Player;

public class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer, Player> players = new HashMap<Integer, Player>();
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
		if (players == null) {
			players = new HashMap<Integer, Player>();

		}
		Player player = new Player(playerId);
		players.put(playerId, player);
	}

	public Map<Integer, Player> getPlayers() {
		return players;
	}

	public void setPlayers(Map<Integer, Player> players) {
		this.players = players;
	}

	public void addGloryPoints(Player player, int gloryPoints) {

		// aktuelle Glorypoints
		int currentGloryPoints = player.getGloryPoints();

		// addiere die neuen Glorypoints
		player.setGloryPoints(gloryPoints + currentGloryPoints);
	}

	public void attack(Player player, int lifePoints) {

		int currentLifePoints = player.getLifePoints();
		// nimm Lebenspunkt weg
		player.setLifePoints(--currentLifePoints);

	}

	public Player getPlayer(int id) {
		return players.get(id);
	}

	public void loseLifePoints(Player player, int lifePoints) {

		int currentLifePoints = player.getLifePoints();
		player.setLifePoints(--currentLifePoints);
	}

	public boolean isPlayerTurn1() {
		return playerTurn1;
	}

	public void setPlayerTurn1(boolean playerTurn1) {
		this.playerTurn1 = playerTurn1;
	}

	public void heal(Player player, int lifePoints) {

		int currentLifePoints = player.getLifePoints();

		player.setLifePoints(++currentLifePoints);

	}

	public void getWinner() {

		// Playerliste iterieren
		for (Player player : players.values()) {

			if (player.getGloryPoints() == 20) {

				System.out.println(player + " is the winner!");
			}
		}

	}

	@Override
	public String toString() {
		StringBuffer stringVal = new StringBuffer();

		for (Player player : players.values()) {
			stringVal.append("Player Name: " + player.getPlayername() + " Life points: " + player.getLifePoints()
					+ " Glory points: " + player.getGloryPoints() + "\n");
		}
		stringVal.append("Current location:  " + location.name());
		return stringVal.toString();
	}

}
