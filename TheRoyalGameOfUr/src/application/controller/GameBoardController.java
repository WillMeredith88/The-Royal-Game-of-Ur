package application.controller;

import application.Main;
import application.model.Dice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class GameBoardController implements EventHandler<ActionEvent> {
	
	@FXML
	private Button zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, 
	eightButton, nineButton, tenButton, elevenButton, twelveButton, thirteenButton, fourteenButton;

	@FXML
	private ImageView token_player_0, token_player_1, token_player_2, token_player_3, token_player_4, token_player_5, token_player_6, token_player_7, 
	token_player_8, token_player_9, token_player_10, token_player_11, token_player_12, token_player_13, token_player_14;
    
	@FXML
	private Button diceRollButton;
	    
	@FXML
	private Label diceRollLabel, beginLabel, completeLabel, turnNotification;
		
	@FXML
	protected void GoMenu() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/TitleScreen.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//System.out.println("Main Page"); 
	    	
		}
	
	private int turnCounter = 0;
	
	@Override
	public void handle(ActionEvent event) {
		Button selected = (Button) event.getSource();
		if(turnCounter == 0){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("3");
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}
		
		if(turnCounter == 1){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("2");
				
				threeButton.setOpacity(.5);
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}	
		
		if(turnCounter == 2){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("3");
				
				fiveButton.setOpacity(.5);
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}	
		
		if(turnCounter == 3){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("1");
				
				eightButton.setOpacity(.5);
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}
		
		if(turnCounter == 4){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("4");
				
				eightButton.setOpacity(.5);
				oneButton.setOpacity(.5);
				
				zeroButton.setOpacity(.5);
				token_player_0.setVisible(true);
			}
		}
		
		if(turnCounter == 5){
			if(selected.getId().equals("diceRollButton")) {
				diceRollLabel.setText("1");
				
				twelveButton.setOpacity(.5);
				oneButton.setOpacity(.5);
			}
		}
		
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
	
	public void tileHandler(ActionEvent event){
		Button tile = (Button) event.getSource();
		if(turnCounter == 0){
			zeroButton.setOpacity(0);
			token_player_0.setVisible(false);
			token_player_3.setVisible(true);
			beginLabel.setText("6");
			turnCounter++;
		}
		
		else if(turnCounter == 1){
			zeroButton.setOpacity(0);
			threeButton.setOpacity(0);
			token_player_0.setVisible(false);
			token_player_3.setVisible(false);
			token_player_5.setVisible(true);
			turnCounter++;
		}
		
		else if(turnCounter == 2){
			zeroButton.setOpacity(0);
			fiveButton.setOpacity(0);
			token_player_0.setVisible(false);
			token_player_5.setVisible(false);
			token_player_8.setVisible(true);
			turnNotification.setText("Roll Again!");
			turnCounter++;
		}
		
		else if(turnCounter == 3){
			zeroButton.setOpacity(0);
			eightButton.setOpacity(0);
			token_player_0.setVisible(false);
			token_player_1.setVisible(true);
			beginLabel.setText("5");
			turnNotification.setText("");
			turnCounter++;
		}
		
		else if(turnCounter == 4){
			zeroButton.setOpacity(0);
			eightButton.setOpacity(0);
			oneButton.setOpacity(0);
			token_player_0.setVisible(false);
			token_player_8.setVisible(false);
			token_player_12.setVisible(true);
			turnCounter++;
		}
		
		else if(turnCounter == 5){
			twelveButton.setOpacity(0);
			oneButton.setOpacity(0);
			token_player_0.setVisible(false);
			token_player_12.setVisible(false);
			token_player_13.setVisible(true);
			turnCounter++;
		}
		
		else if(turnCounter == 6){
			thirteenButton.setOpacity(0);
			oneButton.setOpacity(0);
			zeroButton.setOpacity(0);
			token_player_0.setVisible(false);
			token_player_1.setVisible(false);
			token_player_13.setVisible(false);
			completeLabel.setText("1");
			turnCounter++;
		}
	}

}
