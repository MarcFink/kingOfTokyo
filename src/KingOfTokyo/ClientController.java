package KingOfTokyo;

import KingOfTokyoModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClientController {
	private ClientModel model;
	
	public ClientController(){
	this.model=new ClientModel();
	}

	@FXML TextField ipadresse;
	@FXML TextField prt;

	@FXML public void connectClient(ActionEvent event){
		String stringipadresse=ipadresse.getText();
		String stringprt=prt.getText();
		model.getIp(stringipadresse);
		model.getPort(stringprt);
		   String ip = ipadresse.getText();
           Integer port = new Integer(prt.getText());
           System.out.println(ip+" "+port);
           System.out.println(model.connect(ip, port));
           if (model.connect(ip, port)==true) {
               System.out.println("success");
           } else {
              System.out.println("fail");
           }
	
		
			
	
		

	}
	

	


}
