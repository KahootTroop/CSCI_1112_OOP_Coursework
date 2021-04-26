import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.application.Platform;
public class Exercise16_21 extends Application {
	TextField seconds = new TextField();
	int countDown = 0;
	public TextField getText() {
		seconds.setEditable(true);
		seconds.setStyle("-fx-text-fill: red");
		seconds.setFont(Font.font("Times", 100)); 
		seconds.setAlignment(Pos.CENTER);
		return seconds;
	}
	public int task(int counter) {
		return counter - 1;
	}
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(getText(), 750, 600);
		Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		Timer timer = new Timer(true);
		class Task extends TimerTask {
			public void run() {
				if(countDown >= 0) {
					Platform.runLater(new Runnable() {
						public void run() {
							seconds.clear();
							seconds.setText(String.valueOf(countDown));
							countDown = countDown - 1;
						}
					});
				}
				else {
					seconds.clear();
					seconds.setText("Times up");
					mediaPlayer.play();
					timer.cancel();
				}
			}
		}
		seconds.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.ENTER) {
				countDown = Integer.parseInt(seconds.getText());
				timer.scheduleAtFixedRate(new Task(), 0, 1*1000);
			}
		});
		primaryStage.setTitle("StopWatch");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
