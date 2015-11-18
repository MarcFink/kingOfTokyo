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

	public ServerController() {

	}

	@FXML
	TextField port;

	
	

	@FXML
	public void connecting(ActionEvent event) throws Exception {
		prt = Integer.parseInt(port.getText());
		ServerModel serverModel = new ServerModel(serverController);
		serverModel.serveContent(prt);
	
		

	}

	public int getPortNr() {
		return prt;
	}

	@FXML
	public void cancel(ActionEvent event) {
		System.exit(0);
	}
}
