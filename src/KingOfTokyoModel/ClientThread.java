package KingOfTokyoModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import KingOfTokyo.ServerController;

public class ClientThread extends Thread {

	Socket clientSocket;
	private int id;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private ServerModel servermodel;
	private GameState gamestate;

	public ClientThread(int id, Socket clientSocket, ServerModel servermodel,GameState gamestate) throws IOException {
		//Thread wird instanziert. Input- und Outputstreams werden erstellt
		this.gamestate=gamestate;
		this.servermodel = servermodel;
		this.clientSocket = clientSocket;
		this.in = new ObjectInputStream(clientSocket.getInputStream());
		this.out = new ObjectOutputStream(clientSocket.getOutputStream());
		// Das erste mal wird das Gamestate nur an den einen Client gesendet solange noch keine weiteren verbunden sind.
		sendObjectToClient(gamestate);
	}

	public void run() {
		
			try {
				listen();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
				//Thread läuft die ganze Zeit und liest ob ein Object geschickt wurde
				gamestate = (GameState) in.readObject();
				//Das eingelesene Objekt wird gleich an alle verbundenn Clients geschickt.
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
