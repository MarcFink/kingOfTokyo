package KingOfTokyo;

import java.io.IOException;
import java.net.Socket;

import KingOfTokyoModel.ClientModel;
import KingOfTokyoModel.ServerListener;
import KingOfTokyoModel.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ClientControllerMenu {

	private ClientModel clientModel;
	private Stage stage;
	private FXMLLoader loader;
	private int port = 4444;
	private String ipA = "Localhost";
	
	private Socket socket;
	
	
	
	
	public ClientControllerMenu(){
	
	}
	/*
	 * Hier ist die Aktion hinter dem Button Neues Spiel hinterlegt. Zuerst wird
	 * ein Objekt von ClientModel erstelltanschliessend wir eine neue Stage
	 * erstellt und das GUI NewGamePlattform geladen.
	 */
	@FXML
	public void connectClient(ActionEvent event) throws Exception {
		clientModel = new ClientModel();
		
		clientModel.startClientConnection(ipA, port);
		stage = new Stage();
		loader = new FXMLLoader(getClass().getResource("../KingOfTokyoView/NewGamePlattform.fxml"));
		Parent root = (Parent) loader.load();
		Scene scene = new Scene(root);
		stage.setTitle("Neues Spiel");
		stage.setScene(scene);
		stage.show();
		
		

	}

	/*
	 * Hier ist die Aktion hinter dem Button Facts hinterlegt. Neue Stage
	 * erstellt und Facts als FXML-File geladen.
	 */
	@FXML
	public void getFacts(ActionEvent event) throws IOException {
		Stage factstage = new Stage();
		BorderPane fact = (BorderPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Facts.fxml"));
		Scene scene = new Scene(fact);
		factstage.setScene(scene);
		factstage.setTitle("Facts");
		factstage.show();

	}

	@FXML
	public void getInstructions(ActionEvent event) {
		
	}
	}
