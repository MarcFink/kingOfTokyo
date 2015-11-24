package KingOfTokyo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import KingOfTokyoModel.ClientModel;
import KingOfTokyoModel.Dice;
import KingOfTokyoModel.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ClientController {
	private ClientModel clientModel;
	private Player player;
	private int port = 8080;
	private String ipA = "Localhost";
	private Scene scene;
	private Node node;
	private Stage stage;
	private FXMLLoader loader;
	private Parent root;
	private String glorypoints;
	private String playername;
	private String gamename;
	private int lifepoints;
	private ArrayList<String> playerinfo = new ArrayList<String>();
	private ClientController clientController;
	File file = new File("C:\\temp\\my_file.txt");

	@FXML
	TextField gameName;
	@FXML
	TextField playerName;
	@FXML
	Label w1;
	@FXML
	Label w2;
	@FXML
	Label w3;
	@FXML
	Label w4;
	@FXML
	Label w5;
	@FXML
	Label w6;
	@FXML
	Label lblname1;
	@FXML
	Label lbllife1;
	@FXML
	Label lblglory1;
	@FXML
	Label lblplayer;
	@FXML
	RadioButton gigaZaur;
	@FXML
	RadioButton kraken;
	@FXML
	RadioButton theKing;
	@FXML
	ImageView imageplayerone;

	public ClientController() {
		player = new Player(clientController);

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
		factstage.setTitle("Neues Spiel");
		factstage.show();

	}

	@FXML
	public void getInstructions(ActionEvent event) {
	}

	/*
	 * Wir befinden uns im GUI von NewGamePlattform. Button Spielstarten l�ssst
	 * Spielereingaben ins Playerobjekt schreiben. Anschliessend wird das GUI
	 * GameBoard auf die gleiche Stage geladen, auf der sich die Scene
	 * NewGamePlattform befunden hatte.
	 */
	@FXML
	public void startGame(ActionEvent event) throws IOException {
		gamename = gameName.getText();
		playername = playerName.getText();
		player.setGamename(gamename);
		player.setName(playername);
		System.out.println(player.getGamename());
		System.out.println(player.getName());
		System.out.println(player.getMonster());
		System.out.println(String.valueOf(player.getLifePoints()));
		System.out.println(String.valueOf(player.getGloryPoints()));
		

		node = (Node) event.getSource();
		stage = (Stage) node.getScene().getWindow();
		scene = stage.getScene();

		loader = new FXMLLoader(getClass().getResource("../KingOfTokyoView/GameBoard.fxml"));
		root = (Parent) loader.load();

		scene.setRoot(root);
		stage.setTitle(player.getGamename());
		playerinfo.add(player.getGamename());
		// wir suchen nach labelid -> siehe gameboard
		Label lblplayer = (Label) scene.lookup("#lblname1");
		// dem label ordnen wir den Wert der playername zu
		lblplayer.setText(playername);
		playerinfo.add(playername);

		// lifepoints
		Label lbllife1 = (Label) scene.lookup("#lbllife1");
		lbllife1.setText(String.valueOf(player.getLifePoints()));
		playerinfo.add(String.valueOf(player.getLifePoints()));

		// glorypoints
		Label lblglory1 = (Label) scene.lookup("#lblglory1");
		lblglory1.setText(String.valueOf(player.getGloryPoints()));
		playerinfo.add(String.valueOf(player.getGloryPoints()));

		// setzt das Monsterbild fest, welches man zuvor ausgew�hlt hat
		playerinfo.add(player.getMonster());
		ImageView imageplayerone = (ImageView) scene.lookup("#imageplayerone");
		{

			if (player.getMonster().equals("TheKing")) {
				Image img = new Image("./Images/MonsterTheKing.png");
				imageplayerone.setImage(img);
			} else if (player.getMonster().equals("Kraken")) {
				Image img = new Image("./Images/MonsterKraken.png");
				imageplayerone.setImage(img);
			} else {
				Image img = new Image("./Images/MonsterGigaZaur.png");
				imageplayerone.setImage(img);
			}
		}

//		if (file.exists()) {
//
//			BufferedReader br;
//			try {
//				br = new BufferedReader(new FileReader(file));
//
//				if (br.readLine() != null) {
//
//					clientModel.newLine();
//				}
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
		
		

		for (String s : playerinfo)
		{
//		
		System.out.print(s+"\t");
//		clientModel.createTextFile(s);
//			
		}
		
	}

	@FXML
	public void ErsterZug(ActionEvent event) throws IOException {
		Stage w�rfelStage = new Stage();
		AnchorPane w�rfeln = (AnchorPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/RollDice.fxml"));
		Scene scene = new Scene(w�rfeln);
		w�rfelStage.setScene(scene);
		w�rfelStage.setTitle("W�rfeln");
		w�rfelStage.show();

	}

	@FXML
	public void rollDice(ActionEvent event) {
		Dice dice = new Dice();
		w1.setText(dice.rollDice());
		w2.setText(dice.rollDice());
		w3.setText(dice.rollDice());
		w4.setText(dice.rollDice());
		w5.setText(dice.rollDice());
		w6.setText(dice.rollDice());

	}

	@FXML
	public void theKingAction(ActionEvent event) {
		player.setMonster("TheKing");

	}

	@FXML
	public void krakenAction(ActionEvent event) {
		player.setMonster("Kraken");
	}

	@FXML
	public void gigaZaurAction(ActionEvent event) {
		player.setMonster("GigaZaur");
	}

}
