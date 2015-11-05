package KingOfTokyoModel;

import java.net.Socket;

import KingOfTokyo.ClientController;

public class ClientModel {
	private ClientModel model;

	
	public ClientModel(){
		this.model=model;
		
	}
	
	public void startClientConnection(String ipaddress, int port)throws Exception{
		Socket socket=new Socket(ipaddress, port);
		System.out.println("Client ist gestartet");
		
	}
}