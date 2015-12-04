package KingOfTokyoView;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ClientView {
	private FXMLLoader loader;
	private Scene menuScene;
	private Scene newGamePlattformscene;
	private AnchorPane ap;
	private BorderPane bp;

 
	public ClientView() throws IOException{
		loader=new FXMLLoader(getClass().getResource("../KingOfTokyoView/Menu.fxml"));
		loader=new FXMLLoader(getClass().getResource("../KingOfTokyoView/NewGamePlattform.fxml"));
		ap=loader.load();
		bp=loader.load();
		
		Scene menuScene=new Scene(ap);
		Scene newGamePlattformscene=new Scene(bp);
		
	}


	public Scene getMenuScene() {
		return menuScene;
	}


	public void setMenuScene(Scene menuScene) {
		this.menuScene = menuScene;
	}


	public Scene getNewGamePlattformscene() {
		return newGamePlattformscene;
	}


	public void setNewGamePlattformscene(Scene newGamePlattformscene) {
		this.newGamePlattformscene = newGamePlattformscene;
	}
	
		
		
		
		
		
		
		
	}
