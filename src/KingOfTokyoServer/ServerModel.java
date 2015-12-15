package KingOfTokyoServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import KingOfTokyoCommon.GameState;

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
			client_id++;
			clientThread = new ClientThread(client_id, clientSocket, this, gameState);
			clientThreadList.add(clientThread);
			clientThread.start();
			System.out.println(client_id + ". Client hinzugefügt");
			//sendet als erstes die ClientID des ClientThreads zu dem dazugehörigen
			//Client, so weiss jeder Client welcher ClientThread zu ihm gehört
			
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

	public void broadcast(GameState gameState) throws IOException {
		// schickt das Gamestate an alle verbundenen Clients
		
		for (ClientThread k: clientThreadList) {
			k.out.writeObject(gameState);
			System.out.println("Broadcast to clients..");
		}

	}
	
}
