package KingOfTokyoModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientModel {

	private Socket socket;

	ClientModel clientmodel;
	PrintWriter sOutput;

	public ClientModel() {

	}

	public void startClientConnection(String ipaddress, int port) throws Exception {
		setSocket(new Socket(ipaddress, port));
		System.out.println("Client ist gestartet");

	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

//	public void createTextFile(String player) {
//
//		FileWriter writer;
//		File file;
//		file = new File("c://temp//my_file.txt");

//		try {
//			writer = new FileWriter(file, true);
//		writer.write(Player);
//			writer.close();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

//	}

//	public void newLine() {
//		FileWriter writer;
//		File file;
//		file = new File("C:\\temp\\my_file.txt");
//
//		try {
//			writer = new FileWriter(file, true);
//			writer.write("\r\n");
//			writer.close();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//	}

}