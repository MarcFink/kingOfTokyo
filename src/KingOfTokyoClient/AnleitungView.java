package KingOfTokyoClient;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

	

public class AnleitungView {
	/* 
	 * @author Mäder David
	 * */
	
	private BorderPane root;
	private Scene scene;
	
	public AnleitungView(){
		root = new BorderPane();	
		initView();
		setScene(new Scene(root));

	
	}
	
	

public void initView(){
	
		
		GridPane grid=new GridPane();
		
		root.setPrefHeight(1000);
		root.setPrefWidth(1900);
	
		ScrollPane scrollpane=new ScrollPane();
		scrollpane.setPrefHeight(1000);
		scrollpane.setPrefWidth(1900);
		scrollpane.setContent(grid);
		
		root.setCenter(scrollpane);
		
		
		ImageView imgViewAnleitung1 = new ImageView();
		Image imgAnleitung1 = new Image("./Images/anleitung1.png");
		imgViewAnleitung1.setImage(imgAnleitung1);
		imgViewAnleitung1.setFitHeight(900);
		imgViewAnleitung1.setFitWidth(900);
		
		
		ImageView imgViewAnleitung2 = new ImageView();
		Image imgAnleitung2 = new Image("./Images/anleitung2.png");
		imgViewAnleitung2.setImage(imgAnleitung2);
		imgViewAnleitung2.setFitHeight(900);
		imgViewAnleitung2.setFitWidth(900);
		
		ImageView imgViewAnleitung3 = new ImageView();
		Image imgAnleitung3 = new Image("./Images/anleitung3.png");
		imgViewAnleitung3.setImage(imgAnleitung3);
		imgViewAnleitung3.setFitHeight(900);
		imgViewAnleitung3.setFitWidth(900);
		
		ImageView imgViewAnleitung4 = new ImageView();
		Image imgAnleitung4 = new Image("./Images/anleitung4.png");
		imgViewAnleitung4.setImage(imgAnleitung4);
		imgViewAnleitung4.setFitHeight(900);
		imgViewAnleitung4.setFitWidth(900);
		
		grid.add(imgViewAnleitung1,0,0);
		grid.add(imgViewAnleitung2,1,0);
		grid.add(imgViewAnleitung3,0,1);
		grid.add(imgViewAnleitung4,1,1);
		
		
	}



public Scene getScene() {
	return scene;
}



public void setScene(Scene scene) {
	this.scene = scene;
}
}
