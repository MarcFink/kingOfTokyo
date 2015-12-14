package KingOfTokyoServer;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The code for this web server is identical to WebServer_v0, except that we
 * actually send files, rather than just echoing requests. This only involves
 * changes in the Model.
 */
public class Server extends Application {

	

	@Override
	public void start(Stage primaryStage) throws IOException {
		//Server wird gestartet
		ServerController serverController=new ServerController();
				
	}

	public static void main(String[] args) {
		launch(args);
	}
}