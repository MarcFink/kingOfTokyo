package KingOfTokyoModel;

import java.io.Serializable;
import java.util.ArrayList;





public class GameState implements Serializable {

	/**
	 * 
	 */
	static GameState gamestate;
	ArrayList<Player> playerlist;
	private static int numofGloryPointsPlayer1 = 0;
	private static int numofLifePointsPlayer1 = 20;
	private static boolean inTokyoPlayer1 = false;
	private static int numofGloryPointsPlayer2 = 0;
	private static int numofLifePointsPlayer2 = 20;
	private static boolean inTokyoPlayer2 = false;
	private static int isTurn=1;
	private int playerid;

	public GameState() {

	
		
	}

	public static synchronized GameState getGameState() {
		if (GameState.gamestate == null) {
			GameState.gamestate = new GameState();
			gamestate.playerlist = new ArrayList<Player>();
		}
		return GameState.gamestate;
	}
	
	public static void setGameState(GameState gs){
		GameState.gamestate=gs;
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
		this.playerid=client_id;
		Player player = new Player(playerid);

		this.playerlist.add(player);
		System.out.println(player.toString());
		
	}

	public ArrayList<Player> getPlayerlist() {
		return playerlist;
	}

	public void setPlayerlist(ArrayList<Player> playerlist) {
		this.playerlist = playerlist;
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}
	

}