package KingOfTokyoModel;

import java.net.Socket;

public class ClientModel {

	private Socket socket;
	private ServerListener serverListener;

	public ClientModel() {

	}

	public Socket startClientConnection(String ipaddress, int port) throws Exception {
		socket = new Socket("localhost", 4444);
		System.out.println("Client ist gestartet");
		//neuer serverlistener erzeugt und dem Clientmodel zugeordnet
		serverListener = new ServerListener(this, socket);
		serverListener.start();
		return socket;
	}

	public ServerListener getServerListener() {
		return serverListener;
	}

	public void setServerListener(ServerListener serverListener) {
		this.serverListener = serverListener;
	}

}