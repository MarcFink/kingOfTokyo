package Main;

import java.io.IOException;

import KingOfTokyo.ClientController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Client extends Application {
	

	

	@Override
	public void start(Stage primaryStage) throws IOException {

		ClientController clientController=new ClientController();
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Menu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("King of Tokyo");
			primaryStage.show();
			
			
		}

	

	public static void main(String[] args) {
		launch(args);
		
	
	}

	
		
	}
