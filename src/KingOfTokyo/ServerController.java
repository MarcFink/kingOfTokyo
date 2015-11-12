package KingOfTokyo;

import java.io.IOException;

import KingOfTokyoModel.ServerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerController {
	private int prt;
	private Stage menuStage;
	private ServerController serverController;
	
	public ServerController(){
	
		

		
		
		}
	public void startView() throws IOException {
			menuStage=new Stage();
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Server.fxml"));
			Scene scene = new Scene(root);
			menuStage.setScene(scene);
			menuStage.setTitle("King of Tokyo");
			menuStage.show();
	}

	@FXML TextField port;
	
	@FXML public void connecting(ActionEvent event) throws Exception{
		prt=Integer.parseInt(port.getText());
		ServerModel serverModel=new ServerModel(serverController);
		serverModel.startServerConnection(prt);
		
		}

	public int getPortNr(){
		return prt;
	}

	@FXML public void cancel(ActionEvent event){
		System.exit(0);
	}
}


		
		
	
	
	
	


