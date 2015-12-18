package KingOfTokyoClient;

import KingOfTokyoServer.Music;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientView {
	/* 
	 * @author  Fink Marc, Attinkara Robin, Mäder David
	 * */

	private Stage kingOfTokyoStage,stage,factStage,AnleitungStage;
	private ClientModel clientModel;
	private String ipaddress = "Localhost";
	private int port = 4444;
	private AnchorPane root;
	BorderPane borderPane;
	Label yourname, othername, yourglory, otherglory, yourlife, otherlife, currentplayername, otherplayername,
			currentlifepoints, otherlifepoints, yourglorypoints, otherglorypoints, gameover;
	Button rollDice, ready,factButton,instrucButton;
	Button moveToTokyo;
	RadioButton dr1, dr2, dr3, dr4, dr5, dr6,mG,tK,k;
	ImageView div1, div2, div3, div4, div5, div6, monster1, monster2, gameBoard;
	Image id1, id2, id3, id4, id5, id6, gb;
	TextField txtpname;
	private Scene scene;
	int würfelVersuchCounter = 0;
	
	
	public ClientView(Stage kingOfTokyoStage, ClientModel clientModel) throws Exception {
		this.clientModel = clientModel;
		this.setKingOfTokyoStage(kingOfTokyoStage);
		
		initGUI();
		
		scene = new Scene(root);
		kingOfTokyoStage.setScene(scene);
		
		
	
	
		clientModel.startClientConnection(ipaddress, port);
		
	}

	private void initGUI() {
		root = new AnchorPane();
		root.setPrefHeight(700.0);
		root.setPrefWidth(1200.0);

		// Labels die während dem Spiel nicht verändert werden
		// Player1
		currentplayername = new Label("Dein Spieler:");
		currentplayername.setLayoutX(58);
		currentplayername.setLayoutY(300);

		currentlifepoints = new Label("Deine Lebenspunkte:");
		currentlifepoints.setLayoutX(58);
		currentlifepoints.setLayoutY(340);

		yourglorypoints = new Label("Deine Ruhmpunkte:");
		yourglorypoints.setLayoutX(58);
		yourglorypoints.setLayoutY(380);

		otherplayername = new Label("Dein Gegner:");
		otherplayername.setLayoutX(892);
		otherplayername.setLayoutY(300);

		otherlifepoints = new Label("Seine Lebenspunkte:");
		otherlifepoints.setLayoutX(891);
		otherlifepoints.setLayoutY(340);

		otherglorypoints = new Label("Seine Ruhmpunkte:");
		otherglorypoints.setLayoutX(887);
		otherglorypoints.setLayoutY(380);

		// Labels die während dem Spiel verändert werden
		// Player2
		yourname = new Label("Text");
		yourname.setLayoutX(160);
		yourname.setLayoutY(300);

		yourlife = new Label("Text");
		yourlife.setLayoutX(170);
		yourlife.setLayoutY(340);

		yourglory = new Label("Text");
		yourglory.setLayoutX(170);
		yourglory.setLayoutY(380);

		othername = new Label("Text");
		othername.setLayoutX(1010);
		othername.setLayoutY(300);

		otherlife = new Label("Text");
		otherlife.setLayoutX(1010);
		otherlife.setLayoutY(340);

		otherglory = new Label("Text");
		otherglory.setLayoutX(1010);
		otherglory.setLayoutY(380);

		// Game over status
		gameover = new Label("Text");
		gameover.setLayoutX(550);
		gameover.setLayoutY(619);
		gameover.setVisible(false);

		// RadioButtons, sie sind am Anfang nicht sichtbar.
		dr1 = new RadioButton();
		dr1.setLayoutX(230);
		dr1.setLayoutY(560);
		dr1.setVisible(false);

		dr2 = new RadioButton();
		dr2.setLayoutX(340);
		dr2.setLayoutY(560);
		dr2.setVisible(false);

		dr3 = new RadioButton();
		dr3.setLayoutX(460);
		dr3.setLayoutY(560);
		dr3.setVisible(false);

		dr4 = new RadioButton();
		dr4.setLayoutX(580);
		dr4.setLayoutY(560);
		dr4.setVisible(false);

		dr5 = new RadioButton();
		dr5.setLayoutX(700);
		dr5.setLayoutY(560);
		dr5.setVisible(false);

		dr6 = new RadioButton();
		dr6.setLayoutX(820);
		dr6.setLayoutY(560);
		dr6.setVisible(false);

		// Würfelbilder
		div1 = new ImageView();
		div1.setFitHeight(100.0);
		div1.setFitWidth(100.0);
		div1.setLayoutX(200);
		div1.setLayoutY(445);

		div2 = new ImageView();
		div2.setFitHeight(100.0);
		div2.setFitWidth(100.0);
		div2.setLayoutX(310);
		div2.setLayoutY(445);

		div3 = new ImageView();
		div3.setFitHeight(100.0);
		div3.setFitWidth(100.0);
		div3.setLayoutX(430);
		div3.setLayoutY(445);

		div4 = new ImageView();
		div4.setFitHeight(100.0);
		div4.setFitWidth(100.0);
		div4.setLayoutX(550);
		div4.setLayoutY(445);

		div5 = new ImageView();
		div5.setFitHeight(100.0);
		div5.setFitWidth(100.0);
		div5.setLayoutX(670);
		div5.setLayoutY(445);

		div6 = new ImageView();
		div6.setFitHeight(100.0);
		div6.setFitWidth(100.0);
		div6.setLayoutX(790);
		div6.setLayoutY(445);

		// Image Spielermonster
		monster1 = new ImageView();
		monster1.setFitHeight(150.0);
		monster1.setFitWidth(200.0);
		monster1.setLayoutX(35);
		monster1.setLayoutY(100);

		monster2 = new ImageView();
		monster2.setFitHeight(150.0);
		monster2.setFitWidth(200.0);
		monster2.setLayoutX(878);
		monster2.setLayoutY(100);

		// GameBoard
		gb = new Image("./Images/GameBoard.png");
		gameBoard = new ImageView(gb);
		gameBoard.setFitHeight(300.0);
		gameBoard.setFitWidth(300.0);
		gameBoard.setLayoutX(504);
		gameBoard.setLayoutY(66);

		// Button um zu Würfeln
		rollDice = new Button("Wüfeln");
		rollDice.setLayoutX(1009);
		rollDice.setLayoutY(619);
		
		//Button um Facts einzusehen
		factButton=new Button("Facts");
		factButton.setLayoutX(58);
		factButton.setLayoutY(619);
		
		//Button um die Anleitung einzusehen
		instrucButton=new Button("Anleitung");
		instrucButton.setLayoutX(115);
		instrucButton.setLayoutY(619);

		
		// button um nach tokyo zu gelangen
		moveToTokyo = new Button("nach Tokyo");
		moveToTokyo.setLayoutX(1009);
		moveToTokyo.setLayoutY(580);
		moveToTokyo.setVisible(false);

		//zu Stage hinzufügen(labels, buttons etc.)
		root.getChildren().addAll(yourname, yourglory, otherlife, othername, otherglory, yourlife, currentplayername,
				otherplayername, yourglorypoints, otherglorypoints, currentlifepoints, otherlifepoints, gameover, div1,
				div2, div3, div4, div5, div6, monster1, monster2, gameBoard, rollDice, moveToTokyo, dr1, dr2, dr3, dr4,
				dr5, dr6,factButton,instrucButton);

	}

	public void start() {
		// Setzt den Titel anhand der ID, die der Client vom Server erhält.
		kingOfTokyoStage.setTitle("Player " + clientModel.getClientID());
		kingOfTokyoStage.show();

	}
	


	/**
	 * Stopping the view - just make it invisible
	 */
	public void stop() {
		getKingOfTokyoStage().hide();
	}

	/**
	 * Getter for the stage, so that the controller can access window events
	 */

	public Stage getKingOfTokyoStage() {
		return kingOfTokyoStage;
	}

	public void setKingOfTokyoStage(Stage kingOfTokyoStage) {
		this.kingOfTokyoStage = kingOfTokyoStage;
	}

	public void updateGUI() {
		Platform.runLater(() -> {
			Music music = new Music();

			if (clientModel.getGamestate() != null) {

				Player currentPlayer = clientModel.getGamestate().getPlayer(clientModel.getClientID());
				Player otherPlayer = clientModel.getGamestate().getPlayer((clientModel.getClientID() == 1) ? 2 : 1);

				if (clientModel.getClientID() == clientModel.getGamestate().getCurrentPlayerId()) {
					rollDice.setDisable(false);
					if (würfelVersuchCounter < 2) {
						rollDice.setText("Würfeln");
					}
				} else {
					rollDice.setDisable(true);
				}

				if (currentPlayer != null) {
					yourname.setText(currentPlayer.getPlayername());
					if (!currentPlayer.getPlayername().isEmpty()) {
						kingOfTokyoStage.setTitle(currentPlayer.getPlayername());
					}
					yourlife.setText(String.valueOf(currentPlayer.getLifePoints()));
					yourglory.setText(String.valueOf(currentPlayer.getGloryPoints()));

					if (currentPlayer.getGloryPoints() >= 20) {
						clientModel.getGamestate().setWinner(currentPlayer);
					}
					if (currentPlayer.getLifePoints() <= 0) {
						clientModel.getGamestate().setWinner(otherPlayer);
					}
//					if (currentPlayer.isInTokyo()) {
//						moveToTokyo.setDisable(true);
//					}

				}
				if (otherPlayer != null) {
					othername.setText(otherPlayer.getPlayername());
					otherlife.setText(String.valueOf(otherPlayer.getLifePoints()));
					otherglory.setText(String.valueOf(otherPlayer.getGloryPoints()));

					if (otherPlayer.getGloryPoints() >= 20) {
						clientModel.getGamestate().setWinner(otherPlayer);
					}
					if (otherPlayer.getLifePoints() <= 0) {
						clientModel.getGamestate().setWinner(currentPlayer);
					}
					if (otherPlayer.isInTokyo()) {
						moveToTokyo.setVisible(false);
					}
				}

				if (clientModel.getGamestate().getWinner() != null) {
					if (clientModel.getGamestate().getWinner().getPlayerId() == clientModel.getClientID()) {
						gameover.setText("Congratulations! You won!!!");

						if (clientModel.getGamestate().isMusicOn() == true)
							music.start();

						clientModel.getGamestate().setMusicOn(false);

					} else {
						gameover.setText("Game Over! You lost!!!");
					}
					gameover.setVisible(true);
					clientModel.getGamestate().setCurrentPlayerId(0);
				}

			}
		});

	}
	//Neue Stage für Dateneingabe:
		public void insertPlayerData(){
				final ToggleGroup group = new ToggleGroup();

				stage=new Stage();
				AnchorPane iPD=new AnchorPane();
				iPD.setPrefHeight(350);
				iPD.setPrefWidth(500);
				
				Image monsterGigaZaur=new Image("./Images/MonsterGigaZaur.png");
				Image monsterTheKing=new Image("./Images/MonsterTheKing.png");
				Image monsterKraken=new Image("./Images/MonsterKraken.png");
				
				ImageView mGiga=new ImageView(monsterGigaZaur);
				mGiga.setLayoutX(42.5);
				mGiga.setLayoutY(65);
				mGiga.setFitHeight(120);
				mGiga.setFitWidth(110);
				
				ImageView mtheK=new ImageView(monsterTheKing);
				mtheK.setLayoutX(195);
				mtheK.setLayoutY(65);
				mtheK.setFitHeight(120);
				mtheK.setFitWidth(110);
				
				ImageView mK=new ImageView(monsterKraken);
				mK.setFitHeight(120);
				mK.setFitWidth(110);
				mK.setLayoutX(347.5);
				mK.setLayoutY(65);
				
				Label pname=new Label("Bitte Namen eingeben");
				pname.setLayoutX(34);
				pname.setLayoutY(299);
				
				txtpname=new TextField();
				txtpname.setLayoutX(166);
				txtpname.setLayoutY(295);
				
				mG=new RadioButton();
				mG.setLayoutX(86);
				mG.setLayoutY(205);
				mG.setToggleGroup(group);
				mG.setSelected(true);
				
				tK=new RadioButton();
				tK.setLayoutX(240);
				tK.setLayoutY(205);
				tK.setToggleGroup(group);
				
				k=new RadioButton();
				k.setLayoutX(392);
				k.setLayoutY(205);
				k.setToggleGroup(group);
				
				ready=new Button("ready!");
				ready.setLayoutX(377);
				ready.setLayoutY(295);
				
				iPD.getChildren().addAll(ready,tK,k,mG,txtpname,pname,mK,mtheK,mGiga);
				Scene scene2=new Scene(iPD);
				
				if (clientModel.getClientID() == 1) {
					stage.setTitle("Player 1");
				} else {
					stage.setTitle("Player 2");
				}
				stage.setScene(scene2);
				stage.show();
				
				
				
			}
			public void closeinsertPlayerData(){
				stage.close();
			}
			//View mit eigener Stage für die Facts
			public void FactsView(){
				FactsView fView=new FactsView();
				factStage=new Stage();
				factStage.setScene(fView.getScene());
				factStage.show();
				
			}
			
			// View mit eigener Stage für die Anleitung
			public void InstrucView(){
				AnleitungView Aview=new AnleitungView();
				AnleitungStage=new Stage();
				AnleitungStage.setTitle("Spielanleitung");
				AnleitungStage.setScene(Aview.getScene());
				AnleitungStage.show();
			}
			
		}

