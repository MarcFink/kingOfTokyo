package KingOfTokyoModel;

import java.net.Socket;

import KingOfTokyo.ClientController;
import javafx.scene.control.TextField;

public class ClientModel {
	private String ipa;
	private Integer port;

	public void getIp(String ipadresse) {
		ipa = ipadresse;

	}

	public void getPort(String prt) {
		port = Integer.parseInt(prt);

	}

	Socket socket;

	public boolean connect(String ipa, Integer port) {
		boolean success = false;
		try {
			socket = new Socket(ipa, port);
			success = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return success;
	}

}
