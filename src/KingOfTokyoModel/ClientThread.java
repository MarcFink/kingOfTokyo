package KingOfTokyoModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Main.Server;

public class ClientThread extends Thread {
Socket socket;
BufferedReader in;
PrintWriter out;
Server server;
ServerModel servermodel;

public ClientThread(ServerModel servermodel,Socket socket)throws Exception{
	this.socket=socket;
	this.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	this.out=new PrintWriter(socket.getOutputStream(),true);
	this.servermodel=servermodel;
}
	
	
	@Override
	public void run() {
		listen();
	}


	private void listen() {
		String s;
		try{
			while((s=in.readLine())!=null){
				servermodel.broadcast();
				
			}
		}
		catch(Exception e){}
	}

}
