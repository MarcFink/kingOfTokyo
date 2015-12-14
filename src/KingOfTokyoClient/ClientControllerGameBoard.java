package KingOfTokyoClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import KingOfTokyoCommon.GameState;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sun.security.jca.GetInstance;

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
	private GameState currentState;
	private ArrayList players;
	private ClientView clientView;

	public ClientControllerGameBoard(ClientModel clientmodel, ClientView clientView) {
		this.clientView = clientView;
		this.clientModel = clientModel;
		Dice dice = new Dice();
		diceValues = new ArrayList<String>();
		
//		//Holt den Gamestate vom ClientModel speichert sie im currentState
//		currentState=clientModel.getGamestate();
//		
//		//ArrayList die sich im GameState befindet wir in players gespeichert
//		players=currentState.getPlayerlist();
//	
//		//Wenn die ArrayList bereits einen Spieler hat soll das Label von Playerone mit dem Spielernamen
//		if(players.size()==1){
//		Player player1=(Player) players.get(0);
//		clientView.pname1.setText(player1.getPlayername());
//			
//		
//		}
		
		
//		
//		if(players.size()==0){
//			Player player1=new Player();
//			player1
//			dialog.box
//			player1.setName("result out of dialogbox")
//			monster
//			add.toplayers
//		}else{
//			
//			player2 ..getClass().getName()..
//			
//			dasdasdas
//			
//			asdasda
//			
//			
//		}

		
		
		
		
		
		
		

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
					// send current gamestate to server
					// clientmodel.sendToServer(currentState);
					// get current gamestate from server listener
					// GameState currentState= clientmodel.getGamestate();
				}
				if (würfelVersuchCounter == 0) {
					

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
		// TextInputDialog dialog = new TextInputDialog("walter");
		// dialog.setTitle("Text Input Dialog");
		// dialog.setHeaderText("Look, a Text Input Dialog");
		// dialog.setContentText("Please enter your name:");
		//
		// // Traditional way to get the response value.
		// Optional<String> result = dialog.showAndWait();
		// if (result.isPresent()){
		// System.out.println("Your name: " + result.get());
		//
		// }
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
}
