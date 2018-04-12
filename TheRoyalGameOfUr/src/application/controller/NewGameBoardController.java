package application.controller;

import java.util.ArrayList;

import application.Main;
import application.model.Dice;
import application.model.GameBoard;
import application.model.Player;
import application.model.Square;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class NewGameBoardController implements EventHandler{
	
	Player player = new Player();
	GameBoard board = new GameBoard(player);
	Dice dice = new Dice();
	Square current = board.getCurrent();
	static ArrayList<Square> list = new ArrayList<Square>();
	//ArrayList<Button> buttons = new ArrayList<Button>();
	
	
	
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
	
	@FXML
	public void initialize(){
		token_ai_5.setVisible(true);
		beginLabelAI.setText("6");
	}
	
	
	
	
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
		Button button = (Button)event.getSource();
		
		if(button.getId().equals(diceRollButton.getId())){
			/*ArrayList<Square>*/ list = new ArrayList<>();
			int roll = dice.rollDice();
			diceRollLabel.setText(roll);
			list = board.getPossibleMove(current, roll);
			for(int i=0; i < list.size(); i++){
				Square sq = list.get(i);
				String st = board.getButton(sq);
				
				//zeroButton.setOpacity(.5);
			}
		}
		
		
		
		
		if(button.getId().equals("ZeroButton") && list.contains("zeroButton")){
			
			//place token on piece
			list=null;
		}
		
		
	}
	
	
	
	
	/*public Button getButton(String str){
		
		for(int i=0; i < buttons.size(), i++){
			
		}
		
		return null;
	}*/
	
	
	
	

}
