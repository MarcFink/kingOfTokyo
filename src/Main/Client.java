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
	
	private Scene menuScene;
	private Scene newGameBoaderScene;
	private FXMLLoader loader;
	private ClientController clientController;
	private AnchorPane ap;
	
	
	public Client() throws IOException{
		clientController=new ClientController();
		loader = new FXMLLoader(getClass().getResource("../KingOfTokyoView/Menu.fxml"));
		ap=loader.load();
		menuScene=new Scene(ap);
		
	}
	@Override
	public void start(Stage primaryStage) throws IOException {
			primaryStage.setScene(menuScene);
			primaryStage.setTitle("King of Tokyo");
			primaryStage.show();
		}
	

	

	public static void main(String[] args) {
		launch(args);
		
	
	}

	
		
	}
