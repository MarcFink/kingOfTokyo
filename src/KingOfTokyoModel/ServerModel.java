package KingOfTokyoModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import javafx.concurrent.Task;
import javafx.stage.Stage;

public class ServerModel {
	
	
	
	public ServerModel(){
		
	}
public void startServerConnection(int port) throws IOException{
	ServerSocket serverSocket=new ServerSocket(port);
	System.out.println(port+" "+"Server ist gestartet");
	Socket clientSocket=serverSocket.accept();
	System.out.println("Verbindung aufgebaut");
	
	
}
}
