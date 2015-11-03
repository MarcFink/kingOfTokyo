package KingOfTokyo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ServerController {
	
	@FXML TextField port;
	

	@FXML public void connecting(ActionEvent event){
		System.out.println(read());
		}

		private String read() {
			String prt=port.getText();

			return prt;
		}
	}

		
		
	
	
	
	


