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
	
	
	
	private static String playername1="player1";
	private static int playeroneglory=0;
	private static int playeronelife=10;
	
	private static String playername2="player2";
	private static int playertwoglory=0;
	private static int playertwolife=10;
	
	private static GameState instance = null;
	

	private GameState() {

	}

	public static synchronized GameState getInstance() {
		// Singleton, das Objekt wird nur einmal erstellt.
		if (instance == null) {
			instance = new GameState();
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
	


	@Override
	public String toString() {
		return getPlayeroneglory()+" "+getPlayerTurn()+" "+getPlayername1()+" "+getPlayername2()+
				" "+getPlayertwoglory()+" "+getPlayeronelife()+" "+getPlayertwolife();
	}

	public static int getPlayerTurn() {
		return playerTurn;
	}

	

	public static void setPlayerTurn(int playerTurn) {
		GameState.playerTurn = playerTurn;
	}


	public static String getPlayername1() {
		return playername1;
	}

	public static void setPlayername1(String playername1) {
		GameState.playername1 = playername1;
	}

	public static String getPlayername2() {
		return playername2;
	}

	public static void setPlayername2(String playername2) {
		GameState.playername2 = playername2;
	}

	public static int getPlayeroneglory() {
		return playeroneglory;
	}

	public static void setPlayeroneglory(int playeroneglory) {
		GameState.playeroneglory = playeroneglory;
	}

	public static int getPlayeronelife() {
		return playeronelife;
	}

	public static void setPlayeronelife(int playeronelife) {
		GameState.playeronelife = playeronelife;
	}

	public static int getPlayertwoglory() {
		return playertwoglory;
	}

	public static void setPlayertwoglory(int playertwoglory) {
		GameState.playertwoglory = playertwoglory;
	}

	public static int getPlayertwolife() {
		return playertwolife;
	}

	public static void setPlayertwolife(int playertwolife) {
		GameState.playertwolife = playertwolife;
	}

}
