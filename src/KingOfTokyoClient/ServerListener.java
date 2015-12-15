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
		
		{
		
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
	}
	



	
	public void listen() throws ClassNotFoundException, IOException {
		Integer clientID=in.readInt();
		clientmodel.setClientID(clientID);
		System.out.println("Objekt wurde empfangen");
		
		
		
			Object a;
		try {
			// sobald object im inputstream -> read
			while ((a=in.readObject())!=null) {
				
				
				GameState gs = (GameState)a;
				System.out.println(gs.toString());
				
				clientmodel.setGamestate((GameState)a);
				System.out.println(a.toString());
				
				//von server erhaltene gamestate wird hier ins ClientModel gesetzt
				//clientmodel.setGamestate.set((GameState)a);
				
				
				
			
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
