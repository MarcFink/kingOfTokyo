package KingOfTokyoModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {

	Socket clientSocket;
	private int id;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private ServerModel servermodel;

	public ClientThread(int id, Socket clientSocket, ServerModel servermodel) throws IOException {
		this.servermodel = servermodel;
		this.clientSocket = clientSocket;
		this.id = id;
		this.in = new ObjectInputStream(clientSocket.getInputStream());
		this.out = new ObjectOutputStream(clientSocket.getOutputStream());
	}

	public void run() {
		try {
			listen();
			System.out.println("Client gestartet ");

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
		GameState gs;
		Object o;

		try {

			while ((o = in.readObject()) != null) {

				gs = (GameState) o;
				servermodel.objectfromclientSetGameState(gs);
				servermodel.broadcast(gs);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void sendObjektToClient(GameState gs) {
		try {

			int a = gs.getPlayerlist().size();
			System.out.println(a);
			this.out.writeObject(gs);
			out.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void sendIDToClioent(int clientID) {
		try {
			this.out.writeObject(clientID);
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
