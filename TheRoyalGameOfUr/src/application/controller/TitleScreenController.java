package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class TitleScreenController {
	
	@FXML
	public Button NewGame;
	
	@FXML
	public Button Instructions;
	
	@FXML
	protected void GoNewGame() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/Gameboard.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Main Page"); 
    	
	}
	
	@FXML
	protected void GoInstructions() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Instructions.fxml"));
			Main.stage.setScene(new Scene(root, 800, 576));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Main Page"); 
    	
	}
}
