package KingOfTokyoClient;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ClientView {

	private Stage kingOfTokyoStage;
	private ClientModel clientModel;
	private String ipaddress="Localhost";
	private int port=4444;
	private AnchorPane root;
	private Label pname1,pname2,glory1,glory2,life1,life2,playername1,playername2,lifepoints1,lifepoints2,
	glorypoints1,glorypoints2;
	Button rollDice;
	RadioButton dr1,dr2,dr3,dr4,dr5,dr6;
	ImageView div1;
	ImageView div2;
	ImageView div3;
	ImageView div4;
	ImageView div5;
	ImageView div6;
	ImageView monster1;
	ImageView monster2;
	ImageView gameBoard;
	Image id1,id2,id3,id4,id5,id6,gb;
	private Scene scene;


	public ClientView(Stage kingOfTokyoStage, ClientModel clientModel)throws Exception {
		this.clientModel=clientModel;
		this.kingOfTokyoStage=kingOfTokyoStage;
		initGUI();
		
		scene=new Scene(root);
		kingOfTokyoStage.setScene(scene);
		
		clientModel.startClientConnection(ipaddress, port);
	}
	
	private void initGUI() {
		root=new AnchorPane();
		root.setPrefHeight(700.0);
		root.setPrefWidth(1200.0);
		
	//Labels die während dem Spiel nicht verändert werden
		playername1=new Label("Spielername:");
		playername1.setLayoutX(58);
		playername1.setLayoutY(300);
		
		lifepoints1=new Label("Lebenspunkte:");
		lifepoints1.setLayoutX(58);
		lifepoints1.setLayoutY(340);
		
		glorypoints1=new Label("Ruhmpunkte:");
		glorypoints1.setLayoutX(58);
		glorypoints1.setLayoutY(380);
		
		playername2=new Label("Spielername:");
		playername2.setLayoutX(892);
		playername2.setLayoutY(300);
		
		lifepoints2=new Label("Lebenspunkte:");
		lifepoints2.setLayoutX(891);
		lifepoints2.setLayoutY(340);
		
		glorypoints2=new Label("Ruhmpunkte:");
		glorypoints2.setLayoutX(887);
		glorypoints2.setLayoutY(380);
		
		//Labels die während dem Spiel verändert werden
		pname1=new Label("Text");
		pname1.setLayoutX(160);
		pname1.setLayoutY(300);
		
		glory1=new Label("Text");
		glory1.setLayoutX(160);
		glory1.setLayoutY(340);
		
		life1=new Label("Text");
		life1.setLayoutX(160);
		life1.setLayoutY(380);
		
		pname2=new Label("Text");
		pname2.setLayoutX(987);
		pname2.setLayoutY(300);
		
		glory2=new Label("Text");
		glory2.setLayoutX(987);
		glory2.setLayoutY(340);
		
		life2=new Label("Text");
		life2.setLayoutX(987);
		life2.setLayoutY(380);
		
		//RadioButtons, sie sind am Anfang nicht sichtbar.
		dr1=new RadioButton();
		dr1.setLayoutX(230);
		dr1.setLayoutY(560);
		dr1.setVisible(false);
		
		dr2=new RadioButton();
		dr2.setLayoutX(340);
		dr2.setLayoutY(560);
		dr2.setVisible(false);
		
		dr3=new RadioButton();
		dr3.setLayoutX(460);
		dr3.setLayoutY(560);
		dr3.setVisible(false);
		
		
		dr4=new RadioButton();
		dr4.setLayoutX(580);
		dr4.setLayoutY(560);
		dr4.setVisible(false);
		
		dr5=new RadioButton();
		dr5.setLayoutX(700);
		dr5.setLayoutY(560);
		dr5.setVisible(false);
		
		dr6=new RadioButton();
		dr6.setLayoutX(820);
		dr6.setLayoutY(560);
		dr6.setVisible(false);
	
		
		//Würfelbilder
		div1=new ImageView();
		div1.setFitHeight(100.0);
		div1.setFitWidth(100.0);
		div1.setLayoutX(200);
		div1.setLayoutY(445);
		
		div2=new ImageView();
		div2.setFitHeight(100.0);
		div2.setFitWidth(100.0);
		div2.setLayoutX(310);
		div2.setLayoutY(445);
		
		div3=new ImageView();
		div3.setFitHeight(100.0);
		div3.setFitWidth(100.0);
		div3.setLayoutX(430);
		div3.setLayoutY(445);
		
		div4=new ImageView();
		div4.setFitHeight(100.0);
		div4.setFitWidth(100.0);
		div4.setLayoutX(550);
		div4.setLayoutY(445);
		
		div5=new ImageView();
		div5.setFitHeight(100.0);
		div5.setFitWidth(100.0);
		div5.setLayoutX(670);
		div5.setLayoutY(445);
		
		div6=new ImageView();
		div6.setFitHeight(100.0);
		div6.setFitWidth(100.0);
		div6.setLayoutX(790);
		div6.setLayoutY(445);
		
		//Image Spielermonster
		monster1=new ImageView();
		monster1.setFitHeight(150.0);
		monster1.setFitWidth(200.0);
		monster1.setLayoutX(35);
		monster1.setLayoutY(100);
		
		monster2=new ImageView();
		monster2.setFitHeight(150.0);
		monster2.setFitWidth(200.0);
		monster2.setLayoutX(878);
		monster2.setLayoutY(100);
		
		//GameBoard
		gb=new Image("./Images/GameBoard.png");
		gameBoard=new ImageView(gb);
		gameBoard.setFitHeight(300.0);
		gameBoard.setFitWidth(300.0);
		gameBoard.setLayoutX(504);
		gameBoard.setLayoutY(66);
		
		//Button um zu Würfeln
		rollDice=new Button("Wüfeln");
		rollDice.setLayoutX(1009);
		rollDice.setLayoutY(619);
		
		
		
		root.getChildren().addAll(pname1,glory1,life2,pname2,glory2,life1,playername1,playername2,
				glorypoints1,glorypoints2,lifepoints1,lifepoints2,div1,div2,div3,div4,div5,div6,
				monster1,monster2,gameBoard,rollDice,dr1,dr2,dr3,dr4,dr5,dr6);
		
		
	}

	public void start() {
		kingOfTokyoStage.show();
	}
	
	/**
	 * Stopping the view - just make it invisible
	 */
	public void stop() {
		kingOfTokyoStage.hide();
	}
	
	/**
	 * Getter for the stage, so that the controller can access window events
	 */
	public Stage getkingOfTokyoStage() {
		return kingOfTokyoStage;
	}
}


