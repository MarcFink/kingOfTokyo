package Main;

import java.io.IOException;

import KingOfTokyo.ClientController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {
	

	@Override
	public void start(Stage primaryStage) throws IOException {
		ClientController clientController=new ClientController();
		clientController.startView();
	}

	public static void main(String[] args) {
		launch(args);
		
	
	}

	
		
	}
