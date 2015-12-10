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
	private int prt;

	private ServerController serverController;

	
	//ServerController ist mit der FXML Datei Menu verknüpft .
	public ServerController() {
	

	}

	@FXML
	TextField port;

	//Button mit ActionEvent
	@FXML
	public void connecting(ActionEvent event) throws Exception {
		// Erstellt ServerModel beim Drücken des Buttons.
		prt = Integer.parseInt(port.getText());
		port.setEditable(false);
		ServerModel serverModel = new ServerModel(serverController,prt);
		//Anonymerthread wird gestartet im ServerModel
		serverModel.connectServer();
		

	}

	
	@FXML
	public void cancel(ActionEvent event) {
		System.exit(0);
	}
}
