package KingOfTokyoClient;

import java.util.Random;

public class Dice {
	/* 
	 * @author Fink Marc
	 * */

	private String[] symbols = { "1", "2", "3", "A", "H" };
	private String currentDiceValue;

	public Dice() {

	}

	public String rollDice() {
		int diceValue = new Random().nextInt(symbols.length);
		String random = (symbols[diceValue]);

		return random;
	}

	public String[] getSymbols() {
		return symbols;
	}

	public void setSymbols(String[] symbols) {
		this.symbols = symbols;
	}

	public String getCurrentDiceValue() {
		return currentDiceValue;
	}

	//aufrufen von mainlogic setCurrent
	public void setCurrentDiceValue(String currentDiceValue) {
		this.currentDiceValue = currentDiceValue;
	}

}
