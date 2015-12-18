package KingOfTokyoServer;

import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music extends Thread {
	MediaPlayer mediaPlayer;
	Media media;

	public void playSound() {
		URL resource = getClass().getResource("lotr.mp3");
		media = new Media(resource.toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();

	}

	public void run() {
		playSound();
	}
}