package KingOfTokyoClient;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class factsView extends Application {

	private Stage factsStage;
	private Scene scene;

	@Override
	public void start(Stage factsStage) throws Exception {
		factsStage.setTitle("Facts");

		BorderPane root = new BorderPane();
		
		// TODO Auto-generated method stub
		TabPane tabpane = new TabPane();
		tabpane.setPrefHeight(200);
		tabpane.setPrefWidth(200);
		root.setCenter(tabpane);
		root.setPrefHeight(500);
		root.setPrefWidth(900);

		Tab tabAboutUs = new Tab("Über uns");
		BorderPane borderAbout = new BorderPane();
		borderAbout.setPrefHeight(200);
		borderAbout.setPrefWidth(200);
		Text txtTitleAbout = new Text();
		txtTitleAbout.setText("Informatikprojekt 2015 - King of Tokyo ");
		txtTitleAbout.setFont(Font.font ("Verdana", 20));
		
		
		Text txtAbout = new Text();
		txtAbout.setText(
				"In diesem Projekt geht es um die Umsetzung des Brettspiels King of Tokyo in ein Computerspiel. \nWir sind drei Wirtschaftsinformatikstudenten an der Fachhochschule Nordwestschweiz.\nDie Basisanforderungen wurden von den Dozenten festgelegt. \nDa wir einen engen Zeitplan haben, konnte nicht das ganze Brettspiel umgesetzt werden. \nAusserdem hat man uns einen kreativen Freiraum zur Verfügung gestellt,\nwo wir selber Regeln erstellen und so dem Spiel einen eigenen Stempel aufdrücken können. \nDas Programm ist in Java geschrieben und als Entwicklungsumgebung wurde Eclipse verwendet. \nUm eine reibungslose Zusammenarbeit zu gewährleisten wurde mit der Versionskontrolle Git gearbeitet.");
		tabAboutUs.setContent(borderAbout);
		borderAbout.setTop(txtTitleAbout);
		borderAbout.setCenter(txtAbout);
		borderAbout.setAlignment(txtTitleAbout, Pos.CENTER);

		Tab tabRobin = new Tab("Robin Attinkara");
		GridPane gridRobin = new GridPane();
		
		Text txtRobin = new Text();
		txtRobin.setText(
				"Robin Attinkara \nWirtschaftsinformatikstudent \nE-Mail: robin.attinkara@students.fhnw.ch \nTelNr: +41 76 307 78 33");
		ImageView imgviewRobin = new ImageView();
		Image imgRobin = new Image("./Images/robin.png");
		imgviewRobin.setImage(imgRobin);
		imgviewRobin.setFitHeight(380);
		imgviewRobin.setFitWidth(380);

		tabRobin.setContent(gridRobin);
		gridRobin.add(txtRobin,1,1);
		gridRobin.add(imgviewRobin,0,1);

		Tab tabMarc = new Tab("Marc Fink");
		GridPane gridMarc = new GridPane();
		Text txtMarc = new Text();
		txtMarc.setText(
				"Marc Fink \nWirtschaftsinformatikstudent \nE-Mail: marc.fink1@students.fhnw.ch \nTelNr: +41 79 826 29 39");
		ImageView imgviewMarc = new ImageView();
		Image imgMarc = new Image("./Images/marc.png");
		imgviewMarc.setImage(imgMarc);
		imgviewMarc.setFitHeight(380);
		imgviewMarc.setFitWidth(380);
		tabMarc.setContent(gridMarc);
		gridMarc.add(txtMarc,1,1);
		gridMarc.add(imgviewMarc,0,1);

		Tab tabDavid = new Tab("David Mäder");
		GridPane gridDavid = new GridPane();
		Text txtDavid = new Text();
		txtDavid.setText(
				"David Mäder \nWirtschaftsinformatikstudent \nE-Mail: david.maeder@students.fhnw.ch \nTelNr: +41 78 713 93 44");
		ImageView imgviewDavid = new ImageView();
		Image imgDavid = new Image("./Images/david.png");
		imgviewDavid.setImage(imgDavid);
		imgviewDavid.setFitHeight(380);
		imgviewDavid.setFitWidth(300);
		tabDavid.setContent(gridDavid);
		gridDavid.add(txtDavid,1,1);
		gridDavid.add(imgviewDavid,0,1);

		tabpane.getTabs().addAll(tabAboutUs, tabRobin, tabMarc, tabDavid);
		scene = new Scene(root);
		factsStage.setScene(scene);
		factsStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
