package KingOfTokyoModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.application.Platform;

public class ServerListener extends Thread {

	private Socket clientsocket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private GameState gamestate=null;

	public ServerListener(ClientModel clientmodel, Socket clientsocket) throws IOException {
		this.clientsocket = clientsocket;
		this.out = new ObjectOutputStream(clientsocket.getOutputStream());
		this.in = new ObjectInputStream(clientsocket.getInputStream());
	}
	public void run(){
		listen();
	}
	
	public void listen(){
		
		try {
			while (true) {
				//Thread läuft die ganze Zeit und liest ob ein Object geschickt wurde
				gamestate = (GameState) in.readObject();
				setGamestate(gamestate);
				
				//Das eingelesene Objekt wird gleich an alle verbundenn Clients geschickt.
				
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

	public void sendToServer(GameState gamestate) {
		try {

			
			this.out.writeObject(gamestate);
			out.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}


	public GameState getGamestate() {
		return gamestate;
	}


	public void setGamestate(GameState gamestate) {
		this.gamestate = gamestate;
	}

}

