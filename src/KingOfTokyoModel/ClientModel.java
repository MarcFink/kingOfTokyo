package KingOfTokyoModel;

import java.net.Socket;

public class ClientModel {
	Socket socket;

	public boolean connect(String ipAddress, Integer port) {
		boolean success = false;
		try {
			socket = new Socket(ipAddress, port);
			success = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return success;
	}
	
	


}
