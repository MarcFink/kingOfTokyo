package Main;

import java.io.IOException;

import KingOfTokyo.ServerController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The code for this web server is identical to WebServer_v0, except that we
 * actually send files, rather than just echoing requests. This only involves
 * changes in the Model.
 */
public class Server extends Application {
	
	

//erstellt die ein ServerModel-Objekt und ein ServerController-Objekt. Anschliessend wird die View gestartet.
	
    @Override
    public void start(Stage primaryStage) throws IOException {
    ServerController serverController=new ServerController();
    serverController.startView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}