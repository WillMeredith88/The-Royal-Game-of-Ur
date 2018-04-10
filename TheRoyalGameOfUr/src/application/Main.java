package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Load the FXML file for the game board
			Parent root = FXMLLoader.load(getClass().getResource("Gameboard.fxml"));
			
			// Set the scene onto the stage
			primaryStage.setScene(new Scene(root, 900, 900));
			
			// Display the board to the user
			primaryStage.show();
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}