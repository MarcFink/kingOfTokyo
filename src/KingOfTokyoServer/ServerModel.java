package KingOfTokyoServer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import KingOfTokyoCommon.GameState;
import javafx.application.Platform;
import javafx.concurrent.Task;

public class ServerModel {
	private Integer port;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private GameState gameState;
	private static int client_id = 0;
	ServerController serverController;
	ObjectInputStream serverInputStream;
	ObjectOutputStream serverOutputStream;
	private ClientThread clientThread;
	private ArrayList<ClientThread> clientThreadList;
	private ObjectOutputStream out;
	

	public ServerModel(ServerController serverController, int prt) throws IOException {
		// Erstellt das GameStateobjekt, welches während dem Spielen hin und her
		// geschickt wird.
		this.serverController = serverController;
		clientThreadList = new ArrayList<ClientThread>();
		this.port = prt;
		gameState = GameState.getInstance();
		
	
	}

	public void start() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println(port + " Server ist gestartet");
		
		while (true) {
			clientSocket = serverSocket.accept();
			this.out = new ObjectOutputStream(clientSocket.getOutputStream());
			client_id++;
			clientThread = new ClientThread(client_id, clientSocket, this, gameState);
			clientThreadList.add(clientThread);
			clientThread.start();
			System.out.println(client_id + ". Client hinzugefügt");
			//sendet als erstes die ClientID des ClientThreads zu dem dazugehörigen
			//Client, so weiss jeder Client welcher ClientThread zu ihm gehört
			sendIDToClient(client_id);
			
			
			

		}
		
		// fügt den Thread in eine Arraylist

		// clientThread wird gestartet

		// clientThreads werden in einer ArrayListe gespeichert
	}
	

	private void sendIDToClient(int client_id) {
		try {
			this.out.writeInt(client_id);
			System.out.println("Objekt wurde verschickt");
			out.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
		
		
		

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void objectfromclientSetGameState(GameState gs) {
		this.gameState = gs;

		GameState.setInstance(gs);

	}

	public void broadcast(GameState gameState) {
		// schickt das Gamestate an alle verbundenen Clients
		
		for (ClientThread thread : clientThreadList) {
			sendObjectToClient(gameState);
			System.out.println("Broadcast to clients..");
		}

	}

	public void sendObjectToClient(GameState gameState) {
		try {
			this.out.writeObject(gameState);
			System.out.println("Objekt wurde verschickt");
			out.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
