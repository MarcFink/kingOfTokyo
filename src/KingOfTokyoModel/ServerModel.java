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
	ClientModel model = new ClientModel();
	private static int client_id = 0;
	ServerController servercontroller = new ServerController();
	ObjectInputStream serverInputStream;
	ObjectOutputStream serverOutputStream;
	private ServerModel servermodel;
	private ClientThread clientThread;

	ArrayList<ClientThread> clients = new ArrayList< ClientThread>();

	

	public ServerModel(ServerController serverController) {

	}

	public ServerModel() {
		this.servermodel=servermodel;
		
		

	}
	public void connectServer(ServerModel serverModel) throws IOException {
		
		this.gamestate=GameState.getGameState();
		
		new Thread(new Runnable() {
			@Override
			public void run() {

			
				try {

					serverSocket = new ServerSocket(4444);
					System.out.println("4444 Server ist gestartet");
					serverModel.connectClient();
					serverInputStream = new ObjectInputStream(clientSocket.getInputStream());
					serverOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
					
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

		while (true) {
			// try{
			

			clientSocket = serverSocket.accept();
			

			client_id++;
			clientThread=new ClientThread(client_id, clientSocket,servermodel);
			clientThread.start();
			
			System.out.println(client_id + ". Client hinzugefügt");
			this.gamestate.addPlayer(client_id);
			clients.add(clientThread);

		}
	
	}

	public void objectfromclientSetGameState(GameState gs) {
		this.gamestate=gs;
		
		GameState.setGameState(gs);
		
		
		
	}

	public void broadcast(GameState gs) {
		
		for(ClientThread client: clients){
			
		}
		
		
	}

		
	}

	


