package KingOfTokyoModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
	
	Socket clientSocket;
	private BufferedReader in;
	private PrintWriter out;
	private int id;

	public ClientThread(int id, Socket clientSocket) throws IOException {
		this.clientSocket = clientSocket;
		this.id = id;
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out = new PrintWriter(clientSocket.getOutputStream());
	}

	public void run() {
		try {
			listen();
			
			System.out.println("Client gestartet ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listen() throws IOException {

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
	}

}
