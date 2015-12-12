package KingOfTokyo;

import java.io.IOException;

import KingOfTokyoModel.ServerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class ServerController {
	private int prt=4444;

	private ServerController serverController;

	
	//ServerController ist mit der FXML Datei Menu verknüpft .
	public ServerController() throws IOException {
		ServerModel serverModel = new ServerModel(serverController,prt);
		serverModel.start();
		
	
		

	}
}

