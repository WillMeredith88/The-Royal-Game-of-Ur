/**
 * 
 * TODO: Win and Lose screens to swap to for win condition
 * 		 add in advanced AI logic
 *		 add extra roll for landing on special spaces
 *		 change tileHandler method to handle method
 *		 UML
 *		 		
 *
 *possible extras:
 *
 *		 skins
 *
 *
 */

package application.controller;

import java.util.HashMap;
//import java.util.List;
//import java.util.concurrent.TimeUnit;

import application.Main;
import application.model.GameBoard;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * GameBoardController controls GameBoard.fxml. This controller will process user input, update the gameboard, 
 * and process AI turns. This controller handles all graphical updates to the gameboard for both the user and AI.
 * 
 * @author David Thomas (github: vandorf594)
 * @author Jared Andrzejewski (github: JaredAndrz)
 * @author Will Meredith (github: WillMeredith88)
 *
 */
public class GameBoardController implements EventHandler<ActionEvent> {

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

	
	
	@FXML ImageView die1, die2, die3, die4, die5, die6;
	
	@FXML
	Image tetraDice1 = new Image("file:TetraDice_0_v1.png");
	@FXML
	Image tetraDice2 = new Image("file:TetraDice_0_v2.png");
	@FXML
	Image tetraDice3 = new Image("file:TetraDice_0_v3.png");
	@FXML
	Image tetraDice4 = new Image("file:TetraDice_1_v1.png");
	@FXML
	Image tetraDice5 = new Image("file:TetraDice_1_v2.png");
	@FXML
	Image tetraDice6 = new Image("file:TetraDice_1_v3.png");
	
		
	
	/*
	 * Hashmaps that store Buttons, and the images for tokens of pieces. Button 0 is
	 * stored at key 0... etc.
	 */
	private HashMap<Integer, Button> buttonHashmap;

	private HashMap<Integer, ImageView> playerTokenHashmap;

	private HashMap<Integer, ImageView> aiTokenHashmap;

	GameBoard gameBoard;

	/**
	 * GoMenu will switch the current scene to TitleScreen.fxml
	 */
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

	/**
	 * initialize sets up the starting condition of all images and buttons, initializing them into Hashmaps.
	 * It updates the GameBoard model then starts the player's turn.
	 */
	@FXML
	public void initialize() {

		gameBoard = new GameBoard();

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
		turnTracker.setText("Player");
		/*
		 * if (gameBoard.getAiPiecesCompleted() == 7) { System.out.println("You lose!");
		 * } else if(gameBoard.getPlayerPiecesCompleted() == 7) {
		 * System.out.println("You win!"); }
		 */
	}

	/**
	 * diceRoll takes an ActionEvent and processes a random roll of the dice using the Dice and GameBoard model classes.
	 * Images corresponding to a matching dice roll are also displayed for the player only. The moves from the roll(s) 
	 * are shown on the board and finally the AI turn is processed.
	 * @param event ActionEvent button click that processes the dice roll for the player.
	 */
	public void diceRoll(ActionEvent event) {

		// This will roll the dice and find the allowable moves
		gameBoard.allowableMoves();

		// Updates the screen with allowable moves and enables the appropriate buttons
		// If the roll value is 0, nothing to update and moves on
		if (gameBoard.getRollValue() != 0) {
			showMoves();
			diceRollButton.setDisable(true);		
			
			//set the dice images
			if(gameBoard.getRollValue() == 4){
				die1.setImage(tetraDice6);
				die2.setImage(tetraDice5);
				die3.setImage(tetraDice6);
				die4.setImage(tetraDice4);
			}else if(gameBoard.getRollValue() == 3){
				die1.setImage(tetraDice6);
				die2.setImage(tetraDice1);
				die3.setImage(tetraDice5);
				die4.setImage(tetraDice4);
			}else if(gameBoard.getRollValue() == 2){
				die1.setImage(tetraDice6);
				die2.setImage(tetraDice1);
				die3.setImage(tetraDice1);
				die4.setImage(tetraDice6);
			}else if(gameBoard.getRollValue() == 1){
				die1.setImage(tetraDice2);
				die2.setImage(tetraDice3);
				die3.setImage(tetraDice6);
				die4.setImage(tetraDice1);
			}
			
		} else if (gameBoard.getRollValue() == 0) {
			diceRollLabel.setText(Integer.toString(gameBoard.getRollValue()));
			
			die1.setImage(tetraDice1);
			die2.setImage(tetraDice3);
			die3.setImage(tetraDice1);
			die4.setImage(tetraDice3);
			
			diceRollButton.setDisable(true);
			turnNotification.setText("Sorry!");
			boardUpdate();
			processAITurn();
		}
	}

