package KingOfTokyoModel;

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

import KingOfTokyo.ServerController;
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
	private ServerModel serverModel;
	private ClientThread clientThread;
	private ArrayList<ClientThread> clientThreadList;

	public ServerModel(ServerController serverController, int prt) {
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
			client_id++;
			gamestate.addPlayer(client_id);
			clientThread = new ClientThread(client_id, clientSocket, serverModel, gamestate);
			// fügt den Thread in eine Arraylist
			clientThreadList.add(clientThread);
			// clientThread wird gestartet
			clientThread.start();
			System.out.println(client_id + ". Client hinzugefügt");
			// clientThreads werden in einer ArrayListe gespeichert
		}
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

		for (ClientThread thread : clientThreadList) {
			thread.sendObjectToClient(gamestate);
		}

	}

}
