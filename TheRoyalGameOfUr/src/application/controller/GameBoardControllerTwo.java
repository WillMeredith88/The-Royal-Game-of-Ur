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

	private int turnCounter = 0;

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

		token_ai_5.setVisible(true);
		beginLabelAI.setText("6");
		
		
		//This is using the BoardUpdate method.  Without it you'll see how we set up the demo
		//If you uncomment this you'll see everything cleaned up because no actual moves have been made on the board.
		//boardUpdate();
		
	}

	@Override
	public void handle(ActionEvent event) {
		Button selected = (Button) event.getSource();
		// player turn 1
		if (turnCounter == 0) {
			turnTracker.setText("Player");
			diceRollButton.setDisable(false);
			if (selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("3");

				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}

		// player turn 2
		if (turnCounter == 1) {
			if (selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("2");

				threeButton.setOpacity(.5);

				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}

		// player turn 3
		if (turnCounter == 2) {
			if (selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("3");

				fiveButton.setOpacity(.5);

				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}

		// player turn 4
		if (turnCounter == 3) {
			if (selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("1");

				eightButton.setOpacity(.5);

				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}

		// player turn 5
		if (turnCounter == 4) {
			if (selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("4");

				eightButton.setOpacity(.5);
				oneButton.setOpacity(.5);

				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}

		// player turn 6
		if (turnCounter == 5) {
			if (selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("1");

				twelveButton.setOpacity(.5);
				oneButton.setOpacity(.5);
			}
		}

		// player turn 7
		if (turnCounter == 6) {
			if (selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("2");

				thirteenButton.setOpacity(.5);
				oneButton.setOpacity(.5);

				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}

	}

	public void tileHandler(ActionEvent event) {
		Button selected = (Button) event.getSource();
		// player turn 1
		if (turnCounter == 0) {
			if (selected.getId().equals("zeroButton")) {
				zeroButton.setOpacity(0);
				token_player_0.setVisible(false);
				token_player_3.setVisible(true);
				beginLabel.setText("6");
				processAITurn();
				turnCounter++;
			}
		}

		// player turn 2
		else if (turnCounter == 1) {
			if (selected.getId().equals("threeButton")) {
				zeroButton.setOpacity(0);
				threeButton.setOpacity(0);
				token_player_0.setVisible(false);
				token_player_3.setVisible(false);
				token_player_5.setVisible(true);
				token_ai_5.setVisible(false);
				beginLabelAI.setText("6");
				processAITurn();
				turnCounter++;
			}
		}
		// player turn 3
		else if (turnCounter == 2) {
			if (selected.getId().equals("fiveButton")) {
				zeroButton.setOpacity(0);
				fiveButton.setOpacity(0);
				token_player_0.setVisible(false);
				token_player_5.setVisible(false);
				token_player_8.setVisible(true);
				turnNotification.setText("Roll Again!");
				turnCounter++;
			}
		}
		// player turn 4
		else if (turnCounter == 3) {
			if (selected.getId().equals("zeroButton")) {
				zeroButton.setOpacity(0);
				eightButton.setOpacity(0);
				token_player_0.setVisible(false);
				token_player_1.setVisible(true);
				beginLabel.setText("5");
				turnNotification.setText("");
				processAITurn();
				turnCounter++;
			}
		}

		// player turn 5
		else if (turnCounter == 4) {
			if (selected.getId().equals("eightButton")) {
				zeroButton.setOpacity(0);
				eightButton.setOpacity(0);
				oneButton.setOpacity(0);
				token_player_0.setVisible(false);
				token_player_8.setVisible(false);
				token_player_12.setVisible(true);
				processAITurn();
				turnCounter++;
			}

		}
		// player turn 6
		else if (turnCounter == 5) {
			if (selected.getId().equals("twelveButton")) {
				twelveButton.setOpacity(0);
				oneButton.setOpacity(0);
				token_player_0.setVisible(false);
				token_player_12.setVisible(false);
				token_player_13.setVisible(true);
				processAITurn();
				turnCounter++;
			}
		}
		// player turn 7
		else if (turnCounter == 6) {
			if (selected.getId().equals("thirteenButton")) {
				thirteenButton.setOpacity(0);
				oneButton.setOpacity(0);
				zeroButton.setOpacity(0);
				token_player_0.setVisible(false);
				token_player_13.setVisible(false);
				completeLabel.setText("1");
				turnCounter++;
			}
		}
	}

	public void showMoves() {

		if (gameBoard.getTurnCounter() == 0) {
			for (Integer allowable : gameBoard.getList()) {
				buttonHashmap.get(allowable).setOpacity(.5);
				buttonHashmap.get(allowable).setDisable(false);
				System.out.println(allowable);
			}
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
		
		
	}

	public void processAITurn() {
		PauseTransition pause = new PauseTransition(Duration.millis(1000));
		PauseTransition pieceDelay = new PauseTransition(Duration.millis(1000));
		PauseTransition pauseTurnLabel = new PauseTransition(Duration.millis(1500));
		PauseTransition enableRollButton = new PauseTransition(Duration.millis(1500));
		// AI turn 1
		if (turnCounter == 0) {
			turnTracker.setText("Computer");
			diceRollButton.setDisable(true);
			diceRollLabelAI.setText("2");
			beginLabelAI.setText("5");
			pause.setOnFinished(event -> token_ai_2.setVisible(true));
			pause.play();
			pauseTurnLabel.setOnFinished(event -> turnTracker.setText("Player"));
			pauseTurnLabel.play();
			enableRollButton.setOnFinished(event -> diceRollButton.setDisable(false));
			enableRollButton.play();
		}

		// AI turn 2
		if (turnCounter == 1) {
			turnTracker.setText("Computer");
			diceRollButton.setDisable(true);
			diceRollLabelAI.setText("0");
			turnNotificationAI.setText("Skip Turn!");
			pauseTurnLabel.setOnFinished(event -> turnTracker.setText("Player"));
			pauseTurnLabel.play();
			enableRollButton.setOnFinished(event -> diceRollButton.setDisable(false));
			enableRollButton.play();
		}

		// AI turn 3
		if (turnCounter == 3) {
			turnTracker.setText("Computer");
			diceRollButton.setDisable(true);
			diceRollLabelAI.setText("3");
			turnNotificationAI.setText("");
			pause.setOnFinished(event -> token_ai_3.setVisible(true));
			pause.play();
			pauseTurnLabel.setOnFinished(event -> turnTracker.setText("Player"));
			pauseTurnLabel.play();
			enableRollButton.setOnFinished(event -> diceRollButton.setDisable(false));
			enableRollButton.play();
		}

		// AI turn 3
		if (turnCounter == 4) {
			turnTracker.setText("Computer");
			diceRollButton.setDisable(true);
			diceRollLabelAI.setText("3");
			pieceDelay.setOnFinished(event -> token_ai_3.setVisible(false));
			pieceDelay.play();
			pause.setOnFinished(event -> token_ai_6.setVisible(true));
			pause.play();
			pauseTurnLabel.setOnFinished(event -> turnTracker.setText("Player"));
			pauseTurnLabel.play();
			enableRollButton.setOnFinished(event -> diceRollButton.setDisable(false));
			enableRollButton.play();
		}

		// AI turn 3
		if (turnCounter == 5) {
			turnTracker.setText("Computer");
			diceRollButton.setDisable(true);
			diceRollLabelAI.setText("1");
			beginLabelAI.setText("4");
			pause.setOnFinished(event -> token_ai_1.setVisible(true));
			pause.play();
			pauseTurnLabel.setOnFinished(event -> turnTracker.setText("Player"));
			pauseTurnLabel.play();
			enableRollButton.setOnFinished(event -> diceRollButton.setDisable(false));
			enableRollButton.play();
		}
	}
}