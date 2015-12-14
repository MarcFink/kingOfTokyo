package KingOfTokyoClient;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {

	private Stage kingOfTokyoStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		kingOfTokyoStage = primaryStage;
		
		ClientModel clientModel=new ClientModel();
		ClientView clientView = new ClientView(kingOfTokyoStage, clientModel);
		ClientControllerGameBoard clientControllerGameBoard=new ClientControllerGameBoard(clientModel,clientView);
		
		clientView.start();
		
		
	
		
		

	}

	public static void main(String[] args) {
		launch(args);

	}

}
