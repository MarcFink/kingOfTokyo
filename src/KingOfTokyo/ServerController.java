package KingOfTokyo;

import KingOfTokyoModel.ClientModel;
import KingOfTokyoModel.ServerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ServerController {
	private ServerModel model;
	public ServerController(){
		this.model=new ServerModel();
		}
	@FXML TextField txtprt;
	String stringprt;
	
	
	@FXML public void connecting(ActionEvent event){
		
//		stringprt=txtprt.getText();
//		model.getPort(stringprt);
//		Integer port = new Integer(stringprt);
//		System.out.println(port);
//		model.startServerSocket(port);
		
		}

//		private String read() {
//		String prt=txtprt.getText();
//
//		return prt;
//		}
	}

		
		
	
	
	
	


