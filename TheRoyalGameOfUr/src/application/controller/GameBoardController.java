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
	    private Button thirteenButton;

	    @FXML
	    private Button threeButton;

	    @FXML
	    private Button sevenButton;

	    @FXML
	    private ImageView token_player_10;

	    @FXML
	    private Button twoButton;

	    @FXML
	    private Button eightButton;

	    @FXML
	    private ImageView token_player_1;

	    @FXML
	    private ImageView token_player_12;


	    @FXML
	    private ImageView token_player_11;


	    @FXML
	    private ImageView token_player_3;

	    @FXML
	    private ImageView token_player_14;


	    @FXML
	    private Button zeroButton;

	    @FXML
	    private Button fourteenButton;

	    @FXML
	    private ImageView token_player_2;

	    @FXML
	    private ImageView token_player_13;

	    @FXML
	    private ImageView token_player_5;


	    @FXML
	    private ImageView token_player_4;

	    @FXML
	    private ImageView token_player_7;


	    @FXML
	    private Button fourButton;

	    @FXML
	    private ImageView token_player_6;
	    
	    @FXML
	    private ImageView token_player_0;


	    @FXML
	    private ImageView token_player_9;

	    @FXML
	    private ImageView token_player_8;

	    @FXML
	    private Button tenButton;

	    @FXML
	    private Button twelveButton;

	    @FXML
	    private Button oneButton;

	    @FXML
	    private Button elevenButton;

	    @FXML
	    private Button sixButton;

	    @FXML
	    private Button nineButton;

	    @FXML
	    private Button fiveButton;
	    
	    @FXML
	    private Button diceRollButton;
	    
	    @FXML
	    private Label diceRollLabel;
	    
	    @FXML
	    private Label beginLabel;
	    
	    @FXML
	    private Label completeLabel;
	    
	    @FXML
	    private Label turnNotification;
	    
	    private int turnCounter = 0;
		
		@FXML
		protected void GoMenu() {
			try {
				Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/TitleScreen.fxml"));
				Main.stage.setScene(new Scene(root, 800, 576));
				Main.stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			System.out.println("Main Page"); 
	    	
		}
	
	@Override
	public void handle(ActionEvent event) {
		Button selected = (Button) event.getSource();
		//System.out.println(selected.toString());
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
				
				//zeroButton.setOpacity(.5);
				//token_player_0.setVisible(true);
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
