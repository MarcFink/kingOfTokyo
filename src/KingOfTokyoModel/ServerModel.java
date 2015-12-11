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
	private ServerThread serverThread;
	private ArrayList <ServerThread> serverThreadlist;



	public ServerModel(ServerController serverController, int prt) {
		// Erstellt das GameStateobjekt, welches während dem Spielen hin und her
		// geschickt wird.
		this.serverController = serverController;
		serverThreadlist = new ArrayList<ServerThread>();
		this.port = prt;
		gamestate = GameState.getGameState();
	}

	public void connectServer() throws IOException {

		// Serversocket wird erstellt und läuft in einem eigenen anonymen Thread
		new Thread(new Runnable() {
			@Override
			public void run() {

				try {

					serverSocket = new ServerSocket(port);
					System.out.println(port + " Server ist gestartet");
					connectClient();

				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void connectClient() throws IOException, InterruptedException {
		// Jeder Client erhält seinen eigenen Thread
		while (true) {
			clientSocket = serverSocket.accept();

			client_id++;
			gamestate.addPlayer(client_id);
			serverThread = new ServerThread(client_id, clientSocket, serverModel, gamestate);
			//fügt den Thread in eine Arraylist
			serverThreadlist.add(serverThread);
			// clientThread wird gestartet
			serverThread.start();
			System.out.println(client_id + ". Client hinzugefügt");
			// clientThreads werden in einer ArrayListe gespeichert
			
		}

	}

	public void objectfromclientSetGameState(GameState gs) {
		this.gamestate = gs;

		GameState.setGameState(gs);

	}

	public void broadcast(GameState gamestate) {
		//schickt das Gamestate an alle verbundenen Clients
		

		for (ServerThread thread : serverThreadlist) {
			thread.sendObjectToClient(gamestate);
		}


	}

}
