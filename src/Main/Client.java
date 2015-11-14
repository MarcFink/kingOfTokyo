package Main;

import java.io.IOException;

import KingOfTokyo.ClientController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Client extends Application {
	

	

	@Override
	public void start(Stage primaryStage) throws IOException {
		Stage menu=new Stage();
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Menu.fxml"));
		Scene scene = new Scene(root);
		menu.setScene(scene);
		menu.setTitle("King of Tokyo");
		menu.show();
	}

	public static void main(String[] args) {
		launch(args);
		
	
	}

	
		
	}
