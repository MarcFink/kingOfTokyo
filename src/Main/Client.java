package Main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import KingOfTokyo.ClientController;
import KingOfTokyoModel.ClientModel;

public class Client extends Application {
	private ClientModel model;
	private ClientController controller;
	private Stage primaryStage;
	

	@Override
	public void start(Stage primaryStage) {
		
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Menu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("King of Tokyo");
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		
	
	}

	
		
	}
