package KingOfTokyo;

import java.io.IOException;

import KingOfTokyoModel.ClientModel;
import KingOfTokyoModel.ServerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ServerController {
	private ServerModel model;
	private ServerController controller;
	
	public ServerController(){
		this.model=new ServerModel();
		this.controller=controller;
		}
	@FXML TextField port;
			int prt;
	
	
	@FXML public void connecting(ActionEvent event) throws IOException{
		prt=Integer.parseInt(port.getText());
		model.startServerConnection(prt);
		
		}

	public int getPortNr(){
		return prt;
	}
}


		
		
	
	
	
	


