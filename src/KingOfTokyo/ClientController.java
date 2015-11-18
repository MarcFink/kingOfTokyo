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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.scene.input.InputMethodEvent;

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
	private String lifepoints=null;
	private ClientController clientController;
	
	
	
	@FXML TextField lifeptone;
	@FXML TextField glryptone;
	
	
	
	
	
	
	

	

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

    loader = new FXMLLoader(getClass().getResource("../KingOfTokyoView/GameBoard.fxml"));
    root = (Parent) loader.load();
    scene.setRoot(root);
    stage.setTitle("Hallo");
    player=new Player(); 
	String d=String.valueOf(player.getLifePoints());
	System.out.println(d);
   
   
	  
     
     
	
    System.out.println(d);
  
    
    
    
    
    

    
	}

	
		

		
	}

	
		


