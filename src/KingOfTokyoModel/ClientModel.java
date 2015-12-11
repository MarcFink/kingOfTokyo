package KingOfTokyoModel;

import java.net.Socket;

public class ClientModel{

	private Socket socket;
	ClientModel clientmodel;


	public ClientModel() {
		
		

	}

	public void startClientConnection(String ipaddress, int port) throws Exception {
		socket=new Socket("localhost", 4444);
		System.out.println("Client ist gestartet");
		ClientThread clientThread=new ClientThread(clientmodel,socket);
		clientThread.start();
		
	}

	
	
}