package KingOfTokyoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import KingOfTokyoCommon.GameState;

public class ClientThread extends Thread {

	Socket clientSocket;
	private int id;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private ServerModel servermodel;
	private GameState gameState;

	public ClientThread(int id, Socket clientSocket, ServerModel servermodel,GameState gameState) throws IOException {
		//Thread wird instanziert. Input- und Outputstreams werden erstellt
		this.gameState=gameState;
		this.servermodel = servermodel;
		this.clientSocket = clientSocket;
		this.in = new ObjectInputStream(clientSocket.getInputStream());
		
		
		// Das erste mal wird das Gamestate nur an den einen Client gesendet solange noch keine weiteren verbunden sind.
	
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
			Object e;
			while ((e=in.readObject()) !=null) {
				//Thread läuft die ganze Zeit und liest ob ein Object geschickt wurde
				gameState = (GameState) e;
				//Das eingelesene Objekt wird gleich an alle verbundenn Clients geschickt.
				servermodel.broadcast(gameState);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}




