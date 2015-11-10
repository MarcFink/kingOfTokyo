package KingOfTokyoModel;

import java.io.PrintWriter;
import java.net.Socket;

import KingOfTokyo.ClientController;
import Main.Client;

public class ClientModel {
	ClientModel clientmodel;
	PrintWriter sOutput;
	
	
	public ClientModel(){
		

	}
	
	public void startClientConnection(String ipaddress, int port)throws Exception{
		Socket socket=new Socket(ipaddress, port);
		System.out.println("Client ist gestartet");
		this.sOutput=new PrintWriter(socket.getOutputStream(),true);
		new ServerListener(clientmodel,socket).start();
		 
	}
	
}