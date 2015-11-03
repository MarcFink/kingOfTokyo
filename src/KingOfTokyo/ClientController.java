package KingOfTokyo;

import KingOfTokyoModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClientController {
	final private ClientModel model;
	
	public ClientController(ClientModel model){
		this.model=model;
	}
	
	@FXML TextField ipadresse;
	@FXML TextField prt;

	@FXML public void connectClient(ActionEvent event){
			read();
	}

	private String read() {
		String ipa=ipadresse.getText();
		String port=prt.getText();

		return ipa+" "+port;
	}


}
