package KingOfTokyoModel;

import java.io.PrintWriter;
import java.net.Socket;



public class ClientModel {

	private Socket socket;
	


	ClientModel clientmodel;
	PrintWriter sOutput;
	

	
	public ClientModel(){

		

	}
	
	public void startClientConnection(String ipaddress, int port)throws Exception{
		setSocket(new Socket(ipaddress, port));
		System.out.println("Client ist gestartet");
		this.sOutput=new PrintWriter(socket.getOutputStream(),true);
		new ServerListener(clientmodel,socket).start();
		 
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}