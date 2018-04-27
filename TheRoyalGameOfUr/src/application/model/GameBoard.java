package application.model;

import java.util.ArrayList;
import java.util.List;

/**
 * GameBoard is the main model for the game. This class uses arrays to track the pieces on the gameboard, and 
 * processes player and ai moves based on the availability of spaces. 
 * @author David Thomas (github: vandorf594)
 *
 */
public class GameBoard {

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

	/**
	 * GameBoard constructor to create GameBoard objects. This contains the pieces remaining and completed
	 * for both player and ai, as well as the list of available moves for both player and ai.
	 */
	public GameBoard() {
		this.playerPiecesRemaining = 7;
		this.playerPiecesCompleted = 0;
		this.aiPiecesRemaining = 7;
		this.aiPiecesCompleted = 0;
		this.list = new ArrayList<>();
		this.turnCounter = 0;
		
		playerBoard = new int[16];
		aiBoard = new int[16];

	}

	/**
	 * allowableMoves will use arithmetic to process the player and ai moves, and update the array with a 1 or 0 whether 
	 * or not a piece occupies the space. Special consideration is taken for the '8' rosette square as a player or ai piece
	 * cannot be captured in that location.
	 * 
	 * @return List<Integer> updated list of pieces currently on the board.
	 */
	public List<Integer> allowableMoves() {
		int roll = Dice.rollDice();
		this.rollValue = roll;
		
		// if the roll returns a 0, add a -1 to the list
		if(roll == 0) {
			this.list.add(-1);
			return list;
		}
		
		if (this.turnCounter == 0) {
			if (this.playerBoard[roll] == 0 && this.playerPiecesRemaining > 0) {
				this.list.add(0);
			}
			for (int z = 1; z <= 14 && z + roll <= 15; z++) {
				if (this.playerBoard[z] == 1  && z + roll <= 15 && this.playerBoard[z + roll] == 0 && z + roll != 8) {
					this.list.add(z);
				} else if (this.playerBoard[z] == 1  && z + roll <= 15 && this.playerBoard[z + roll] == 0 && z + roll == 8 && this.aiBoard[8] == 0) {
					this. list.add(z);
				}
			}
		} 
		
		else if(this.turnCounter == 1) {
			if (this.aiBoard[roll] == 0 && this.aiPiecesRemaining > 0) {
				this.list.add(0);
			}
			
			for (int z = 1; z <= 14 && z + roll <= 15; z++) {
				if (this.aiBoard[z] == 1  && z + roll <= 15 && this.aiBoard[z + roll] == 0 && z + roll != 8) {
					this.list.add(z);
				} else if (this.aiBoard[z] == 1  && z + roll <= 15 && this.aiBoard[z + roll] == 0 && z + roll == 8 && this.playerBoard[8] == 0) {
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
