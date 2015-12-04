package KingOfTokyo;

import java.io.IOException;

import KingOfTokyoModel.ClientModel;
import KingOfTokyoModel.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ClientControllerNewGamePlattform {

	private ClientModel clientModel;
	private Player player;
	private Scene scene;
	private Node node;
	private Stage stage;
	private FXMLLoader loader;
	private Parent root;
	private String glorypoints;
	private String playername;
	private String gamename;
	private int lifepoints;
	
	public ClientControllerNewGamePlattform(){
		
	}
	@FXML
	TextField gameName;
	@FXML
	TextField playerName;
	@FXML
	Label lblname;
	@FXML
	Label lbllife;
	@FXML
	Label lblglory;
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
	/*
	 * Wir befinden uns im GUI von NewGamePlattform. Button Spielstarten lässst
	 * Spielereingaben ins Playerobjekt schreiben. Anschliessend wird das GUI
	 * GameBoard auf die gleiche Stage geladen, auf der sich die Scene
	 * NewGamePlattform befunden hatte.
	 */
	@FXML
	public void startGame(ActionEvent event) throws IOException {
		player=new Player();
		playername = playerName.getText();
		gamename = gameName.getText();
		player.setGamename(gamename);
		player.setName(playername);
		System.out.println(player.getGamename());
		System.out.println(player.getName());
		System.out.println(player.getMonster());
		node = (Node) event.getSource();
		stage = (Stage) node.getScene().getWindow();
		scene = stage.getScene();
		loader = new FXMLLoader(getClass().getResource("../KingOfTokyoView/GameBoard.fxml"));
		root = (Parent) loader.load();
		scene.setRoot(root);
		stage.setTitle(player.getGamename());
		
		
		System.out.println(String.valueOf(player.getLifePoints()));
		System.out.println(String.valueOf(player.getGloryPoints()));

		
		// wir suchen nach labelid -> siehe gameboard
		Label lblname = (Label) scene.lookup("#lblname");
		// dem label ordnen wir den Wert der playername zu
		lblname.setText(playername);
		

		// lifepoints
		Label lbllife = (Label) scene.lookup("#lbllife");

		lbllife.setText(String.valueOf(player.getLifePoints()));
	

		// glorypoints
		Label lblglory = (Label) scene.lookup("#lblglory");
		lblglory.setText(String.valueOf(player.getGloryPoints()));
		

		// setzt das Monsterbild fest, welches man zuvor ausgewählt hat
		
		ImageView imageplayerone = (ImageView) scene.lookup("#imageplayerone");
		{
			Image img = new Image("./Images/MonsterGigaZaur.png");
			imageplayerone.setImage(img);
		}
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
