package application.model;

import java.util.Random;

public class Dice {
	
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
