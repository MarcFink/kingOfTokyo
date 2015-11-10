package Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import KingOfTokyo.ServerController;
import KingOfTokyoModel.ServerModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The code for this web server is identical to WebServer_v0, except that we
 * actually send files, rather than just echoing requests. This only involves
 * changes in the Model.
 */
public class Server extends Application {
	
	


    @Override
    public void start(Stage primaryStage) {
    ServerModel serverModel=new ServerModel();
    ServerController serverController=new ServerController();
    serverController.startView();
    ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}