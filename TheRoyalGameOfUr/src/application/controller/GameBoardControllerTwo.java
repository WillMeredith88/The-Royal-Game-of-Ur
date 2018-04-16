/**
 * 
 * TODO: add in win conditions to the appropriate methods
 * 		 add in advanced AI logic
 *		 add extra roll for landing on special spaces
 *		 change tileHandler method to handle method
 */

package application.controller;

import java.util.HashMap;
import java.util.List;

import application.Main;
import application.model.GameBoardTwo;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GameBoardControllerTwo implements EventHandler<ActionEvent> {

	@FXML
	private Button zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton,
			eightButton, nineButton, tenButton, elevenButton, twelveButton, thirteenButton, fourteenButton;

	@FXML
	private ImageView token_player_0, token_player_1, token_player_2, token_player_3, token_player_4, token_player_5,
			token_player_6, token_player_7, token_player_8, token_player_9, token_player_10, token_player_11,
			token_player_12, token_player_13, token_player_14;

	@FXML
	private ImageView token_ai_0, token_ai_1, token_ai_2, token_ai_3, token_ai_4, token_ai_5, token_ai_6, token_ai_7,
			token_ai_8, token_ai_9, token_ai_10, token_ai_11, token_ai_12, token_ai_13, token_ai_14;

	@FXML
	private Button diceRollButton;

	@FXML
	private Label diceRollLabel, diceRollLabelAI, beginLabel, beginLabelAI, completeLabel, completeLabelAI,
			turnNotification, turnNotificationAI, turnTracker;

	/**
	 * Hashmaps that store Buttons, and the images for tokens of pieces. Button 0 is
	 * stored at key 0... etc.
	 */
	private HashMap<Integer, Button> buttonHashmap;

	private HashMap<Integer, ImageView> playerTokenHashmap;

	private HashMap<Integer, ImageView> aiTokenHashmap;

	GameBoardTwo gameBoard;

	@FXML
	protected void GoMenu() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/TitleScreen.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("Main Page");

	}

	@FXML
	public void initialize() {

		gameBoard = new GameBoardTwo();

		/**
		 * initializing and filling the hashmaps with the buttons and images.
		 */
		buttonHashmap = new HashMap<Integer, Button>();
		playerTokenHashmap = new HashMap<Integer, ImageView>();
		aiTokenHashmap = new HashMap<Integer, ImageView>();

		// Placing the buttons into buttonHashmap
		buttonHashmap.put(0, zeroButton);
		buttonHashmap.put(1, oneButton);
		buttonHashmap.put(2, twoButton);
		buttonHashmap.put(3, threeButton);
		buttonHashmap.put(4, fourButton);
		buttonHashmap.put(5, fiveButton);
		buttonHashmap.put(6, sixButton);
		buttonHashmap.put(7, sevenButton);
		buttonHashmap.put(8, eightButton);
		buttonHashmap.put(9, nineButton);
		buttonHashmap.put(10, tenButton);
		buttonHashmap.put(11, elevenButton);
		buttonHashmap.put(12, twelveButton);
		buttonHashmap.put(13, thirteenButton);
		buttonHashmap.put(14, fourteenButton);

		// Placing the player token images into the playerTokenHashmap
		playerTokenHashmap.put(0, token_player_0);
		playerTokenHashmap.put(1, token_player_1);
		playerTokenHashmap.put(2, token_player_2);
		playerTokenHashmap.put(3, token_player_3);
		playerTokenHashmap.put(4, token_player_4);
		playerTokenHashmap.put(5, token_player_5);
		playerTokenHashmap.put(6, token_player_6);
		playerTokenHashmap.put(7, token_player_7);
		playerTokenHashmap.put(8, token_player_8);
		playerTokenHashmap.put(9, token_player_9);
		playerTokenHashmap.put(10, token_player_10);
		playerTokenHashmap.put(11, token_player_11);
		playerTokenHashmap.put(12, token_player_12);
		playerTokenHashmap.put(13, token_player_13);
		playerTokenHashmap.put(14, token_player_14);

		// Placing the AI token images into the aiTokenHashmap
		aiTokenHashmap.put(0, token_ai_0);
		aiTokenHashmap.put(1, token_ai_1);
		aiTokenHashmap.put(2, token_ai_2);
		aiTokenHashmap.put(3, token_ai_3);
		aiTokenHashmap.put(4, token_ai_4);
		aiTokenHashmap.put(5, token_ai_5);
		aiTokenHashmap.put(6, token_ai_6);
		aiTokenHashmap.put(7, token_ai_7);
		aiTokenHashmap.put(8, token_ai_8);
		aiTokenHashmap.put(9, token_ai_9);
		aiTokenHashmap.put(10, token_ai_10);
		aiTokenHashmap.put(11, token_ai_11);
		aiTokenHashmap.put(12, token_ai_12);
		aiTokenHashmap.put(13, token_ai_13);
		aiTokenHashmap.put(14, token_ai_14);

		// Cleans the board up to start the game
		boardUpdate();

		/*
		 * if (gameBoard.getAiPiecesCompleted() == 7) { System.out.println("You lose!");
		 * } else if(gameBoard.getPlayerPiecesCompleted() == 7) {
		 * System.out.println("You win!"); }
		 */
	}

	public void diceRoll(ActionEvent event) {

		// This will roll the dice and find the allowable moves
		gameBoard.allowableMoves();
		// System.out.println(gameBoard.getRollValue());

		// Updates the screen with allowable moves and enables the appropriate buttons
		// If the roll value is 0, nothing to update and moves on
		if (gameBoard.getRollValue() != 0) {
			showMoves();
			diceRollButton.setDisable(true);
		} else if (gameBoard.getRollValue() == 0) {
			diceRollLabel.setText(Integer.toString(gameBoard.getRollValue()));
			diceRollButton.setDisable(true);
			processAITurn();
			diceRollButton.setDisable(false);
		}
		// Disables the roll button so only allowable moves buttons are able to be
		// clicked
		// diceRollButton.setDisable(true);
	}

	public void tileHandler(ActionEvent event) {
		Button selected = (Button) event.getSource();
		// Player's turn if getTurnCounter returns 0
		if (gameBoard.getTurnCounter() == 0) {
			for (HashMap.Entry<Integer, Button> entry : buttonHashmap.entrySet()) {
				// Used to access key in the loop => Integer key = entry.getKey();
				// Used to access button in the loop => Button value = entry.getValue();
				// selected.getId()
				if (entry.getValue().equals(selected)) {
					gameBoard.getPlayerBoard()[entry.getKey()] = 0;
					if (entry.getKey() + gameBoard.getRollValue() < 15) {
						gameBoard.getPlayerBoard()[entry.getKey() + gameBoard.getRollValue()] = 1;

						if (entry.getKey() + gameBoard.getRollValue() > 4
								&& entry.getKey() + gameBoard.getRollValue() < 13) {

							if (gameBoard.getAiBoard()[entry.getKey() + gameBoard.getRollValue()] == 1) {
								gameBoard.getAiBoard()[entry.getKey() + gameBoard.getRollValue()] = 0;
								gameBoard.setAiPiecesRemaining(gameBoard.getAiPiecesRemaining() + 1);
							}
						}

					} else if (entry.getKey() + gameBoard.getRollValue() == 15) {
						gameBoard.setPlayerPiecesCompleted(gameBoard.getPlayerPiecesCompleted() + 1);
					}
				}

			}
			if (buttonHashmap.get(0).equals(selected)) {
				gameBoard.setPlayerPiecesRemaining(gameBoard.getPlayerPiecesRemaining() - 1);
			}
		}
		boardUpdate();
		diceRollButton.setDisable(true);
		processAITurn();
		diceRollButton.setDisable(false);
	}

	public void showMoves() {

		if (gameBoard.getTurnCounter() == 0) {
			for (Integer allowable : gameBoard.getList()) {
				if (allowable != null && allowable != -1) {
					buttonHashmap.get(allowable).setOpacity(.5);
					buttonHashmap.get(allowable).setDisable(false);

				}
			}
		}

		gameBoard.getList().clear();
		if (gameBoard.getTurnCounter() == 0) {
			diceRollLabel.setText(Integer.toString(gameBoard.getRollValue()));
		} else if (gameBoard.getTurnCounter() == 1) {
			diceRollLabelAI.setText(Integer.toString(gameBoard.getRollValue()));
		}
	}

	public void boardUpdate() {
		for (int z = 0; z <= 14; z++) {
			if (gameBoard.getPlayerBoard()[z] == 1) {
				playerTokenHashmap.get(z).setVisible(true);
			} else if (gameBoard.getPlayerBoard()[z] == 0) {
				playerTokenHashmap.get(z).setVisible(false);
			}

			if (gameBoard.getAiBoard()[z] == 1) {
				aiTokenHashmap.get(z).setVisible(true);
			} else if (gameBoard.getAiBoard()[z] == 0) {
				aiTokenHashmap.get(z).setVisible(false);
			}
			buttonHashmap.get(z).setOpacity(0);
			buttonHashmap.get(z).setDisable(true);
		}
		beginLabelAI.setText(Integer.toString(gameBoard.getAiPiecesRemaining()));
		completeLabelAI.setText(Integer.toString(gameBoard.getAiPiecesCompleted()));
		beginLabel.setText(Integer.toString(gameBoard.getPlayerPiecesRemaining()));
		completeLabel.setText(Integer.toString(gameBoard.getPlayerPiecesCompleted()));
		diceRollButton.setDisable(false);

	}

	public void processAITurn() {
		PauseTransition pause = new PauseTransition(Duration.millis(1000));
		PauseTransition pieceDelay = new PauseTransition(Duration.millis(1000));
		PauseTransition pauseTurnLabel = new PauseTransition(Duration.millis(1500));
		PauseTransition enableRollButton = new PauseTransition(Duration.millis(1500));
		gameBoard.setTurnCounter(1);
		gameBoard.allowableMoves();
		diceRollLabelAI.setText(Integer.toString(gameBoard.getRollValue()));

		// Used to store the Ai token that is closest to the end that can move
		int farthestMove = -1;

		if (gameBoard.getRollValue() != 0) {

			for (Integer allowable : gameBoard.getList()) {
				if (allowable != null && allowable != -1) {
					if (allowable > farthestMove) {
						farthestMove = allowable;
					}
				}
			}
			if (farthestMove == 0) {
				gameBoard.setAiPiecesRemaining(gameBoard.getAiPiecesRemaining() - 1);
			}
			gameBoard.getAiBoard()[farthestMove] = 0;
			
			if(farthestMove + gameBoard.getRollValue() < 15 ) {
			gameBoard.getAiBoard()[farthestMove + gameBoard.getRollValue()] = 1;
			} else if(farthestMove + gameBoard.getRollValue() == 15) {
				gameBoard.setAiPiecesCompleted(gameBoard.getAiPiecesCompleted() + 1);
			}
			
			if (farthestMove + gameBoard.getRollValue() > 4 && farthestMove + gameBoard.getRollValue() < 13) {

				if (gameBoard.getPlayerBoard()[farthestMove + gameBoard.getRollValue()] == 1) {
					gameBoard.getPlayerBoard()[farthestMove + gameBoard.getRollValue()] = 0;
					gameBoard.setPlayerPiecesRemaining(gameBoard.getPlayerPiecesRemaining() + 1);
				}
			}
			// pause.setOnFinished(event -> token_ai_2.setVisible(true));
			// pause.play();
			// pauseTurnLabel.setOnFinished(event -> turnTracker.setText("Player"));
			// pauseTurnLabel.play();
			// enableRollButton.setOnFinished(event -> diceRollButton.setDisable(false));
			// enableRollButton.play();
		} else if (gameBoard.getRollValue() == 0) {
			// What to do if the AI rolls a 0, if anything.
		}

		boardUpdate();
		gameBoard.setTurnCounter(0);
		gameBoard.getList().clear();
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}