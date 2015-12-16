package KingOfTokyoClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import KingOfTokyoCommon.GameState;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;

public class ClientControllerGameBoard {

	private ClientModel clientModel;
	private Boolean w1Selected = false;
	private Boolean w2Selected = false;
	private Boolean w3Selected = false;
	private Boolean w4Selected = false;
	private Boolean w5Selected = false;
	private Boolean w6Selected = false;
	private int würfelVersuchCounter = 0;
	private List<String> diceValues;
	private ClientView clientView;

	/**
	 * @param clientModel
	 * @param clientView
	 */
	public ClientControllerGameBoard(ClientModel clientModel, ClientView clientView) {

		this.clientView=clientView;
		this.clientModel=clientModel;
		Dice dice = new Dice();
		diceValues = new ArrayList<String>();
		


		
		

		

		Platform.runLater(() -> {
			

			int i = clientModel.getClientID();

			TextInputDialog dialog = new TextInputDialog("");
			dialog.setTitle("Text Input Dialog");
			dialog.setHeaderText("Look, a Text Input Dialog");
			dialog.setContentText("Please enter your name:");

			// Den eingegebnen Wert verarbeiten
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {

				System.out.println("Your name: " + result.get());

				// Neues Playerobjekt wird erstellt und der Playername wird
				// gesetzt
				if (i == 1) {
					clientModel.getGamestate().setPlayername1(result.get());
					clientModel.sendToServer(clientModel.getGamestate());
					
					
					
					

					//
					//
				} else {

					clientModel.getGamestate().setPlayername2(result.get());
					clientModel.sendToServer(clientModel.getGamestate());
					
					
					

					// // erlaubt das inaktivsetzen von Buttons
//					clientView.rollDice.setDisable(true);
					//

				}

			}
			
			
		});

		clientView.rollDice.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				
				

				clientView.dr1.setVisible(true);
				clientView.dr2.setVisible(true);
				clientView.dr3.setVisible(true);
				clientView.dr4.setVisible(true);
				clientView.dr5.setVisible(true);
				clientView.dr6.setVisible(true);

				if (clientView.rollDice.getText().equals("Zug beenden")) {
					
					clientModel.getGamestate().setPlayertwoglory("20");
					clientModel.sendToServer(clientModel.getGamestate());
					
//					if(clientModel.getGamestate().isPlayerTurn1()==true){
//						clientModel.getGamestate().setPlayerTurn1(false);
//					}
//					else if(clientModel.getGamestate().isPlayerTurn1()==false){
//						clientModel.getGamestate().setPlayerTurn1(true);
						
//					}
					// send current gamestate to server
					// clientmodel.sendToServer(currentState);
					// get current gamestate from server listener
					// GameState currentState= clientmodel.getGamestate();
				}
				if (würfelVersuchCounter == 0) {
					clientModel.sendToServer(clientModel.getGamestate());

					String die1 = dice.rollDice();
					if (die1.equals("1")) {
						Image img = new Image("./Images/Num1.png");
						clientView.div1.setImage(img);
					} else if (die1.equals("2")) {
						Image img = new Image("./Images/Num2.png");
						clientView.div1.setImage(img);

					} else if (die1.equals("3")) {
						Image img = new Image("./Images/Num3.png");
						clientView.div1.setImage(img);
					} else if (die1.equals("A")) {
						Image img = new Image("./Images/attack.png");
						clientView.div1.setImage(img);
					} else if (die1.equals("H")) {
						Image img = new Image("./Images/heal.png");
						clientView.div1.setImage(img);
					}
					diceValues.add(die1);
					String die2 = dice.rollDice();
					if (die2.equals("1")) {
						Image img = new Image("./Images/Num1.png");
						clientView.div2.setImage(img);

					} else if (die2.equals("2")) {
						Image img = new Image("./Images/Num2.png");
						clientView.div2.setImage(img);
					} else if (die2.equals("3")) {
						Image img = new Image("./Images/Num3.png");
						clientView.div2.setImage(img);
					} else if (die2.equals("A")) {
						Image img = new Image("./Images/attack.png");
						clientView.div2.setImage(img);
					} else if (die2.equals("H")) {
						Image img = new Image("./Images/heal.png");
						clientView.div2.setImage(img);
					}
					diceValues.add(die2);
					String die3 = dice.rollDice();
					if (die3.equals("1")) {
						Image img = new Image("./Images/Num1.png");
						clientView.div3.setImage(img);
					} else if (die3.equals("2")) {
						Image img = new Image("./Images/Num2.png");
						clientView.div3.setImage(img);
					} else if (die3.equals("3")) {
						Image img = new Image("./Images/Num3.png");
						clientView.div3.setImage(img);
					} else if (die3.equals("A")) {
						Image img = new Image("./Images/attack.png");
						clientView.div3.setImage(img);
					} else if (die3.equals("H")) {
						Image img = new Image("./Images/heal.png");
						clientView.div3.setImage(img);
					}
					diceValues.add(die3);

					String die4 = dice.rollDice();
					if (die4.equals("1")) {
						Image img = new Image("./Images/Num1.png");
						clientView.div4.setImage(img);
					} else if (die4.equals("2")) {
						Image img = new Image("./Images/Num2.png");
						clientView.div4.setImage(img);
					} else if (die4.equals("3")) {
						Image img = new Image("./Images/Num3.png");
						clientView.div4.setImage(img);
					} else if (die4.equals("A")) {
						Image img = new Image("./Images/attack.png");
						clientView.div4.setImage(img);
					} else if (die4.equals("H")) {
						Image img = new Image("./Images/heal.png");
						clientView.div4.setImage(img);
					}
					diceValues.add(die4);
					String die5 = dice.rollDice();
					if (die5.equals("1")) {
						Image img = new Image("./Images/Num1.png");
						clientView.div5.setImage(img);
					} else if (die5.equals("2")) {
						Image img = new Image("./Images/Num2.png");
						clientView.div5.setImage(img);
					} else if (die5.equals("3")) {
						Image img = new Image("./Images/Num3.png");
						clientView.div5.setImage(img);
					} else if (die5.equals("A")) {
						Image img = new Image("./Images/attack.png");
						clientView.div5.setImage(img);
					} else if (die5.equals("H")) {
						Image img = new Image("./Images/heal.png");
						clientView.div5.setImage(img);
					}
					diceValues.add(die5);
					String die6 = dice.rollDice();
					if (die6.equals("1")) {
						Image img = new Image("./Images/Num1.png");
						clientView.div6.setImage(img);
					} else if (die6.equals("2")) {
						Image img = new Image("./Images/Num2.png");
						clientView.div6.setImage(img);
					} else if (die6.equals("3")) {
						Image img = new Image("./Images/Num3.png");
						clientView.div6.setImage(img);
					} else if (die6.equals("A")) {
						Image img = new Image("./Images/attack.png");
						clientView.div6.setImage(img);
					} else if (die6.equals("H")) {
						Image img = new Image("./Images/heal.png");
						clientView.div6.setImage(img);
					}
					diceValues.add(die6);
					clientView.dr1.setVisible(true);
					clientView.dr2.setVisible(true);
					clientView.dr3.setVisible(true);
					clientView.dr4.setVisible(true);
					clientView.dr5.setVisible(true);
					clientView.dr6.setVisible(true);
					würfelVersuchCounter++;

					// for (String val : diceValues) {
					// // durch getinstance die bestehende instanz aufrufen
					// int points =
					// GameState.getInstance().getNumofGloryPointsPlayer1();
					// GameState.getInstance().setNumofGloryPointsPlayer1(points
					// + Integer.getInteger(val));
					// }

					System.out.println(würfelVersuchCounter);
				} else if (würfelVersuchCounter <= 2) {

					if (w1Selected == true) {
						String die1 = dice.rollDice();
						if (die1.equals("1")) {
							Image img = new Image("./Images/Num1.png");
							clientView.div1.setImage(img);
						} else if (die1.equals("2")) {
							Image img = new Image("./Images/Num2.png");
							clientView.div1.setImage(img);
						} else if (die1.equals("3")) {
							Image img = new Image("./Images/Num3.png");
							clientView.div1.setImage(img);
						} else if (die1.equals("A")) {
							Image img = new Image("./Images/attack.png");
							clientView.div1.setImage(img);
						} else if (die1.equals("H")) {
							Image img = new Image("./Images/heal.png");
							clientView.div1.setImage(img);
						}
					}
					if (w2Selected == true) {
						String die2 = dice.rollDice();
						if (die2.equals("1")) {
							Image img = new Image("./Images/Num1.png");
							clientView.div2.setImage(img);
						} else if (die2.equals("2")) {
							Image img = new Image("./Images/Num2.png");
							clientView.div2.setImage(img);
						} else if (die2.equals("3")) {
							Image img = new Image("./Images/Num3.png");
							clientView.div2.setImage(img);
						} else if (die2.equals("A")) {
							Image img = new Image("./Images/attack.png");
							clientView.div2.setImage(img);
						} else if (die2.equals("H")) {
							Image img = new Image("./Images/heal.png");
							clientView.div2.setImage(img);
						}
					}
					if (w3Selected == true) {
						String die3 = dice.rollDice();
						if (die3.equals("1")) {
							Image img = new Image("./Images/Num1.png");
							clientView.div3.setImage(img);
						} else if (die3.equals("2")) {
							Image img = new Image("./Images/Num2.png");
							clientView.div3.setImage(img);
						} else if (die3.equals("3")) {
							Image img = new Image("./Images/Num3.png");
							clientView.div3.setImage(img);
						} else if (die3.equals("A")) {
							Image img = new Image("./Images/attack.png");
							clientView.div3.setImage(img);
						} else if (die3.equals("H")) {
							Image img = new Image("./Images/heal.png");
							clientView.div3.setImage(img);
						}
					}
					if (w4Selected == true) {
						String die4 = dice.rollDice();
						if (die4.equals("1")) {
							Image img = new Image("./Images/Num1.png");
							clientView.div4.setImage(img);
						} else if (die4.equals("2")) {
							Image img = new Image("./Images/Num2.png");
							clientView.div4.setImage(img);
						} else if (die4.equals("3")) {
							Image img = new Image("./Images/Num3.png");
							clientView.div4.setImage(img);
						} else if (die4.equals("A")) {
							Image img = new Image("./Images/attack.png");
							clientView.div4.setImage(img);
						} else if (die4.equals("H")) {
							Image img = new Image("./Images/heal.png");
							clientView.div4.setImage(img);
						}
					}
					if (w5Selected == true) {
						String die5 = dice.rollDice();
						if (die5.equals("1")) {
							Image img = new Image("./Images/Num1.png");
							clientView.div5.setImage(img);
						} else if (die5.equals("2")) {
							Image img = new Image("./Images/Num2.png");
							clientView.div5.setImage(img);
						} else if (die5.equals("3")) {
							Image img = new Image("./Images/Num3.png");
							clientView.div5.setImage(img);
						} else if (die5.equals("A")) {
							Image img = new Image("./Images/attack.png");
							clientView.div5.setImage(img);
						} else if (die5.equals("H")) {
							Image img = new Image("./Images/heal.png");
							clientView.div5.setImage(img);
						}
					}
					if (w6Selected == true) {
						String die6 = dice.rollDice();
						if (die6.equals("1")) {
							Image img = new Image("./Images/Num1.png");
							clientView.div6.setImage(img);
						} else if (die6.equals("2")) {
							Image img = new Image("./Images/Num2.png");
							clientView.div6.setImage(img);
						} else if (die6.equals("3")) {
							Image img = new Image("./Images/Num3.png");
							clientView.div6.setImage(img);
						} else if (die6.equals("A")) {
							Image img = new Image("./Images/attack.png");
							clientView.div6.setImage(img);
						} else if (die6.equals("H")) {
							Image img = new Image("./Images/heal.png");
							clientView.div6.setImage(img);
						}
					}
					würfelVersuchCounter++;
					System.out.println(würfelVersuchCounter);
					// gamestate.setNumofLifePoints(numofLifePoints, playerid);

				} else {
					clientView.rollDice.setText("Zug beenden");
					clientView.dr1.setVisible(false);
					clientView.dr2.setVisible(false);
					clientView.dr3.setVisible(false);
					clientView.dr4.setVisible(false);
					clientView.dr5.setVisible(false);
					clientView.dr6.setVisible(false);
				}

			}
		});

		// currentState=clientmodel.getGamestate();
		// players=currentState.getPlayerlist();
		//
		//
		//
		// Platform.runLater(()->{
		//

		//
		//
		// });

		clientView.dr1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (w1Selected == false) {
					w1Selected = true;
				} else if (w1Selected == true) {
					w1Selected = false;
				}

			}
		});

		clientView.dr5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (w5Selected == false) {
					w5Selected = true;
				} else if (w5Selected == true) {
					w5Selected = false;
				}

			}
		});

		clientView.dr4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (w4Selected == false) {
					w4Selected = true;
				} else if (w4Selected == true) {
					w4Selected = false;
				}

			}
		});

		clientView.dr3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (w3Selected == false) {
					w3Selected = true;
				} else if (w3Selected == true) {
					w3Selected = false;
				}

			}
		});

		clientView.dr2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (w2Selected == false) {
					w2Selected = true;
				} else if (w2Selected == true) {
					w2Selected = false;
				}

			}
		});

		clientView.dr1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (w1Selected == false) {
					w1Selected = true;
				} else if (w1Selected == true) {
					w1Selected = false;
				}

			}
		});

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
