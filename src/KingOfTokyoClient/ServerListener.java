package KingOfTokyoClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import KingOfTokyoCommon.GameState;
import javafx.application.Platform;

public class ServerListener extends Thread {

	private Socket clientsocket;
	private ObjectInputStream in;
	private ClientModel clientmodel;
	

	public ServerListener(ClientModel clientmodel, Socket clientsocket) throws IOException {
		this.clientmodel=clientmodel;
		this.clientsocket = clientsocket;
		this.in = new ObjectInputStream(clientsocket.getInputStream());
		
	}

	public void run() {
		listen();
	}

	public void listen() {
		
		Object gamestate;
		try {
			// sobald object im inputstream -> read
			while (true) {
				// Thread läuft die ganze Zeit und liest ob ein Object geschickt
				// wurde
				gamestate = (GameState) in.readObject();
				System.out.println("Empfangen Objekt");
				clientmodel.setGamestate((GameState) gamestate);
				//von server erhaltene gamestate wird hier gesetzt
				
//				setGamestate(gamestate);
				//System.out.println("Recieved Game State from server: " + gamestate.toString());
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void close() {
		try {
			this.interrupt();
			clientsocket.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
