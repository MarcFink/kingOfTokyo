package KingOfTokyoModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import KingOfTokyo.ServerController;

public class ServerThread extends Thread {

	Socket clientSocket;
	private int id;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private ServerModel servermodel;
	private GameState gamestate;

	public ServerThread(int id, Socket clientSocket, ServerModel servermodel,GameState gamestate) throws IOException {
		//Thread wird instanziert. Input- und Outputstreams werden erstellt
		this.gamestate=gamestate;
		this.servermodel = servermodel;
		this.clientSocket = clientSocket;
		this.in = new ObjectInputStream(clientSocket.getInputStream());
		this.out = new ObjectOutputStream(clientSocket.getOutputStream());
		//servermodel.broadcast(gamestate);
		sendObjectToClient(gamestate);
	}

	public void run() {
		try {
			listen();
			

		} catch (IOException | ClassNotFoundException e) {
		}

	}

	public void close() {
		try {
			this.interrupt();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listen() throws IOException, ClassNotFoundException {
		
	

		try {

			while (true) {
				gamestate = (GameState) in.readObject();
				servermodel.broadcast(gamestate);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
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



	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}
}
