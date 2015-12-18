package KingOfTokyoClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ClientControllerGameBoard {
	/* 
	 * @author Attinkara Robin
	 * */

	private ClientModel clientModel;

	private List<String> diceValues;
	private ClientView clientView;
	private String die1 = "";
	private String die2 = "";
	private String die3 = "";
	private String die4 = "";
	private String die5 = "";
	private String die6 = "";
	private FactsView Fview;
	private Scene scene;
	private Stage factsStage;

	/**
	 * @param clientModel
	 * @param clientView
	 */
	public ClientControllerGameBoard(ClientModel clientModel, ClientView clientView) {

		this.clientView = clientView;
		this.clientModel = clientModel;
		Dice dice = new Dice();

		Platform.runLater(() -> {

			int id = clientModel.getClientID();

			clientView.insertPlayerData();
			
			// Button um das Spiel zu starten
			clientView.ready.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
			
				// Neues Playerobjekt wird erstellt und der Playername wird
				// gesetzt
				clientModel.getGamestate().addPlayer(id);
				clientModel.getGamestate().getPlayer(id).setPlayername(clientView.txtpname.getText());
				clientModel.sendToServer(clientModel.getGamestate());
				clientView.closeinsertPlayerData();
				clientView.start();
				GUIUpdateThread guiThread= new GUIUpdateThread(clientView);
				guiThread.start();
				
			}
			});

				
		});
		
		//Button um die Facts einzusehen
		
		clientView.factButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				clientView.FactsView();
				
			}
		});
		
		//Button um die Anleitung einzusehen
		clientView.instrucButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				clientView.InstrucView();
				
			}
		});
		
		
		

	

		
		//Würfelbutton onclick Action
		clientView.rollDice.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (clientView.würfelVersuchCounter <= 2) {
					//Radiobuttons werden auf visible gesetzt
					clientView.dr1.setVisible(true);
					clientView.dr2.setVisible(true);
					clientView.dr3.setVisible(true);
					clientView.dr4.setVisible(true);
					clientView.dr5.setVisible(true);
					clientView.dr6.setVisible(true);

					
					//erste Würfelrunde 
					if (clientView.würfelVersuchCounter == 0) {
						//falls in Tokyo 
						if (clientModel.getGamestate().getPlayer(clientModel.getClientID()).isInTokyo()) {
							System.out.println("Player " + clientModel.getClientID() + " started game in Tokyo");
							clientModel.getGamestate().getPlayer(clientModel.getClientID()).addGloryPoints(2);
							clientModel.sendToServer(clientModel.getGamestate());
						}
						//Würfelstrings werden initialisiert, damit diese nicht leer sind
						die1 = getRollDice(clientView.div1);
						die2 = getRollDice(clientView.div2);
						die3 = getRollDice(clientView.div3);
						die4 = getRollDice(clientView.div4);
						die5 = getRollDice(clientView.div5);
						die6 = getRollDice(clientView.div6);
					}

					else {
						if (clientView.dr1.isSelected()) {
							die1 = getRollDice(clientView.div1);
						}
						if (clientView.dr2.isSelected()) {
							die2 = getRollDice(clientView.div2);
						}
						if (clientView.dr3.isSelected()) {
							die3 = getRollDice(clientView.div3);
						}
						if (clientView.dr4.isSelected()) {
							die4 = getRollDice(clientView.div4);
						}
						if (clientView.dr5.isSelected()) {
							die5 = getRollDice(clientView.div5);
						}
						if (clientView.dr6.isSelected()) {
							die6 = getRollDice(clientView.div6);
						}
					}
					//Letzte Würfelrunde ; Werte werden ausgelesen
					if (clientView.würfelVersuchCounter == 2) {
						diceValues = new ArrayList<String>();
						clientView.rollDice.setText("Zug beenden");
						diceValues.add(die1);
						diceValues.add(die2);
						diceValues.add(die3);
						diceValues.add(die4);
						diceValues.add(die5);
						diceValues.add(die6);
					}

					clientView.würfelVersuchCounter++;

					System.out.println("Würfel Runde: " + clientView.würfelVersuchCounter);
				} else {
					

					clientView.dr1.setVisible(false);
					clientView.dr2.setVisible(false);
					clientView.dr3.setVisible(false);
					clientView.dr4.setVisible(false);
					clientView.dr5.setVisible(false);
					clientView.dr6.setVisible(false);

					clientView.dr1.setSelected(false);
					clientView.dr2.setSelected(false);
					clientView.dr3.setSelected(false);
					clientView.dr4.setSelected(false);
					clientView.dr5.setSelected(false);
					clientView.dr6.setSelected(false);
					
					System.out.println("Calculating game points..");
					//Alle Punkte werden ausgelesen
					setGamePoints();
					clientView.rollDice.setDisable(true);
					// other players turn
					if (clientModel.getClientID() == 1) {
						clientModel.getGamestate().setCurrentPlayerId(2);
					} else {
						clientModel.getGamestate().setCurrentPlayerId(1);
					}
					//Für nächste Runde wird Würfelcounter 0 gesetzt
					//Gamestate wird als Benachrichtigung zum Server gesendet
					clientView.würfelVersuchCounter = 0;
					clientModel.sendToServer(clientModel.getGamestate());
				}

			}
			// Würfelbilder werden gesetzt
			private String getRollDice(ImageView view) {
				String die;
				die = dice.rollDice();
				if (die.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					view.setImage(img);
				} else if (die.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					view.setImage(img);

				} else if (die.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					view.setImage(img);
				} else if (die.equals("A")) {
					Image img = new Image("./Images/attack.png");
					view.setImage(img);
				} else if (die.equals("H")) {
					Image img = new Image("./Images/heal.png");
					view.setImage(img);
				}
				return die;
			}

		});//Nach Tokyo Button onclick Action
		clientView.moveToTokyo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (clientView.moveToTokyo.getText() == "nach Tokyo") {
					clientModel.getGamestate().getPlayer(clientModel.getClientID()).setInTokyo(true);
					System.out.println("Player " + clientModel.getClientID() + " moved to Tokyo");
					// Bild von Tokyo wird gewechselt
					clientView.gameBoard.setImage(new Image("./Images/InTokyo.JPG"));
					clientView.moveToTokyo.setText("Tokyo verlassen");
					// Glorypoints werden hinzugefügt für Tokyo
					clientModel.getGamestate().getPlayer(clientModel.getClientID()).addGloryPoints(1);
				} else {
					clientModel.getGamestate().getPlayer(clientModel.getClientID()).setInTokyo(false);
					System.out.println("Player " + clientModel.getClientID() + " moved out of Tokyo");
					// Bild von Tokyo wird gewechselt(für den anderen Spieler)
					clientView.gameBoard.setImage(new Image("./Images/GameBoard.png"));
					clientView.moveToTokyo.setText("nach Tokyo");
					clientView.moveToTokyo.setVisible(false);

				}
				clientModel.sendToServer(clientModel.getGamestate());
			}

		});

	}

	private void setGamePoints() {
		int points = 0;
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;

		for (String val : diceValues) {
			if (val == "1") {
				counter1++;
			}
			if (val == "2") {
				counter2++;
			}
			if (val == "3") {
				counter3++;
			}
			if (val == "A") {
				int otherPlayerId = (clientModel.getClientID() == 1) ? 2 : 1;
				System.out.println("Attacking player " + otherPlayerId);
				clientModel.getGamestate().attack(otherPlayerId);
				// Nur wenn der Spieler oder Gegner nicht schon in tokyo ist
				if (!clientModel.getGamestate().getPlayer(clientModel.getClientID()).isInTokyo()
						&& !clientModel.getGamestate().getPlayer(otherPlayerId).isInTokyo()) {
					clientView.moveToTokyo.setVisible(true);
				}
			}
			if (val == "H") {
				// nur heilen nur wenn nicht in Tokyo
				if (!clientModel.getGamestate().getPlayer(clientModel.getClientID()).isInTokyo()) {
					System.out.println("Healing player " + clientModel.getClientID());
					clientModel.getGamestate().heal(clientModel.getClientID());
				}
			}

		}

		points += calcGloryPoints(counter1, 1);
		points += calcGloryPoints(counter2, 2);
		points += calcGloryPoints(counter3, 3);
		clientModel.getGamestate().getPlayer(clientModel.getClientID()).addGloryPoints(points);
		System.out.println("Total glory points: " + points);
	}

	private int calcGloryPoints(int count, int digit) {
		int points = 0;
		if (count / 3 > 0) {
			points = digit * (count / 3) + (count % 3);
		}
		return points;
	}

	public ClientModel getClientModel() {
		return clientModel;
	}

	public void setClientModel(ClientModel clientModel) {
		this.clientModel = clientModel;
	}

	public ClientView getClientView() {
		return clientView;
	}

	public void setClientView(ClientView clientView) {
		this.clientView = clientView;
	}
}
