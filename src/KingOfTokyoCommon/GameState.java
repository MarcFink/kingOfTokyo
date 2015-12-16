package KingOfTokyoCommon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import KingOfTokyoClient.Player;

public class GameState implements Serializable {



	private boolean playerTurn1 = true;

	String playername1 = "player1";
	String playeroneglory = "0";
	String playeronelife = "10";

	String playername2 = "player2";
	String playertwoglory = "0";
	String playertwolife = "10";

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

	@Override
	public String toString() {
		return getPlayeroneglory() + " " +  " " + getPlayername1() + " " + getPlayername2() + " "
				+ getPlayertwoglory() + " " + getPlayeronelife() + " " + getPlayertwolife();
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

	public String getPlayeroneglory() {
		return playeroneglory;
	}

	public void setPlayeroneglory(String playeroneglory) {
		this.playeroneglory = playeroneglory;
	}

	public String getPlayeronelife() {
		return playeronelife;
	}

	public void setPlayeronelife(String playeronelife) {
		this.playeronelife = playeronelife;
	}

	public String getPlayertwoglory() {
		return playertwoglory;
	}

	public void setPlayertwoglory(String playertwoglory) {
		this.playertwoglory = playertwoglory;
	}

	public String getPlayertwolife() {
		return playertwolife;
	}

	public void setPlayertwolife(String playertwolife) {
		this.playertwolife = playertwolife;
	}

	public boolean isPlayerTurn1() {
		return playerTurn1;
	}

	public void setPlayerTurn1(boolean playerTurn1) {
		this.playerTurn1 = playerTurn1;
	}

}
