package application.model;

import java.util.ArrayList;
import java.util.List;

public class GameBoardTwo {

	// List is used for for allowable moves
	// in the allowableMoves method
	List<Integer> list;
	
	int playerPiecesRemaining;
	int playerPiecesCompleted;
	int aiPiecesRemaining;
	int aiPiecesCompleted;

	//turnCounter == 0; player's turn
	//turnCounter == 1; ai's turn
	int turnCounter;
	int rollValue;

	int[] playerBoard;
	int[] aiBoard;

	public GameBoardTwo() {
		this.playerPiecesRemaining = 7;
		this.playerPiecesCompleted = 0;
		this.aiPiecesRemaining = 7;
		this.aiPiecesCompleted = 0;
		this.list = new ArrayList<>();
		this.turnCounter = 0;
		
		playerBoard = new int[16];
		aiBoard = new int[16];

	}

	public List<Integer> allowableMoves() {
		int roll = Dice.rollDice();
		this.rollValue = roll;
		
		if(roll == 0) {
			this.list.add(-1);
			return list;
		}
		
		if (this.turnCounter == 0) {
			if (this.playerBoard[roll] == 0 && this.playerPiecesRemaining > 0) {
				this.list.add(0);
			}
			for (int z = 1; z <= 14 && z + roll <= 15; z++) {
				if (this.playerBoard[z] == 1  && z + roll <= 15 && this.playerBoard[z + roll] == 0 && z + roll != 7) {
					this.list.add(z);
				} else if (this.playerBoard[z] == 1  && z + roll <= 15 && this.playerBoard[z + roll] == 0 && z + roll == 7 && this.aiBoard[7] == 0) {
					this. list.add(z);
				}
			}
		} 
		
		else if(this.turnCounter == 1) {
			if (this.aiBoard[roll] == 0 && this.aiPiecesRemaining > 0) {
				this.list.add(0);
			}
			
			for (int z = 1; z <= 14 && z + roll <= 15; z++) {
				if (this.aiBoard[z] == 1  && z + roll <= 15 && this.aiBoard[z + roll] == 0 && z + roll != 7) {
					this.list.add(z);
				} else if (this.aiBoard[z] == 1  && z + roll <= 15 && this.aiBoard[z + roll] == 0 && z + roll == 7 && this.playerBoard[7] == 0) {
					this.list.add(z);
				}
				
				
			}
		}

		return list;
	}

	/**
	 * @return the playerPiecesRemaining
	 */
	public int getPlayerPiecesRemaining() {
		return playerPiecesRemaining;
	}

	/**
	 * @param playerPiecesRemaining the playerPiecesRemaining to set
	 */
	public void setPlayerPiecesRemaining(int playerPiecesRemaining) {
		this.playerPiecesRemaining = playerPiecesRemaining;
	}

	/**
	 * @return the playerPiecesCompleted
	 */
	public int getPlayerPiecesCompleted() {
		return playerPiecesCompleted;
	}

	/**
	 * @param playerPiecesCompleted the playerPiecesCompleted to set
	 */
	public void setPlayerPiecesCompleted(int playerPiecesCompleted) {
		this.playerPiecesCompleted = playerPiecesCompleted;
	}

	/**
	 * @return the aiPiecesRemaining
	 */
	public int getAiPiecesRemaining() {
		return aiPiecesRemaining;
	}

	/**
	 * @param aiPiecesRemaining the aiPiecesRemaining to set
	 */
	public void setAiPiecesRemaining(int aiPiecesRemaining) {
		this.aiPiecesRemaining = aiPiecesRemaining;
	}

	/**
	 * @return the aiPiecesCompleted
	 */
	public int getAiPiecesCompleted() {
		return aiPiecesCompleted;
	}

	/**
	 * @param aiPiecesCompleted the aiPiecesCompleted to set
	 */
	public void setAiPiecesCompleted(int aiPiecesCompleted) {
		this.aiPiecesCompleted = aiPiecesCompleted;
	}

	/**
	 * @return the turnCounter
	 */
	public int getTurnCounter() {
		return turnCounter;
	}

	/**
	 * @param turnCounter the turnCounter to set
	 */
	public void setTurnCounter(int turnCounter) {
		this.turnCounter = turnCounter;
	}

	/**
	 * @return the rollValue
	 */
	public int getRollValue() {
		return rollValue;
	}

	/**
	 * @param rollValue the rollValue to set
	 */
	public void setRollValue(int rollValue) {
		this.rollValue = rollValue;
	}

	/**
	 * @return the playerBoard
	 */
	public int[] getPlayerBoard() {
		return playerBoard;
	}

	/**
	 * @param playerBoard the playerBoard to set
	 */
	public void setPlayerBoard(int[] playerBoard) {
		this.playerBoard = playerBoard;
	}

	/**
	 * @return the aiBoard
	 */
	public int[] getAiBoard() {
		return aiBoard;
	}

	/**
	 * @param aiBoard the aiBoard to set
	 */
	public void setAiBoard(int[] aiBoard) {
		this.aiBoard = aiBoard;
	}

	/**
	 * @return the list
	 */
	public List<Integer> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Integer> list) {
		this.list = list;
	}
}
