package KingOfTokyo;

import java.util.ArrayList;
import java.util.List;

import KingOfTokyoModel.ClientModel;
import KingOfTokyoModel.Dice;
import KingOfTokyoModel.GameState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sun.security.jca.GetInstance;

public class ClientControllerGameBoard {

	@FXML
	Button ButtonRollDice;
	@FXML
	RadioButton dr1;
	@FXML
	RadioButton dr2;
	@FXML
	RadioButton dr3;
	@FXML
	RadioButton dr4;
	@FXML
	RadioButton dr5;
	@FXML
	RadioButton dr6;
	@FXML
	ImageView di6;
	@FXML
	ImageView di5;
	@FXML
	ImageView di4;
	@FXML
	ImageView di3;
	@FXML
	ImageView di2;
	@FXML
	ImageView di1;
	@FXML
	ImageView imagemonsterone;
	@FXML
	Label playernameone;
	@FXML
	Label glorypointsone;
	@FXML
	Label lifepointsone;
	@FXML
	Label playernametwo;
	@FXML
	Label glorypointstwo;
	@FXML
	Label lifepointstwo;

	private ClientModel clientmodel;
	private Boolean w1Selected = false;
	private Boolean w2Selected = false;
	private Boolean w3Selected = false;
	private Boolean w4Selected = false;
	private Boolean w5Selected = false;
	private Boolean w6Selected = false;
	private int würfelVersuchCounter = 0;
	private List<String> diceValues;

	public ClientControllerGameBoard(ClientModel clientmodel) {
		this.clientmodel = clientmodel;
	}

	@FXML
	public void dr6action(ActionEvent event) {
		if (w6Selected == false) {
			w6Selected = true;
		} else if (w6Selected == true) {
			w6Selected = false;

		}
	}

	@FXML
	public void dr5action(ActionEvent event) {
		if (w5Selected == false) {
			w5Selected = true;
		} else if (w5Selected == true) {
			w5Selected = false;

		}
	}

	@FXML
	public void dr4action(ActionEvent event) {
		if (w4Selected == false) {
			w4Selected = true;
		} else if (w4Selected == true) {
			w4Selected = false;

		}
	}

	@FXML
	public void dr3action(ActionEvent event) {
		if (w3Selected == false) {
			w3Selected = true;
		} else if (w3Selected == true) {
			w3Selected = false;

		}
	}

	@FXML
	public void dr2action(ActionEvent event) {
		if (w2Selected == false) {
			w2Selected = true;
		} else if (w2Selected == true) {
			w2Selected = false;

		}
	}

	@FXML
	public void dr1action(ActionEvent event) {
		if (w1Selected == false) {
			w1Selected = true;
		} else if (w1Selected == true) {
			w1Selected = false;

		}
	}

