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
	private FXMLLoader fxmlLoader;
	private BorderPane root;
	

	public ClientController() {

	}

	@FXML
	public void connectClient(ActionEvent event) throws Exception {
		clientModel = new ClientModel();
		clientModel.startClientConnection(ipA, port);
		Stage stageNewGame = new Stage();
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/NewGamePlattform.fxml"));
		Scene scene = new Scene(root);
		stageNewGame.setScene(scene);
		stageNewGame.setTitle("Neues Spiel");
		stageNewGame.show();

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

	@FXML
	public void goToChooseCharacter(ActionEvent event) throws IOException {
		node = (Node) event.getSource();
		stage = (Stage) node.getScene().getWindow();
        scene = stage.getScene();
        fxmlLoader = new FXMLLoader(getClass().getResource("../KingOfTokyoView/ChooseCharacter.fxml"));
        root = (BorderPane) fxmlLoader.load();
        scene.setRoot(root);
		

	}



}
