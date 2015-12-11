package KingOfTokyoModel;

import java.io.Serializable;
import java.util.ArrayList;





public class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	static GameState gamestate;
	static ArrayList<Player> playerlist;
	private static int numofGloryPointsPlayer1 = 0;
	private static int numofLifePointsPlayer1 = 20;
	private static boolean inTokyoPlayer1 = false;
	private static int numofGloryPointsPlayer2 = 0;
	private static int numofLifePointsPlayer2 = 20;
	private static boolean inTokyoPlayer2 = false;
	private static int player1isTurn=1;
	private int playerid;
	private Player player;

	public GameState() {

	
		
	}

	public static synchronized GameState getGameState() {
		//Singleton, das Objekt wird nur einmal erstellt. 
		if (GameState.gamestate == null) {
			GameState.gamestate = new GameState();
			GameState.playerlist = new ArrayList<Player>();
			System.out.println("GameState erstellt");
		}
		return gamestate;
	}
	
	public static void setGameState(GameState gamestate){
		GameState.gamestate=gamestate;
	}

	public String toString() {
		return getNumofGloryPointsPlayer1() + " " + getNumofLifePointsPlayer1() + " " + isInTokyoPlayer1() + " "
				+ getNumofGloryPointsPlayer2() + " " + getNumofLifePointsPlayer2() + " " + isInTokyoPlayer2();

	}

	public static int getNumofGloryPointsPlayer1() {
		return numofGloryPointsPlayer1;
	}

	public static void setNumofGloryPointsPlayer1(int numofGloryPointsPlayer1) {
		GameState.numofGloryPointsPlayer1 = numofGloryPointsPlayer1;
	}

	public static int getNumofLifePointsPlayer1() {
		return numofLifePointsPlayer1;
	}

	public static void setNumofLifePointsPlayer1(int numofLifePointsPlayer1) {
		GameState.numofLifePointsPlayer1 = numofLifePointsPlayer1;
	}

	public static boolean isInTokyoPlayer1() {
		return inTokyoPlayer1;
	}

	public static void setInTokyoPlayer1(boolean inTokyoPlayer1) {
		GameState.inTokyoPlayer1 = inTokyoPlayer1;
	}

	public static int getNumofGloryPointsPlayer2() {
		return numofGloryPointsPlayer2;
	}

	public static void setNumofGloryPointsPlayer2(int numofGloryPointsPlayer2) {
		GameState.numofGloryPointsPlayer2 = numofGloryPointsPlayer2;
	}

	public static int getNumofLifePointsPlayer2() {
		return numofLifePointsPlayer2;
	}

	public static void setNumofLifePointsPlayer2(int numofLifePointsPlayer2) {
		GameState.numofLifePointsPlayer2 = numofLifePointsPlayer2;
	}

	public static boolean isInTokyoPlayer2() {
		return inTokyoPlayer2;
	}

	public static void setInTokyoPlayer2(boolean inTokyoPlayer2) {
		GameState.inTokyoPlayer2 = inTokyoPlayer2;
	}

	public void addPlayer(int client_id) {
		//Jedes mal wenn ein Client erstellt wird wird mit der ClientID ein neues Playerobjekt erstellt.
		this.playerid=client_id;
		player=new Player(playerid);
		GameState.playerlist.add(player);
		System.out.println(playerid);
	}

	public ArrayList<Player> getPlayerlist() {
		return playerlist;
	}

	public void setPlayerlist(ArrayList<Player> playerlist) {
		GameState.playerlist = playerlist;
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public static int getPlayer1isTurn() {
		return player1isTurn;
	}

	public static void setPlayer1isTurn(int player1isTurn) {
		GameState.player1isTurn = player1isTurn;
	}
	
	
		
	}

