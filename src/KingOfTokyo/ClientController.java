package KingOfTokyo;

import java.io.IOException;

import KingOfTokyoModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientController {
	private ClientModel model;
	private ClientController controller;
	private int port=8080;
	private String ipA="Localhost";
	
	
	
	public ClientController(){
	this.model=new ClientModel();
	this.controller=controller;
	this.port=port;
	this.ipA=ipA;
	}

	
	
	
	

	@FXML public void connectClient(ActionEvent event)throws Exception{
		model.startClientConnection(ipA,port);
		Stage stageNewGame=new Stage();
		BorderPane root=(BorderPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/NewGamePlattform.fxml"));
		Scene scene = new Scene(root);
		stageNewGame.setScene(scene);
		stageNewGame.setTitle("Neues Spiel");
		stageNewGame.show();
		
		

	}






	@FXML public void getFacts(ActionEvent event) throws IOException {
		Stage stageFacts=new Stage();
		BorderPane root=(BorderPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Facts.fxml"));
		Scene scene = new Scene(root);
		stageFacts.setScene(scene);
		stageFacts.setTitle("Facts");
		stageFacts.show();	
		
	}






	@FXML public void getInstructions(ActionEvent event) {}
	

	


}
