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
	private GameState gamestate;
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
		gamestate = GameState.getInstance();
		
	
	}

	public void start() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println(port + " Server ist gestartet");
		
		while (true) {
			clientSocket = serverSocket.accept();
			this.out = new ObjectOutputStream(clientSocket.getOutputStream());
			client_id++;
			clientThread = new ClientThread(client_id, clientSocket, this, gamestate);
			clientThreadList.add(clientThread);
			clientThread.start();
			System.out.println(client_id + ". Client hinzugefügt");
			
			

		}
		
		// fügt den Thread in eine Arraylist

		// clientThread wird gestartet

		// clientThreads werden in einer ArrayListe gespeichert
	}
	

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void objectfromclientSetGameState(GameState gs) {
		this.gamestate = gs;

		GameState.setInstance(gs);

	}

	public void broadcast(GameState gamestate) {
		// schickt das Gamestate an alle verbundenen Clients
		System.out.println("Broadcast to clients..");
		for (ClientThread thread : clientThreadList) {
			sendObjectToClient(gamestate);
		}

	}

	public void sendObjectToClient(GameState gamestate) {
		try {
			this.out.writeObject(gamestate);
			out.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
