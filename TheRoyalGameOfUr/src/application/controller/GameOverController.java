package application.controller;


import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameOverController {
	
	@FXML
	private Label lbl_GameOverMessage;
	@FXML
	private Button btn_MainMenu;
	
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
	}
	
	@FXML
	public void initialize() {
		int winner = GameBoardController.getWinner();
		if(winner == 0) {
			// player wins
			lbl_GameOverMessage.setText("You Win!");
			lbl_GameOverMessage.setTextFill(javafx.scene.paint.Color.GREEN);	
		}
		else if (winner == 1) {
			// AI wins
			lbl_GameOverMessage.setText("You Lose!");
			lbl_GameOverMessage.setTextFill(javafx.scene.paint.Color.RED);
		}
	}

}
