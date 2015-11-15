package KingOfTokyoModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class KingOfTokyo {

	// um durchiterieren zu können zwischen Spielern
	private List<Player> players;

	private Dice[] diceArray = new Dice[6];

	private GameState gameState;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	// für neue Züge
	private Player currentPlayer;

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
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

	public void loseLifePoints(Player player, int lifePoints) {

		int currentLifePoints = player.getLifePoints();
		player.setLifePoints(--currentLifePoints);
	}

	public void rollAllDices() {
		
		//definieren: dice ist jedes Element des DiceArray
		
		for (Dice dice : diceArray) {
			
		String diceValue = dice.rollDice();
		
		dice.setCurrentDiceValue(diceValue);
			
		}

	}

	public void heal(Player player, int lifePoints){
		
		int currentLifePoints = player.getLifePoints();
		
		player.setLifePoints(++currentLifePoints);
		
	}

	public void getWinner() {

		// Playerliste iterieren
		for (Player player : players) {

			if (player.getGloryPoints() == 20) {

				System.out.println(player + " is the winner!");
			}
		}

	}

}
