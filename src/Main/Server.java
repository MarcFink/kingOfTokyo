package Main;

import java.io.IOException;

import KingOfTokyo.ServerController;
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
	public void start(Stage primaryStage) throws IOException {
		//Server wird gestartet und GUI wird geladen
		Stage menuStage=new Stage();
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../KingOfTokyoView/Server.fxml"));
		Scene scene = new Scene(root);
		menuStage.setScene(scene);
		menuStage.setTitle("King of Tokyo");
		menuStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}