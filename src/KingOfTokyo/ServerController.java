package KingOfTokyo;

import java.io.IOException;

import KingOfTokyoModel.ClientModel;
import KingOfTokyoModel.ServerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerController {
	private ServerModel model;
	private ServerController controller;
	private int prt;
	private Stage menuStage;
	
	public ServerController(){
		this.model=new ServerModel();
		this.controller=controller;
		
		}
	public void startView() {
			menuStage=new Stage();
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Server.fxml"));
			Scene scene = new Scene(root);
			menuStage.setScene(scene);
			menuStage.setTitle("King of Tokyo");
			menuStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML TextField port;
	
	@FXML public void connecting(ActionEvent event) throws IOException{
		prt=Integer.parseInt(port.getText());
		model.startServerConnection(prt);
		
		}

	public int getPortNr(){
		return prt;
	}

	@FXML public void cancel(ActionEvent event){
		System.exit(0);
	}
}


		
		
	
	
	
	


