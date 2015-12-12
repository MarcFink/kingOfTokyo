package KingOfTokyoModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	static Map<Integer, Player> playerlist;
	private static int numofGloryPointsPlayer1 = 0;
	private static int numofLifePointsPlayer1 = 20;
	private static boolean inTokyoPlayer1 = false;
	private static int numofGloryPointsPlayer2 = 0;
	private static int numofLifePointsPlayer2 = 20;
	private static boolean inTokyoPlayer2 = false;
	private static int player1isTurn = 1;
	private int playerid;
	private Player player;
	private static GameState instance = null;

	private GameState() {

	}

	public static synchronized GameState getInstance() {
		// Singleton, das Objekt wird nur einmal erstellt.
		if (instance == null) {

			instance = new GameState();
			instance.playerlist = new HashMap<Integer, Player>();
			System.out.println("GameState wurde erstellt");
		}
		return instance;
	}

	public static void setInstance(GameState gamestate) {
		// Singleton, das Objekt wird nur einmal erstellt.
		synchronized (instance) {
			instance = gamestate;
		}
	}

	public String toString() {
		return getNumofGloryPointsPlayer1() + " " + getNumofLifePointsPlayer1() + " " + isInTokyoPlayer1() + " "
				+ getNumofGloryPointsPlayer2() + " " + getNumofLifePointsPlayer2() + " " + isInTokyoPlayer2();

	}

	public static int getNumofGloryPointsPlayer1() {
		synchronized (instance) {
			return numofGloryPointsPlayer1;
		}
	}

	public static void setNumofGloryPointsPlayer1(int numofGloryPointsPlayer1) {
		synchronized (instance) {
			GameState.numofGloryPointsPlayer1 = numofGloryPointsPlayer1;
		}
	}

	public static int getNumofLifePointsPlayer1() {
		synchronized (instance) {
			return numofLifePointsPlayer1;
		}
	}

	public static void setNumofLifePoints(int numofLifePoints, int playerid) {
		synchronized (instance) {
			GameState.numofLifePointsPlayer1 = numofLifePointsPlayer1;
			Player currentPlayer = playerlist.get(playerid);
			currentPlayer.setLifePoints(numofLifePoints);
		}
	}

	public static boolean isInTokyoPlayer1() {
		return inTokyoPlayer1;
	}

	public static void setInTokyoPlayer1(boolean inTokyoPlayer1) {
		synchronized (instance) {
			GameState.inTokyoPlayer1 = inTokyoPlayer1;
		}
	}

	public static int getNumofGloryPointsPlayer2() {
		synchronized (instance) {
			return numofGloryPointsPlayer2;
		}
	}

	public static void setNumofGloryPointsPlayer2(int numofGloryPointsPlayer2) {
		synchronized (instance) {
			GameState.numofGloryPointsPlayer2 = numofGloryPointsPlayer2;
		}
	}

	public static int getNumofLifePointsPlayer2() {
		synchronized (instance) {
			return numofLifePointsPlayer2;
		}
	}

	public static void setNumofLifePointsPlayer2(int numofLifePointsPlayer2) {
		synchronized (instance) {
			GameState.numofLifePointsPlayer2 = numofLifePointsPlayer2;
		}
	}

	public static boolean isInTokyoPlayer2() {
		return inTokyoPlayer2;
	}

	public static void setInTokyoPlayer2(boolean inTokyoPlayer2) {
		synchronized (instance) {
			GameState.inTokyoPlayer2 = inTokyoPlayer2;
		}
	}

	public void addPlayer(int client_id) {
		// Jedes mal wenn ein Client erstellt wird wird mit der ClientID ein
		// neues Playerobjekt erstellt.
		this.playerid = client_id;
		player = new Player(playerid);
		GameState.playerlist.put(playerid, player);
		System.out.println(playerid);
	}

	public static Map<Integer, Player> getPlayerlist() {
		synchronized (instance) {
			return playerlist;
		}
	}

	public static void setPlayerlist(Map<Integer, Player> playerlist) {
		synchronized (instance) {
			GameState.playerlist = playerlist;
		}
	}

	public int getPlayerid() {
		synchronized (instance) {
			return playerid;
		}
	}

	public void setPlayerid(int playerid) {
		synchronized (instance) {
			this.playerid = playerid;
		}
	}

	public static int getPlayer1isTurn() {
		synchronized (instance) {
			return player1isTurn;
		}
	}

	public static void setPlayer1isTurn(int player1isTurn) {
		synchronized (instance) {
			GameState.player1isTurn = player1isTurn;
		}
	}

}
