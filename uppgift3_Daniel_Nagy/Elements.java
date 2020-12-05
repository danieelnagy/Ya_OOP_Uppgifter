package uppgift3_Daniel_Nagy;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

class Elements {

	Button btnStart;
	Button btnStop;
	Label timerLabel;
	Label dateLabel;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	Date date = new Date(System.currentTimeMillis());
	private long startTime; // Start time of timer.
	// (Time is measured in milliseconds.)

	private boolean running; // True when the timer is running.

	private AnimationTimer timer; // Used to update the timer to show
	// the number of seconds that have passed.

	public Elements() {
		styles();
	}

	public Button getStartButton() {
		return btnStart;
	}

	public Button getStopButton() {
		return btnStop;
	}

	public Label getTimeLabel() {
		return timerLabel;
	}

	public Label getDateLabel() {
		return dateLabel;
	}

	void styles() {
		timerLabel = new Label("Timer");
		dateLabel = new Label("Date");
		btnStart = new Button("Start");
		btnStart.setPadding(new Insets(10, 10, 10, 10));
		btnStop = new Button("Stop");
		btnStop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnStop.setPadding(new Insets(10, 10, 10, 10));
		btnStart.setOnAction((event) -> {
			startTime = System.currentTimeMillis();
			timer = new AnimationTimer() {
				public void handle(long now) {
					long elapsedTime = System.currentTimeMillis() - startTime;
					String text = String.format("%3.1f seconds elapsed", elapsedTime / 1000.0);
					timerLabel.setText(text);
				}
			};
			timer.start();

		});
		btnStop.setOnAction((event) -> {
			timer.stop();
            long endTime = System.currentTimeMillis();
            double seconds = (endTime - startTime) / 1000.0;
			dateLabel.setText("Date: " + formatter.format(date) + "\n"+ String.format("Time: %1.3f seconds", seconds));
		});
	}
}
