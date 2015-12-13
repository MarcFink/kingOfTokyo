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
	private static ArrayList<Player> playerlist;
	private static int playerTurn = 1;
	private static GameState instance = null;
	

	private GameState() {

	}

	public static synchronized GameState getInstance() {
		// Singleton, das Objekt wird nur einmal erstellt.
		if (instance == null) {
			instance = new GameState();
			playerlist=new ArrayList<Player>();
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


	public static int getPlayerTurn() {
		return playerTurn;
	}
	public void addPlayer(Integer client_id){
		if(client_id==1){
			Player player1=new Player();
			playerlist.add(player1);
		}if(client_id==2){
			Player player2=new Player();
			playerlist.add(player2);
		}
			
	}

	public static void setPlayerTurn(int playerTurn) {
		GameState.playerTurn = playerTurn;
	}

	public static ArrayList<Player> getPlayerlist() {
		return playerlist;
	}

	public static void setPlayerlist(ArrayList<Player> playerlist) {
		GameState.playerlist = playerlist;
	}

}
