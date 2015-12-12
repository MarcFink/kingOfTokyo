package KingOfTokyoModel;

import java.net.Socket;

public class ClientModel{

	private Socket socket;
	ClientModel clientmodel;
	private ServerListener serverListener;


	public ClientModel() {
		
		

	}

	public void startClientConnection(String ipaddress, int port) throws Exception {
		socket=new Socket("localhost", 4444);
		System.out.println("Client ist gestartet");
		new ServerListener(this,socket).start();
		
		
	}

	
	
}