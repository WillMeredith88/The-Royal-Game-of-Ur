package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
/**
 * TitleScreenController will controll TitleScreen.fxml, the landing page for The Royal Game of Ur.
 * This controller will switch the scene to the following fxml: GameBoard.fxml, Rules1.fxml, Demo.fxml, Credits.fxml
 * 
 * @author Will Nester (willianet97)
 *
 */
public class TitleScreenController {
	
	@FXML
	public Button NewGame;
	
	@FXML
	public Button Instructions;
	
	@FXML
    private Button DemoGame;
	
	/**
	 * GoDemoGame will switch the scene to Demo.fxml
	 */
	@FXML
	protected void GoDemoGame() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Demo.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//System.out.println("Main Page"); 
    	
	}
	
	/**
	 * GoNewGame will switch the scene to GameBoard.fxml
	 */
	@FXML
	protected void GoNewGame() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Gameboard.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//System.out.println("Main Page"); 
    	
	}
	
	/**
	 * GoInstructions will switch the scene to Rules1.fxml
	 */
	@FXML
	protected void GoInstructions() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Rules1.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//System.out.println("Main Page"); 
    	
	}
	
	/**
	 * GoCredits will switch the scene to Credits.fxml
	 */
	@FXML
	protected void GoCredits() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Credits.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//System.out.println("Main Page"); 
    	
	}
}
