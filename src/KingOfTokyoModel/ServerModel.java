package KingOfTokyoModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import KingOfTokyo.ServerController;

public class ServerModel {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public ServerModel(ServerController serverController){
		
		
		
	}
public void startServerConnection(int port) throws IOException{
	serverSocket=new ServerSocket(port);
	System.out.println(port+" "+"Server ist gestartet");
	setClientSocket(serverSocket.accept());
	System.out.println("Verbindung aufgebaut");
	
	
}
public Socket getClientSocket() {
	return clientSocket;
}
public void setClientSocket(Socket clientSocket) {
	this.clientSocket = clientSocket;
}
}
