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
	private int prt;
	
	public ServerController(){
		this.model=new ServerModel();
		this.controller=controller;
		}
	@FXML TextField port;
	
	
			
	
	
	@FXML public void connecting(ActionEvent event) throws Exception{
		prt=Integer.parseInt(port.getText());
		model.startServerConnection(prt);
		
		}

	public int getPortNr(){
		return prt;
	}

	@FXML public void cancel(ActionEvent event){
		System.exit(0);
	}
}


		
		
	
	
	
	


