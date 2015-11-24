package KingOfTokyoModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
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

	ArrayList<Socket> connections;

	public ServerModel(ServerController serverController) {

	}

	public ServerModel() {
		this.connections = new ArrayList<Socket>();

	}

	// ExecutorService executor=Executors.newFixedThreadPool(2);
	final Task<Void> servertask = new Task<Void>() {
		@Override
		protected Void call() throws Exception {

			try {
				serverSocket = new ServerSocket(port);
				System.out.println(port + " " + "Server ist gestartet");
				while (true) {

					clientSocket = serverSocket.accept();

					// executor.execute(new
					// ClientHandler(model,clientSocket));
					ClientThread client = new ClientThread(model, clientSocket);
					client.start();

				}
			} catch (Exception e) {

			}
			return null;
		}
	};

	public void serveContent(Integer port) {
		this.port = port;
		new Thread(servertask).start();
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	

}
