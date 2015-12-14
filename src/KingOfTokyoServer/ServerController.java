package KingOfTokyoServer;

import java.io.IOException;

public class ServerController {
	private int prt=4444;

	private ServerController serverController;

	
	//ServerController ist mit der FXML Datei Menu verknüpft .
	public ServerController() throws IOException {
		ServerModel serverModel = new ServerModel(serverController,prt);
		serverModel.start();
		
	
		

	}
}

