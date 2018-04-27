package application.model;

import java.util.Random;

/**
 * Dice will generate a random dice roll for the game. The Random util is used to generate four numbers
 * between 1 and 0. The total of all four rolls totals to the players actual roll.
 * 
 * @author Jared Andrzejewski (github: JaredAndrz)
 *
 */
public class Dice {
	
	/**
	 * rollDice generates four random rolls between 1 and 0 and returns an int value of the four rolls summed.
	 * @return int value of the four dice rolls summed.
	 */
	public static int rollDice() {
		int rollTotal = 0;
		int rollCounter = 0;
		Random rand = new Random();
		for (int i = 0; i < 4; i++) {
			rollCounter = rand.nextInt(2);
			rollTotal += rollCounter;
		}
		return rollTotal;
	}
}
