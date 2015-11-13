package KingOfTokyoModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.logging.Logger;



import KingOfTokyo.ServerController;

import Main.Server;
import javafx.concurrent.Task;


public class ServerModel {

	private ServerSocket serverSocket;
	private Socket clientSocket;

	ArrayList<ClientThread> connections;
	ClientThread activethread;

	public ServerModel(ServerController serverController){
		
		

	}

	private int portnumber;

	public ServerModel() {
		this.connections=new ArrayList<ClientThread>();
		this.activethread=null;

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


	public void startServerConnection1(int port) throws Exception {
		ServerSocket serverSocket = new ServerSocket(port);
		while (true) {
			System.out.println(port + " " + "Server ist gestartet");
			Socket clientSocket = serverSocket.accept();
			System.out.println("Verbindung aufgebaut");
			ClientThread clientThread = new ClientThread(this, clientSocket);
			clientThread.start();
			this.connections.add(clientThread);
			if(this.activethread==null){
				activethread=clientThread;
			}
			this.broadcast();
			
		}

	}
	public void broadcast(){
		for(ClientThread ct:connections){
			if(ct==this.activethread){
			ct.out.println("active");	
			}
			else{
				ct.out.println("passive");
			}
		}
	}
	public void setNextActiveThread(){
		ClientThread nextThread=null;
		int activeIndex =connections.indexOf(this.activethread);
		if(activeIndex==connections.size()-1){
			nextThread=connections.get(0);
		}
		else{
			nextThread=connections.get(activeIndex+1);
		}
		this.activethread=nextThread;
	}

}
