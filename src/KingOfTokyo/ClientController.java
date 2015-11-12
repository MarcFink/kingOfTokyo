package KingOfTokyo;

import java.io.IOException;

import KingOfTokyoModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientController {
	private ClientModel clientModel;
	private int port=8080;
	private String ipA="Localhost";
	private Stage stageFacts;
	private Scene scene;
	
	
	
	public ClientController(){
		
		
			
	}
	public void startView() throws IOException {
		Stage menu=new Stage();
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Menu.fxml"));
		Scene scene = new Scene(root);
		menu.setScene(scene);
		menu.setTitle("King of Tokyo");
		menu.show();
		
			
		}
		
		
	
	@FXML public void connectClient(ActionEvent event)throws Exception{
		clientModel=new ClientModel();
		clientModel.startClientConnection(ipA,port);
		Stage stageNewGame=new Stage();
		BorderPane root=(BorderPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/NewGamePlattform.fxml"));
		Scene scene = new Scene(root);
		stageNewGame.setScene(scene);
		stageNewGame.setTitle("Neues Spiel");
		stageNewGame.show();
	
	}






	@FXML public void getFacts(ActionEvent event) throws IOException {
		stageFacts=new Stage();
		BorderPane borderPane = (BorderPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Facts.fxml"));
		scene = new Scene(borderPane);
		stageFacts.setScene(scene);
		stageFacts.setTitle("Facts");
		stageFacts.show();	
		
	}






	@FXML public void getInstructions(ActionEvent event) {}
	
	
	@FXML public void goToChooseCharacter(ActionEvent event) throws IOException {
		
	}








	


}
