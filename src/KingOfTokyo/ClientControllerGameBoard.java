package KingOfTokyo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ClientControllerGameBoard extends ClientControllerNewGamePlattform{

	public ClientControllerGameBoard(){
		
	}


@FXML
public void ErsterZug(ActionEvent event) throws IOException {
	Stage würfelStage = new Stage();
	AnchorPane würfeln = (AnchorPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/RollDice.fxml"));
	Scene scene = new Scene(würfeln);
	würfelStage.setScene(scene);
	würfelStage.setTitle("Würfeln");
	würfelStage.show();
	RadioButton wr1 = (RadioButton) scene.lookup("#wr1");
	wr1.setVisible(false);
	RadioButton wr2 = (RadioButton) scene.lookup("#wr2");
	wr2.setVisible(false);
	RadioButton wr3 = (RadioButton) scene.lookup("#wr3");
	wr3.setVisible(false);
	RadioButton wr4 = (RadioButton) scene.lookup("#wr4");
	wr4.setVisible(false);
	RadioButton wr5 = (RadioButton) scene.lookup("#wr5");
	wr5.setVisible(false);
	RadioButton wr6 = (RadioButton) scene.lookup("#wr6");
	wr6.setVisible(false);
	

}
}