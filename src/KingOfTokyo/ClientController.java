package KingOfTokyo;

import KingOfTokyoModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClientController {
	private ClientModel model;
	private ClientController controller;
	private int port;
	private String ipA;
	
	public ClientController(){
	this.model=new ClientModel();
	this.controller=controller;
	this.port=port;
	this.ipA=ipA;
	}

	@FXML TextField ipa;
	@FXML TextField prt;
	
	

	@FXML public void connectClient(ActionEvent event)throws Exception{
		ipA=ipa.getText();
		port=Integer.parseInt(prt.getText());
		model.startClientConnection(ipA,port);
	
		
		

	}
	

	


}
