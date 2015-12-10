package Main;

import java.io.IOException;

import KingOfTokyo.ClientView;
import KingOfTokyo.ClientControllerMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Client extends Application {
	
	private Stage kingOfTokyoStage;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		kingOfTokyoStage=primaryStage;
		ClientView clientController=new ClientView(kingOfTokyoStage);
		
	}
	

	

	public static void main(String[] args) {
		launch(args);
		
	
	}

	
		
	}
