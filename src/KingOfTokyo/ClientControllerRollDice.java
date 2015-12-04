package KingOfTokyo;

import KingOfTokyoModel.Dice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ClientControllerRollDice {
	private Boolean w1Selected = false;
	private Boolean w2Selected = false;
	private Boolean w3Selected = false;
	private Boolean w4Selected = false;
	private Boolean w5Selected = false;
	private Boolean w6Selected = false;
	private int würfelVersuchCounter = 0;

	public ClientControllerRollDice(){
		
	}
	@FXML
	RadioButton wr1;
	@FXML
	RadioButton wr2;
	@FXML
	RadioButton wr3;
	@FXML
	RadioButton wr4;
	@FXML
	RadioButton wr5;
	@FXML
	RadioButton wr6;
	@FXML
	Button Würfeln;
	@FXML
	ImageView wb1;
	@FXML
	ImageView wb5;
	@FXML
	ImageView wb4;
	@FXML
	ImageView wb2;
	@FXML
	ImageView wb3;
	@FXML
	ImageView wb6;
	@FXML ToggleGroup group;

	@FXML
	public void rollDice(ActionEvent event) {
		
		Dice dice = new Dice();

		if (würfelVersuchCounter == 0) {	
			String würfel1 = dice.rollDice();
			if (würfel1.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				wb1.setImage(img);
			} else if (würfel1.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				wb1.setImage(img);
			} else if (würfel1.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				wb1.setImage(img);
			} else if (würfel1.equals("A")) {
				Image img = new Image("./Images/attack.png");
				wb1.setImage(img);
			} else if (würfel1.equals("H")) {
				Image img = new Image("./Images/heal.png");
				wb1.setImage(img);
			}
			String würfel2 = dice.rollDice();
			if (würfel2.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				wb2.setImage(img);
			} else if (würfel2.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				wb2.setImage(img);
			} else if (würfel2.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				wb2.setImage(img);
			} else if (würfel2.equals("A")) {
				Image img = new Image("./Images/attack.png");
				wb2.setImage(img);
			} else if (würfel2.equals("H")) {
				Image img = new Image("./Images/heal.png");
				wb2.setImage(img);
			}
			String würfel3 = dice.rollDice();
			if (würfel3.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				wb3.setImage(img);
			} else if (würfel3.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				wb3.setImage(img);
			} else if (würfel3.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				wb3.setImage(img);
			} else if (würfel3.equals("A")) {
				Image img = new Image("./Images/attack.png");
				wb3.setImage(img);
			} else if (würfel3.equals("H")) {
				Image img = new Image("./Images/heal.png");
				wb3.setImage(img);
			}
			String würfel4 = dice.rollDice();
			if (würfel4.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				wb4.setImage(img);
			} else if (würfel4.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				wb4.setImage(img);
			} else if (würfel4.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				wb4.setImage(img);
			} else if (würfel4.equals("A")) {
				Image img = new Image("./Images/attack.png");
				wb4.setImage(img);
			} else if (würfel4.equals("H")) {
				Image img = new Image("./Images/heal.png");
				wb4.setImage(img);
			}
			String würfel5 = dice.rollDice();
			if (würfel5.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				wb5.setImage(img);
			} else if (würfel5.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				wb5.setImage(img);
			} else if (würfel5.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				wb5.setImage(img);
			} else if (würfel5.equals("A")) {
				Image img = new Image("./Images/attack.png");
				wb5.setImage(img);
			} else if (würfel5.equals("H")) {
				Image img = new Image("./Images/heal.png");
				wb5.setImage(img);
			}
			String würfel6 = dice.rollDice();
			if (würfel6.equals("1")) {
				Image img = new Image("./Images/Num1.png");
				wb6.setImage(img);
			} else if (würfel6.equals("2")) {
				Image img = new Image("./Images/Num2.png");
				wb6.setImage(img);
			} else if (würfel6.equals("3")) {
				Image img = new Image("./Images/Num3.png");
				wb6.setImage(img);
			} else if (würfel6.equals("A")) {
				Image img = new Image("./Images/attack.png");
				wb6.setImage(img);
			} else if (würfel6.equals("H")) {
				Image img = new Image("./Images/heal.png");
				wb6.setImage(img);
			}
			
			wr1.setVisible(true);
			wr2.setVisible(true);
			wr3.setVisible(true);
			wr4.setVisible(true);
			wr5.setVisible(true);
			wr6.setVisible(true);
			würfelVersuchCounter++;
			System.out.println(würfelVersuchCounter);
		} else if (würfelVersuchCounter <= 2) {

			if (w1Selected == true) {
				String würfel1 = dice.rollDice();
				if (würfel1.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					wb1.setImage(img);
				} else if (würfel1.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					wb1.setImage(img);
				} else if (würfel1.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					wb1.setImage(img);
				} else if (würfel1.equals("A")) {
					Image img = new Image("./Images/attack.png");
					wb1.setImage(img);
				} else if (würfel1.equals("H")) {
					Image img = new Image("./Images/heal.png");
					wb1.setImage(img);
				}
			}
			if (w2Selected == true) {
				String würfel2 = dice.rollDice();
				if (würfel2.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					wb2.setImage(img);
				} else if (würfel2.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					wb2.setImage(img);
				} else if (würfel2.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					wb2.setImage(img);
				} else if (würfel2.equals("A")) {
					Image img = new Image("./Images/attack.png");
					wb2.setImage(img);
				} else if (würfel2.equals("H")) {
					Image img = new Image("./Images/heal.png");
					wb2.setImage(img);
				}
			}
			if (w3Selected == true) {
				String würfel3 = dice.rollDice();
				if (würfel3.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					wb3.setImage(img);
				} else if (würfel3.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					wb3.setImage(img);
				} else if (würfel3.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					wb3.setImage(img);
				} else if (würfel3.equals("A")) {
					Image img = new Image("./Images/attack.png");
					wb3.setImage(img);
				} else if (würfel3.equals("H")) {
					Image img = new Image("./Images/heal.png");
					wb3.setImage(img);
				}
			}
			if (w4Selected == true) {
				String würfel4 = dice.rollDice();
				if (würfel4.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					wb4.setImage(img);
				} else if (würfel4.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					wb4.setImage(img);
				} else if (würfel4.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					wb4.setImage(img);
				} else if (würfel4.equals("A")) {
					Image img = new Image("./Images/attack.png");
					wb4.setImage(img);
				} else if (würfel4.equals("H")) {
					Image img = new Image("./Images/heal.png");
					wb4.setImage(img);
				}
			}
			if (w5Selected == true) {
				String würfel5 = dice.rollDice();
				if (würfel5.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					wb5.setImage(img);
				} else if (würfel5.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					wb5.setImage(img);
				} else if (würfel5.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					wb5.setImage(img);
				} else if (würfel5.equals("A")) {
					Image img = new Image("./Images/attack.png");
					wb5.setImage(img);
				} else if (würfel5.equals("H")) {
					Image img = new Image("./Images/heal.png");
					wb5.setImage(img);
				}
			}
			if (w6Selected == true) {
				String würfel6 = dice.rollDice();
				if (würfel6.equals("1")) {
					Image img = new Image("./Images/Num1.png");
					wb6.setImage(img);
				} else if (würfel6.equals("2")) {
					Image img = new Image("./Images/Num2.png");
					wb6.setImage(img);
				} else if (würfel6.equals("3")) {
					Image img = new Image("./Images/Num3.png");
					wb6.setImage(img);
				} else if (würfel6.equals("A")) {
					Image img = new Image("./Images/attack.png");
					wb6.setImage(img);
				} else if (würfel6.equals("H")) {
					Image img = new Image("./Images/heal.png");
					wb6.setImage(img);
				}
			}
			würfelVersuchCounter++;
			System.out.println(würfelVersuchCounter);
		} else {
			Würfeln.setText("Zug beenden");
			wr1.setVisible(false);
			wr2.setVisible(false);
			wr3.setVisible(false);
			wr4.setVisible(false);
			wr5.setVisible(false);
			wr6.setVisible(false);
		}
	}

	
	@FXML
	public void w1Action(ActionEvent event) {
		if (w1Selected == false) {
			w1Selected = true;
		} else if (w1Selected == true) {
			w1Selected = false;

		}
	}

	@FXML
	public void w2Action(ActionEvent event) {
		if (w2Selected == false) {
			w2Selected = true;
		} else if (w2Selected == true) {
			w2Selected = false;

		}
	}

	@FXML
	public void w3Action(ActionEvent event) {
		if (w3Selected == false) {
			w3Selected = true;
		} else if (w3Selected == true) {
			w3Selected = false;

		}
	}

	@FXML
	public void w4Action(ActionEvent event) {
		if (w4Selected == false) {
			w4Selected = true;
		} else if (w4Selected == true) {
			w4Selected = false;

		}
	}

	@FXML
	public void w5Action(ActionEvent event) {
		if (w5Selected == false) {
			w5Selected = true;
		} else if (w5Selected == true) {
			w5Selected = false;

		}
	}

	@FXML
	public void w6Action(ActionEvent event) {
		if (w6Selected == false) {
			w6Selected = true;
		} else if (w6Selected == true) {
			w6Selected = false;

		}
	}
}


