package KingOfTokyo;

import java.io.IOException;

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
import javafx.scene.control.Button;

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
	private ClientController clientController;
	private Boolean w1Selected=false;
	private Boolean w2Selected=false;
	private Boolean w3Selected=false;
	private Boolean w4Selected=false;
	private Boolean w5Selected=false;
	private Boolean w6Selected=false;
	private int würfelVersuchCounter=0;
	
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
	@FXML RadioButton gigaZaur;
	@FXML RadioButton kraken;
	@FXML RadioButton theKing;
	@FXML ImageView imageplayerone;
	@FXML RadioButton wr1;
	@FXML RadioButton wr2;
	@FXML RadioButton wr3;
	@FXML RadioButton wr4;
	@FXML RadioButton wr5;
	@FXML RadioButton wr6;
	@FXML Button Würfeln;

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
		loader = new FXMLLoader(getClass().getResource(
				"../KingOfTokyoView/NewGamePlattform.fxml"));
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
		BorderPane fact = (BorderPane) FXMLLoader.load(getClass().getResource(
				"../KingOfTokyoView/Facts.fxml"));
		Scene scene = new Scene(fact);
		factstage.setScene(scene);
		factstage.setTitle("Neues Spiel");
		factstage.show();

	}

	@FXML
	public void getInstructions(ActionEvent event) {
	}

	/*
	 * Wir befinden uns im GUI von NewGamePlattform. Button Spielstarten lässst
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

		node = (Node) event.getSource();
		stage = (Stage) node.getScene().getWindow();
		scene = stage.getScene();

		loader = new FXMLLoader(getClass().getResource(
				"../KingOfTokyoView/GameBoard.fxml"));
		root = (Parent) loader.load();

		scene.setRoot(root);
		stage.setTitle(player.getGamename());
		//wir suchen nach labelid -> siehe gameboard
		Label lblplayer = (Label)scene.lookup("#lblname1");
		//dem label ordnen wir den Wert der playername zu
		lblplayer.setText(playername);
		
		//lifepoints
		Label lbllife1 = (Label)scene.lookup("#lbllife1");
		lbllife1.setText(String.valueOf(player.getLifePoints()));
		
		//glorypoints
		Label lblglory1=(Label)scene.lookup("#lblglory1");
		lblglory1.setText(String.valueOf(player.getGloryPoints()));
		
		//setzt das Monsterbild fest, welches man zuvor ausgewählt hat
		ImageView imageplayerone=(ImageView)scene.lookup("#imageplayerone");{
			
		
		if(player.getMonster().equals("TheKing")){
			Image img=new Image("./Images/MonsterTheKing.png");
			imageplayerone.setImage(img);
		}
			else if(player.getMonster().equals("Kraken")){
			Image img=new Image("./Images/MonsterKraken.png");
			imageplayerone.setImage(img);	
		}else
		{
			Image img=new Image("./Images/MonsterGigaZaur.png");
			imageplayerone.setImage(img);	
		}
		}
	}
		

		

	@FXML
	public void ErsterZug(ActionEvent event) throws IOException {
		Stage würfelStage = new Stage();
		AnchorPane würfeln = (AnchorPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/RollDice.fxml"));
		Scene scene = new Scene(würfeln);
		würfelStage.setScene(scene);
		würfelStage.setTitle("Würfeln");
		würfelStage.show();
		RadioButton wr1=(RadioButton)scene.lookup("#wr1");
		wr1.setVisible(false);
		RadioButton wr2=(RadioButton)scene.lookup("#wr2");
		wr2.setVisible(false);
		RadioButton wr3=(RadioButton)scene.lookup("#wr3");
		wr3.setVisible(false);
		RadioButton wr4=(RadioButton)scene.lookup("#wr4");
		wr4.setVisible(false);
		RadioButton wr5=(RadioButton)scene.lookup("#wr5");
		wr5.setVisible(false);
		RadioButton wr6=(RadioButton)scene.lookup("#wr6");
		wr6.setVisible(false);
		

		

	}

	@FXML
	public void rollDice(ActionEvent event) {
		Dice dice = new Dice();
		
		if(würfelVersuchCounter==0){	
		w1.setText(dice.rollDice());
		w2.setText(dice.rollDice());
		w3.setText(dice.rollDice());
		w4.setText(dice.rollDice());
		w5.setText(dice.rollDice());
		w6.setText(dice.rollDice());
		wr1.setVisible(true);
		wr2.setVisible(true);
		wr3.setVisible(true);
		wr4.setVisible(true);
		wr5.setVisible(true);
		wr6.setVisible(true);
		würfelVersuchCounter++;
		System.out.println(würfelVersuchCounter);
		}else if(würfelVersuchCounter<=2){
			
		if(w1Selected==true){
		w1.setText(dice.rollDice());
		}
		if(w2Selected==true){
		w2.setText(dice.rollDice());
		}
		if(w3Selected==true){
		w3.setText(dice.rollDice());
		}
		if(w4Selected==true){
		w4.setText(dice.rollDice());
		}
		if(w5Selected==true){
		w5.setText(dice.rollDice());
		}
		if(w6Selected==true){
		w6.setText(dice.rollDice());
		}
		würfelVersuchCounter++;
		System.out.println(würfelVersuchCounter);
		}
		else{	
		Würfeln.setText("Zug beenden");
		wr1.setVisible(false);
		wr2.setVisible(false);
		wr3.setVisible(false);
		wr4.setVisible(false);
		wr5.setVisible(false);
		wr6.setVisible(false);
		}
		}

		
		
		
		
		
		
		

	

	@FXML public void theKingAction(ActionEvent event) {
		player.setMonster("TheKing");
		
		
	}

	@FXML public void krakenAction(ActionEvent event) {
		player.setMonster("Kraken");
	}

	@FXML public void gigaZaurAction(ActionEvent event) {
		player.setMonster("GigaZaur");
	}

	@FXML public void w1Action(ActionEvent event) {
		if(w1Selected==false){
			w1Selected=true;
		}else if(w1Selected==true){
			w1Selected=false;
			
		}
	}

	@FXML public void w2Action(ActionEvent event) {
		if(w2Selected==false){
			w2Selected=true;
		}else if(w2Selected==true){
			w2Selected=false;
			
		}
	}
		
	

	@FXML public void w3Action(ActionEvent event) {
		if(w3Selected==false){
			w3Selected=true;
		}else if(w3Selected==true){
			w3Selected=false;
			
		}
	}
	

	@FXML public void w4Action(ActionEvent event) {
		if(w4Selected==false){
			w4Selected=true;
		}else if(w4Selected==true){
			w4Selected=false;
			
		}
	}
	

	@FXML public void w5Action(ActionEvent event) {
		if(w5Selected==false){
			w5Selected=true;
		}else if(w5Selected==true){
			w5Selected=false;
			
		}
	}
	

	@FXML public void w6Action(ActionEvent event) {
		if(w6Selected==false){
			w6Selected=true;
		}else if(w6Selected==true){
			w6Selected=false;
			
		}
	}
	}


