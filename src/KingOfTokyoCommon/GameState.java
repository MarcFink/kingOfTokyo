package KingOfTokyoCommon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import KingOfTokyoClient.Player;

public class GameState implements Serializable {

	/**
	 * 
	 */

	/**
	 * 
	 */

	private static int playerTurn = 1;

	String playername1 = "player1";
	int playeroneglory = 0;
	int playeronelife = 10;

	String playername2 = "player2";
	int playertwoglory = 0;
	int playertwolife = 10;

	private static GameState instance = null;

	private GameState() {

	}

	public static GameState getInstance() {
		// Singleton, das Objekt wird nur einmal erstellt.
		if (GameState.instance == null) {
			GameState.instance = new GameState();
			System.out.println("GameState wurde erstellt");
		}
		return GameState.instance;
	}

	public static void setInstance(GameState gamestate) {
		// Singleton, das Objekt wird nur einmal erstellt.
		synchronized (instance) {
			instance = gamestate;
		}
	}

	@Override
	public String toString() {
		return getPlayeroneglory() + " " + getPlayerTurn() + " " + getPlayername1() + " " + getPlayername2() + " "
				+ getPlayertwoglory() + " " + getPlayeronelife() + " " + getPlayertwolife();
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(int playerTurn) {
		GameState.playerTurn = playerTurn;
	}

	public String getPlayername1() {
		return playername1;
	}

	public void setPlayername1(String playername1) {
		this.playername1 = playername1;
	}

	public String getPlayername2() {
		return playername2;
	}

	public void setPlayername2(String playername2) {
		this.playername2 = playername2;
	}

	public int getPlayeroneglory() {
		return playeroneglory;
	}

	public void setPlayeroneglory(int playeroneglory) {
		playeroneglory = playeroneglory;
	}

	public int getPlayeronelife() {
		return playeronelife;
	}

	public void setPlayeronelife(int playeronelife) {
		playeronelife = playeronelife;
	}

	public int getPlayertwoglory() {
		return playertwoglory;
	}

	public void setPlayertwoglory(int playertwoglory) {
		playertwoglory = playertwoglory;
	}

	public int getPlayertwolife() {
		return playertwolife;
	}

	public void setPlayertwolife(int playertwolife) {
		playertwolife = playertwolife;
	}

}
