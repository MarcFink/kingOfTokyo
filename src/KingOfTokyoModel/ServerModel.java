package KingOfTokyoModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import javafx.concurrent.Task;

public class ServerModel {
	
	private int portnumber;
	
	public ServerModel(){
		
	}
public void startServerConnection(int port) throws IOException{
	ServerSocket serverSocket=new ServerSocket(port);
	System.out.println(port+" "+"Server ist gestartet");
	Socket clientSocket=serverSocket.accept();
	System.out.println("Verbindung aufgebaut");
	
	
}
}
