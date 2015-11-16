package KingOfTokyoModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

import Main.Client;

public class ClientThread extends Thread {

	Socket clientSocket;
	
	ClientModel clientmodel;

	public ClientThread(ClientModel clientmodel, Socket clientSocket) throws IOException {
		this.clientSocket = clientSocket;
		this.clientmodel = clientmodel;
		
	}

	/**
	 * Process messages until the client says "Goodbye"
	 */

	public void run() {
		System.out.println("Client gestartet"+clientSocket.getInetAddress().getHostName());

	}

}