	@FXML
	public void ButtonRollDiceAction(ActionEvent event) {
		Dice dice = new Dice();
		diceValues = new ArrayList<String>();

		if (ButtonRollDice.getText().equals("Zug beenden")) {
			//send current gamestate to server
			clientmodel.getServerListener().sendToServer(GameState.getInstance());
			//get current gamestate from server listener
			GameState currentState= clientmodel.getServerListener().getGamestate();
		}
		if (würfelVersuchCounter == 0) {
			String die1 = dice.rollDice();
			if (die1.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				di1.setImage(img);
			} else if (die1.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				di1.setImage(img);

			} else if (die1.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				di1.setImage(img);
			} else if (die1.equals("A")) {
				Image img = new Image("./Images/attack.png");
				di1.setImage(img);
			} else if (die1.equals("H")) {
				Image img = new Image("./Images/heal.png");
				di1.setImage(img);
			}
			diceValues.add(die1);
			String die2 = dice.rollDice();
			if (die2.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				di2.setImage(img);

			} else if (die2.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				di2.setImage(img);
			} else if (die2.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				di2.setImage(img);
			} else if (die2.equals("A")) {
				Image img = new Image("./Images/attack.png");
				di2.setImage(img);
			} else if (die2.equals("H")) {
				Image img = new Image("./Images/heal.png");
				di2.setImage(img);
			}
			diceValues.add(die2);
			String die3 = dice.rollDice();
			if (die3.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				di3.setImage(img);
			} else if (die3.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				di3.setImage(img);
			} else if (die3.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				di3.setImage(img);
			} else if (die3.equals("A")) {
				Image img = new Image("./Images/attack.png");
				di3.setImage(img);
			} else if (die3.equals("H")) {
				Image img = new Image("./Images/heal.png");
				di3.setImage(img);
			}
			diceValues.add(die3);

			String die4 = dice.rollDice();
			if (die4.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				di4.setImage(img);
			} else if (die4.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				di4.setImage(img);
			} else if (die4.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				di4.setImage(img);
			} else if (die4.equals("A")) {
				Image img = new Image("./Images/attack.png");
				di4.setImage(img);
			} else if (die4.equals("H")) {
				Image img = new Image("./Images/heal.png");
				di4.setImage(img);
			}
			diceValues.add(die4);
			String die5 = dice.rollDice();
			if (die5.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				di5.setImage(img);
			} else if (die5.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				di5.setImage(img);
			} else if (die5.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				di5.setImage(img);
			} else if (die5.equals("A")) {
				Image img = new Image("./Images/attack.png");
				di5.setImage(img);
			} else if (die5.equals("H")) {
				Image img = new Image("./Images/heal.png");
				di5.setImage(img);
			}
			diceValues.add(die5);
			String die6 = dice.rollDice();
			if (die6.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				di6.setImage(img);
			} else if (die6.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				di6.setImage(img);
			} else if (die6.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				di6.setImage(img);
			} else if (die6.equals("A")) {
				Image img = new Image("./Images/attack.png");
				di6.setImage(img);
			} else if (die6.equals("H")) {
				Image img = new Image("./Images/heal.png");
				di6.setImage(img);
			}
			diceValues.add(die6);
			dr1.setVisible(true);
			dr2.setVisible(true);
			dr3.setVisible(true);
			dr4.setVisible(true);
			dr5.setVisible(true);
			dr6.setVisible(true);
			würfelVersuchCounter++;

//			for (String val : diceValues) {
//				// durch getinstance die bestehende instanz aufrufen
//				int points = GameState.getInstance().getNumofGloryPointsPlayer1();
//				GameState.getInstance().setNumofGloryPointsPlayer1(points + Integer.getInteger(val));
//			}

			System.out.println(würfelVersuchCounter);
		} else if (würfelVersuchCounter <= 2) {

			if (w1Selected == true) {
				String die1 = dice.rollDice();
				if (die1.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					di1.setImage(img);
				} else if (die1.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					di1.setImage(img);
				} else if (die1.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					di1.setImage(img);
				} else if (die1.equals("A")) {
					Image img = new Image("./Images/attack.png");
					di1.setImage(img);
				} else if (die1.equals("H")) {
					Image img = new Image("./Images/heal.png");
					di1.setImage(img);
				}
			}
			if (w2Selected == true) {
				String die2 = dice.rollDice();
				if (die2.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					di2.setImage(img);
				} else if (die2.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					di2.setImage(img);
				} else if (die2.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					di2.setImage(img);
				} else if (die2.equals("A")) {
					Image img = new Image("./Images/attack.png");
					di2.setImage(img);
				} else if (die2.equals("H")) {
					Image img = new Image("./Images/heal.png");
					di2.setImage(img);
				}
			}
			if (w3Selected == true) {
				String die3 = dice.rollDice();
				if (die3.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					di3.setImage(img);
				} else if (die3.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					di3.setImage(img);
				} else if (die3.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					di3.setImage(img);
				} else if (die3.equals("A")) {
					Image img = new Image("./Images/attack.png");
					di3.setImage(img);
				} else if (die3.equals("H")) {
					Image img = new Image("./Images/heal.png");
					di3.setImage(img);
				}
			}
			if (w4Selected == true) {
				String die4 = dice.rollDice();
				if (die4.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					di4.setImage(img);
				} else if (die4.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					di4.setImage(img);
				} else if (die4.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					di4.setImage(img);
				} else if (die4.equals("A")) {
					Image img = new Image("./Images/attack.png");
					di4.setImage(img);
				} else if (die4.equals("H")) {
					Image img = new Image("./Images/heal.png");
					di4.setImage(img);
				}
			}
			if (w5Selected == true) {
				String die5 = dice.rollDice();
				if (die5.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					di5.setImage(img);
				} else if (die5.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					di5.setImage(img);
				} else if (die5.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					di5.setImage(img);
				} else if (die5.equals("A")) {
					Image img = new Image("./Images/attack.png");
					di5.setImage(img);
				} else if (die5.equals("H")) {
					Image img = new Image("./Images/heal.png");
					di5.setImage(img);
				}
			}
			if (w6Selected == true) {
				String die6 = dice.rollDice();
				if (die6.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					di6.setImage(img);
				} else if (die6.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					di6.setImage(img);
				} else if (die6.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					di6.setImage(img);
				} else if (die6.equals("A")) {
					Image img = new Image("./Images/attack.png");
					di6.setImage(img);
				} else if (die6.equals("H")) {
					Image img = new Image("./Images/heal.png");
					di6.setImage(img);
				}
			}
			würfelVersuchCounter++;
			System.out.println(würfelVersuchCounter);
			// gamestate.setNumofLifePoints(numofLifePoints, playerid);

		} else {
			ButtonRollDice.setText("Zug beenden");
			dr1.setVisible(false);
			dr2.setVisible(false);
			dr3.setVisible(false);
			dr4.setVisible(false);
			dr5.setVisible(false);
			dr6.setVisible(false);
		}
	}
}
