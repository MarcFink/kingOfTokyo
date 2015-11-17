package KingOfTokyo;

import java.io.IOException;

import KingOfTokyoModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientController {
	private ClientModel clientModel;
	private int port = 8080;
	private String ipA = "Localhost";
	private Scene scene;
	private Node node;
	private Stage stage;
	private FXMLLoader loader;
	private Parent root;
	

	

	public ClientController() {

	}

	@FXML
	public void connectClient(ActionEvent event) throws Exception {
		clientModel = new ClientModel();
		clientModel.startClientConnection(ipA, port);
		stage=new Stage(); 
		loader = new FXMLLoader(getClass().getResource("../KingOfTokyoView/NewGamePlattform.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Neues Spiel");
        stage.setScene(scene);           
        stage.show();

	}

	@FXML
	public void getFacts(ActionEvent event) throws IOException {
		Stage factstage=new Stage();
		BorderPane fact= (BorderPane)FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Facts.fxml"));
		Scene scene = new Scene(fact);
		factstage.setScene(scene);
		factstage.setTitle("Neues Spiel");
		factstage.show();

	}

	@FXML
	public void getInstructions(ActionEvent event) {
	}


	@FXML public void startGame(ActionEvent event) throws IOException {
	node=(Node)event.getSource();
	stage = (Stage) node.getScene().getWindow();
    scene = stage.getScene();
    stage.setTitle("Spiel gestartet");
    loader = new FXMLLoader(getClass().getResource("../KingOfTokyoView/GameBoard.fxml"));
    root = (Parent) loader.load();
    scene.setRoot(root);
	}

}
