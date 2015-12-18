package KingOfTokyoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import KingOfTokyoCommon.GameState;
import javafx.application.Platform;

public class ClientThread extends Thread {
	/* 
	 * @author Mäder David
	 */

	Socket clientSocket;
	ObjectInputStream in;
	ObjectOutputStream out;
	private ServerModel servermodel;
	private GameState gameState;
	private int id;

	public ClientThread(int id, Socket clientSocket, ServerModel servermodel, GameState gameState) throws IOException {
		// Thread wird instanziert. Input- und Outputstreams werden erstellt
		this.servermodel = servermodel;
		this.clientSocket = clientSocket;
		this.id=id;
		this.gameState=gameState;
	
		this.out = new ObjectOutputStream(clientSocket.getOutputStream());
		this.in = new ObjectInputStream(clientSocket.getInputStream());

		// Das erste mal wird das Gamestate nur an den einen Client gesendet
		// solange noch keine weiteren verbunden sind.

	}

	public void run() {
	
		//clientid wird einmal an den Client geschickt
		sendIDToClient(id);
		
		//GameState Objekt wird einmal zum Client gesendet
		sendObjectToClient(this.gameState);

		try {
			listen();
		} catch (Exception e) {
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
			while ((e = in.readObject()) != null) {
				// Thread läuft die ganze Zeit und liest ob ein Object geschickt
				// wurde
				// Das eingelesene Objekt wird gleich an alle verbundenn Clients
				// geschickt.
				gameState=(GameState) e;
				GameState.setInstance(gameState);
				System.out.println("Server " + GameState.getInstance().toString());
				servermodel.broadcast(GameState.getInstance());
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Objekt GameState wird verschickt

	public void sendObjectToClient(GameState gameState) {
		try {
			out.writeObject(this.gameState);
			System.out.println("Objekt gamestate wurde verschickt");
			out.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// Interger Wert wird verschickt
	public void sendIDToClient(int client_id) {
			try {
				out.writeInt(client_id);
				System.out.println("ID wurde verschickt");
				out.flush();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

	}

		}
