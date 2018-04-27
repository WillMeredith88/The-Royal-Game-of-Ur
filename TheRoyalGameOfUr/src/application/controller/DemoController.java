package application.controller;


import application.Main;
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
/**
 * DemoController will control the Demo.fxml document. This class's primary function is to 
 * provide a scripted set of moves to a player who selects "Demo" from the Title screen.
 * 
 * @author Jared Andrzejewski (github: JaredAndrz)
 * @author David Thomas (github: vandorf594)
 * @author Will Nester (github: willanet97)
 *
 */
public class DemoController implements EventHandler<ActionEvent> {
	
	@FXML
	private Button zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, 
	eightButton, nineButton, tenButton, elevenButton, twelveButton, thirteenButton, fourteenButton;

	@FXML
	private ImageView token_player_0, token_player_1, token_player_2, token_player_3, token_player_4, token_player_5, token_player_6, token_player_7, 
	token_player_8, token_player_9, token_player_10, token_player_11, token_player_12, token_player_13, token_player_14;
	
	@FXML
	private ImageView token_ai_0, token_ai_1, token_ai_2, token_ai_3, token_ai_4, token_ai_5, token_ai_6, token_ai_7, 
	token_ai_8, token_ai_9, token_ai_10, token_ai_11, token_ai_12, token_ai_13, token_ai_14;
    
	@FXML
	private Button diceRollButton;
	    
	@FXML
	private Label diceRollLabel, diceRollLabelAI, beginLabel, beginLabelAI, completeLabel, completeLabelAI, turnNotification, turnNotificationAI, turnTracker;
	
	/**
	 * GoMenu will update the scene to show TitleScreen.fxml through a button on Demo.fxml.
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
	}
	
	private int turnCounter = 0;
	
	/**
	 * initialize will initialize the Demo Gameboard with a starting condition for the user to see.
	 */
	@FXML
	public void initialize(){
		token_ai_5.setVisible(true);
		beginLabelAI.setText("6");
	}
	
	/**
	 * handle will take an ActionEvent of button clicks that will move pieces for the player. This
	 * method provides a scripted sequence of actions where all moves and rolls are hardcoded for the player.
	 * The only thing this method handles is player rolls
	 * 
	 * @param event ActionEvent that represents a button click for rolling the dice.
	 */
	@Override
	public void handle(ActionEvent event) {
		Button selected = (Button) event.getSource();
		// player turn 1
		if(turnCounter == 0){
			turnTracker.setText("Player");
			diceRollButton.setDisable(false);
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("3");
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);			
			}
		}
		
		// player turn 2
		if(turnCounter == 1){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("2");
				
				threeButton.setOpacity(.5);
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}
		
		
		//player turn 3
		if(turnCounter == 2){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("3");
				
				fiveButton.setOpacity(.5);
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}	
		
		//player turn 4
		if(turnCounter == 3){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("1");
				
				eightButton.setOpacity(.5);
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}
		
		// player turn 5
		if(turnCounter == 4){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("4");
				
				eightButton.setOpacity(.5);
				oneButton.setOpacity(.5);
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}
		
		//player turn 6
		if(turnCounter == 5){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("1");
				
				twelveButton.setOpacity(.5);
				oneButton.setOpacity(.5);
			}
		}
		
		// player turn 7
		if(turnCounter == 6){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("2");
				
				thirteenButton.setOpacity(.5);
				oneButton.setOpacity(.5);
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}
		
	}
	
	/**
	 * tileHandler will take an ActionEvent button click that will update the gameboard and 
	 * show the player piece moves. The button to be clicked will light up green.
	 * @param event ActionEvent that represents a button click of piece movements.
	 */
	public void tileHandler(ActionEvent event){
		Button selected = (Button) event.getSource();
		// player turn 1
		if(turnCounter == 0){
			if(selected.getId().equals("zeroButton")) {
				zeroButton.setOpacity(0);
				token_player_0.setVisible(false);
				token_player_3.setVisible(true);
				beginLabel.setText("6");
				processAITurn();
				turnCounter++;
			}	
		}
		
		// player turn 2
		else if(turnCounter == 1){
			if(selected.getId().equals("threeButton")) {
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
		else if(turnCounter == 2){
			if(selected.getId().equals("fiveButton")) {
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
		else if(turnCounter == 3){
			if(selected.getId().equals("zeroButton")) {
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
		else if(turnCounter == 4){
			if(selected.getId().equals("eightButton")) {
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
		else if(turnCounter == 5){
			if(selected.getId().equals("twelveButton")) {
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
		else if(turnCounter == 6){
			if(selected.getId().equals("thirteenButton")) {
				thirteenButton.setOpacity(0);
				oneButton.setOpacity(0);
				zeroButton.setOpacity(0);
				token_player_0.setVisible(false);
				token_player_13.setVisible(false);
				completeLabel.setText("1");
				diceRollButton.setDisable(true);
				turnCounter++;
			}		
		}
	}

	/**
	 * processAITurn will move the pieces for the AI. A pause transition was added to 
	 * slow the moves down and give the player a chance to process what actions the AI took.
	 * All AI events are scripted / hard-coded.
	 */
	public void processAITurn(){
		PauseTransition pause = new PauseTransition(Duration.millis(1000));
		PauseTransition pieceDelay = new PauseTransition(Duration.millis(1000));
		PauseTransition pauseTurnLabel = new PauseTransition(Duration.millis(1500));
		PauseTransition enableRollButton = new PauseTransition(Duration.millis(1500));
		// AI turn 1
			if(turnCounter == 0){
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
			if(turnCounter == 1){
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
			if(turnCounter == 3){
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
			
			// AI turn 4
			if(turnCounter == 4){
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
			
			// AI turn 5
			if(turnCounter == 5){
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
