package KingOfTokyoServer;

import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music extends Thread {
	/* 
	 * @author Mäder David
	 */
	MediaPlayer mediaPlayer;
	Media media;

	public void playSound() {
		//Musik File wird eingelesen
		URL resource = getClass().getResource("lotr.mp3");
		media = new Media(resource.toString());
		mediaPlayer = new MediaPlayer(media);
		//Musik wird abgespielt
		mediaPlayer.play();

	}

	public void run() {
		playSound();
	}
}