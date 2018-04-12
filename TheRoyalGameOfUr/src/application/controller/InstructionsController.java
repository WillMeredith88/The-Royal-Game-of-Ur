package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class InstructionsController {
	
	@FXML
	public Button GoMenu;
	
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
	
	@FXML
	protected void GoNextRules2() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Rules2.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//System.out.println("Main Page"); 
    	
	}
	
	@FXML
	protected void GoNextRules3() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Rules3.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//System.out.println("Main Page"); 
    	
	}
	
	@FXML
	protected void GoBackRules2() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Rules2.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//System.out.println("Main Page"); 
    	
	}
	
	@FXML
	protected void GoBackRules1() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Rules1.fxml"));
			Main.stage.setScene(new Scene(root, 900, 900));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//System.out.println("Main Page"); 
    	
	}

}
