package KingOfTokyoModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import KingOfTokyo.ClientControllerNewGamePlattform;
import javafx.application.Platform;

public class ClientThread extends Thread {
	
	private Socket clientsocket;
	private ClientModel clientmodel;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private volatile boolean stopThread=false;
	
	private ClientThread clientThread;
	
	public ClientThread(ClientModel clientmodel,Socket clientsocket) throws IOException{
		this.clientThread=clientThread;
		this.clientsocket=clientsocket;
		this.clientmodel=clientmodel;
		this.out=new ObjectOutputStream(clientsocket.getOutputStream());
		this.in=new ObjectInputStream(clientsocket.getInputStream());
		
		
	}
	public void disconnect(){
		try{
			if(clientsocket!=null){
				clientsocket.close();
				stopThread=true;
				this.interrupt();
			}
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		
	public void sendGameStateToServer(GameState gamestate){
		try{
	
		out.writeObject(gamestate);
		
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	public void run(){
		
		try {
			listen();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void listen() throws ClassNotFoundException {
		
		Platform.runLater(new Runnable(){
			@Override
			public void run(){
				GameState gamestate=null;
				
				while(true){
					
					try {
						
						while (true){
							
							gamestate = (GameState) in.readObject();
							clientmodel.setGamestate(gamestate);
							
						}
						
						
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}

			
			
			
		});
	}

	


	
	

}
	
	


