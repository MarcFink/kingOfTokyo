package KingOfTokyoModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Platform;

public class ClientModel{

	private Socket socket;
	private int playerid;
	private GameState gamestate=null;
	ClientModel clientmodel;


	public ClientModel() {
		
		

	}

	public void startClientConnection(String ipaddress, int port) throws Exception {
		socket=new Socket("localhost", 4444);
		System.out.println("Client ist gestartet");
		ClientThread clientThread=new ClientThread(clientmodel,socket,gamestate);
		clientThread.start();
	}

	public GameState getGamestate() {
		return gamestate;
	}

	public void setGamestate(GameState gamestate) {
		this.gamestate = gamestate;
	}
	
}