package KingOfTokyoModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Platform;

public class ClientModel extends Thread {

	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private volatile boolean stopThread=false;
	private int playerid;
	ClientModel clientmodel;
	

	public ClientModel() {

	}

	public void startClientConnection(String ipaddress, int port) throws Exception {
		socket=new Socket("localhost", 4444);
		this.out=new ObjectOutputStream(socket.getOutputStream());
		this.in=new ObjectInputStream(socket.getInputStream());
		System.out.println("Client ist gestartet");

		
		this.start();
	}
	
	public void disconnect(){
		try{
			if(socket!=null){
				socket.close();
				stopThread=true;
				this.interrupt();
			}
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		
	public void sendGameStateToServer(GameState gs){
		try{
			
		gs.setPlayerid(getPlayerid());
		out.writeObject(gs);
		
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	public void run(){
		listen();
		
	}
	private void listen() {
		try{
			this.playerid=(int) in.readObject();
			Platform.runLater(new Runnable(){
				@Override
				public void run(){
					
				}
				
				
			};
			
		}catch(IOException e){
			System.out.println(e.getMessage());
			
		}
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}



}