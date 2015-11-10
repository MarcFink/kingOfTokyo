package KingOfTokyoModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

import Main.Server;
import javafx.concurrent.Task;

public class ServerModel {
	ArrayList<ClientThread> connections;
	ClientThread activethread;
	
	

	private int portnumber;

	public ServerModel() {
		this.connections=new ArrayList<ClientThread>();
		this.activethread=null;
	}

	public void startServerConnection(int port) throws Exception {
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
