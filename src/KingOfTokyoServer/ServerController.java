package KingOfTokyoServer;

import java.io.IOException;

public class ServerController {
	private int prt=4444;

	private ServerController serverController;

	

	public ServerController() throws IOException {
		ServerModel serverModel = new ServerModel(serverController,prt);
	//ruft die Methode auf in der Klasse ServerModel
		serverModel.start();
		
	
		

	}
}

