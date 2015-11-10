package KingOfTokyoModel;

import java.net.Socket;

public class ClientModel {
	private Socket socket;
	

	
	public ClientModel(){
		
		
	}
	
	public void startClientConnection(String ipaddress, int port)throws Exception{
		setSocket(new Socket(ipaddress, port));
		System.out.println("Client ist gestartet");
		
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}