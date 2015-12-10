package KingOfTokyo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import KingOfTokyoModel.ClientModel;
import KingOfTokyoModel.Dice;
import KingOfTokyoModel.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;

public class ClientView {

	private Stage kingOfTokyoStage;
	private FXMLLoader loader;
	private Scene scene;

	public ClientView(Stage kingOfTokyoStage) throws IOException {
		//MenuScene wird geladen
		this.kingOfTokyoStage = kingOfTokyoStage;
		loader = new FXMLLoader(getClass().getResource("../KingOfTokyoView/Menu.fxml"));
		AnchorPane root = new AnchorPane();
		root = loader.load();
		scene = new Scene(root);
		kingOfTokyoStage.setScene(scene);
		kingOfTokyoStage.show();

	}
}