	/**
	 * tileHandler takes an ActionEvent and loops through the moves available to the player. Once a value is selected
	 * from available moves, additional arithmetic is used to calculate if the move is a double move, capture move, or
	 * a move that would 'bear-off' a piece from the board. This method also handles a win condition for the player and
	 * calls the appropriate method to change scenes.
	 * 
	 * @param event ActionEvent button click that moves the piece the player selects.
	 */
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
								beginLabelAI.setText(Integer.toString(gameBoard.getAiPiecesRemaining()));

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
		if(gameBoard.getPlayerPiecesCompleted() == 7) {
			// disable the roll button to prevent the game from breaking
			diceRollButton.setDisable(false);
			/**
			 * TODO: add change to "You Win!" Scene here.
			 */
					
			System.out.println("You Win!");
		}
		processAITurn();
	}

	/**
	 * showMoves will change the opacity to make buttons visible to the player for all available (legal) moves.
	 * This class also updates the label on the gameboard to display the dice roll.
	 */
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

	/**
	 * boardUpdate will show newly moved pieces and hide then images in the pieces former position. 
	 * This method also updates labels to show pieces remaining for player and AI, as well as reset the 
	 * turn label to "" an empty string in order for the next move to add whether it is player or AI turn.
	 */
	public void boardUpdate() {
		PauseTransition pauseTurnNotificationPlayer = new PauseTransition(Duration.millis(1000));
		PauseTransition pauseTurnNotificationAI = new PauseTransition(Duration.millis(1000));
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
		turnNotificationAI.setText("");
		pauseTurnNotificationPlayer.setOnFinished(event -> turnNotification.setText(""));
		pauseTurnNotificationPlayer.play();
		pauseTurnNotificationAI.setOnFinished(event -> turnNotificationAI.setText(""));
		pauseTurnNotificationAI.play();
	}

	/**
	 * processAITurn will handle the entirety of the AI turn until the next player turn. Label updates and 
	 * image updates will occur in this method for AI specific movements. PauseTransitions are used to slow down
	 * the AI to prevent instantaneous moves (and allow the player to process what the AI has done). This class
	 * also handles that AI win condition and calls the appropriate method to switch scenes.
	 */
	public void processAITurn() {
		// pause transitions will add a delay to the AI moves for better visibility 
		PauseTransition pauseBoardUpdate = new PauseTransition(Duration.millis(1000));
		PauseTransition pauseTurnCounter = new PauseTransition(Duration.millis(1000));
		PauseTransition pauseProcessAIAgain = new PauseTransition(Duration.millis(1000));
		PauseTransition pauseTurnLabel = new PauseTransition(Duration.millis(1500));
		PauseTransition pauseEnableRollButton = new PauseTransition(Duration.millis(1500));
		
		gameBoard.setTurnCounter(1);
		turnTracker.setText("Computer");
		diceRollButton.setDisable(true);
		gameBoard.allowableMoves();
		diceRollLabelAI.setText(Integer.toString(gameBoard.getRollValue()));
		boardUpdate();
		
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
			// hierarchy of moves
			if(farthestMove + gameBoard.getRollValue() == 14 || farthestMove + gameBoard.getRollValue() == 8 || farthestMove + gameBoard.getRollValue() == 4) {
				gameBoard.getAiBoard()[farthestMove+gameBoard.getRollValue()] = 1;
				turnNotificationAI.setText("Roll Again!");
			}
			else if(farthestMove + gameBoard.getRollValue() == 15) {
				gameBoard.setAiPiecesCompleted(gameBoard.getAiPiecesCompleted() + 1);
			}
			else if(farthestMove + gameBoard.getRollValue() < 15  && farthestMove + gameBoard.getRollValue() != 14 || farthestMove + gameBoard.getRollValue() != 8 || farthestMove + gameBoard.getRollValue() != 4) {
			gameBoard.getAiBoard()[farthestMove + gameBoard.getRollValue()] = 1;
			} 			
			
			// check for a capture on a player piece
			if (farthestMove + gameBoard.getRollValue() > 4 && farthestMove + gameBoard.getRollValue() < 13) {

				if (gameBoard.getPlayerBoard()[farthestMove + gameBoard.getRollValue()] == 1) {
					gameBoard.getPlayerBoard()[farthestMove + gameBoard.getRollValue()] = 0;
					gameBoard.setPlayerPiecesRemaining(gameBoard.getPlayerPiecesRemaining() + 1);
				}
			}
		} 
		else if(gameBoard.getRollValue() == 0) {
			turnNotificationAI.setText("Sorry!");
		}
		
		// process another ai turn if they scored a double move
		if(farthestMove + gameBoard.getRollValue() == 14 || farthestMove + gameBoard.getRollValue() == 8 || farthestMove + gameBoard.getRollValue() == 4) {
			pauseBoardUpdate.setOnFinished(event -> boardUpdate());
			pauseBoardUpdate.play();
			pauseProcessAIAgain.setOnFinished(event -> processAITurn());
			pauseProcessAIAgain.play();		
		}
		
		pauseBoardUpdate.setOnFinished(event -> boardUpdate());
		pauseBoardUpdate.play();
		pauseTurnCounter.setOnFinished(event -> gameBoard.setTurnCounter(0));
		pauseTurnCounter.play();
		gameBoard.getList().clear();
		pauseTurnLabel.setOnFinished(event -> turnTracker.setText("Player"));
		pauseTurnLabel.play();
		pauseEnableRollButton.setOnFinished(event -> diceRollButton.setDisable(false));
		pauseEnableRollButton.play();
				
		if (gameBoard.getAiPiecesCompleted() == 7) {
			// disable the roll button to prevent the game from breaking
			diceRollButton.setDisable(false);
			/**
			 * TODO: add change to "You lose" Scene here
			 */
			
			System.out.println("YOU LOSE");
		}
		
	}

	/**
	 * handle is a default method included when a class implements an EventHandler.
	 */
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}
}