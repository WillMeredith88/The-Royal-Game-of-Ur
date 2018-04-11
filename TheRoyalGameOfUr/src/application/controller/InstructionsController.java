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
			Main.stage.setScene(new Scene(root, 800, 576));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//System.out.println("Main Page"); 
    	
	}

}
