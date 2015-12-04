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
	ClientModel model = new ClientModel();
	private static int client_id = 0;
	ServerController servercontroller = new ServerController();
	ObjectInputStream serverInputStream;
	ObjectOutputStream serverOutputStream;


	Map<Integer, Socket> clients = new HashMap<Integer, Socket>();

	

	public ServerModel(ServerController serverController) {

	}

	public ServerModel() {
		

	}
	public void connectServer(ServerModel serverModel) throws IOException {

		new Thread(new Runnable() {
			@Override
			public void run() {

				// BufferedReader in = new BufferedReader(new
				// InputStreamReader(clientSocket.getInputStream()));
				// PrintWriter out = new
				// PrintWriter(clientSocket.getOutputStream(), true);
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
			new ClientThread(client_id, clientSocket).start();

			System.out.println(client_id + ". Client hinzugefügt");
			clients.put(client_id, clientSocket);

		}

	}

	

}
