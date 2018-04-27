package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * InstructionsController will control Rules1.fxml, Rules2.fxml, Rules3.fxml, and Credits.fxml. This controller will
 * also provide functionality for returning to the main menu.
 * 
 * @author Jared Andrzejewski (github: JaredAndrz)
 * @author Will Nester (github: willianet97)
 *
 */
public class InstructionsController {
	
	@FXML
	public Button GoMenu;
	
	/**
	 * GoMenu will switch the current scene to TitleScreen.fxml whenever the main menu button is pressed.
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
	
	/**
	 * GoNextRules2 will switch the scene from Rules1.fxml to Rules2.fxml through a button click.
	 */
	@FXML
	protected void GoNextRules2() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Rules2.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * GoNextRules3 will switch the scene from Rules2.fxml to Rules3.fxml through a button click.
	 */
	@FXML
	protected void GoNextRules3() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Rules3.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * GoBackRules2 will switch the scene from Rules3.fxml to Rules2.fxml through a button click.
	 */
	@FXML
	protected void GoBackRules2() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Rules2.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * GoBackRules1 will switch the scene from Rules2.fxml to Rules1.fxml through a button click.
	 */
	@FXML
	protected void GoBackRules1() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Rules1.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}     	
	}
}
