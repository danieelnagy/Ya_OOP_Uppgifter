package uppgift3_Daniel_Nagy;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

class Elements {

	private Button btnStart;
	private Button btnClear;
	private Label timerLabel;
	private Label dateLabel;
	private Label saveLabel;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	private Date date = new Date(System.currentTimeMillis());
	private long elapsedTime = 0;
	private long startTime;
	private AnimationTimer timer;
	private ArrayList<String> results = new ArrayList<String>();
	ComboBox<String> savedTimes;
	EventHandler<ActionEvent> event;

	public Elements() {
		styles();
	}

	public Button getStartButton() {
		return btnStart;
	}

	public Button getClearButton() {
		return btnClear;
	}

	public Label getTimeLabel() {
		return timerLabel;
	}

	public Label getDateLabel() {
		return dateLabel;
	}

	public Label getSaveLabel() {
		return saveLabel;
	}

	public ComboBox<String> getSavedTimes() {
		return savedTimes;
	}

	void styles() {
		results.add("");
		savedTimes = new ComboBox<String>();
		timerLabel = new Label("Timer");
		dateLabel = new Label("Date");
		saveLabel = new Label("Saved times");
		btnStart = new Button("Start/Stop");
		btnClear = new Button("Clear saves");
		savedTimes.setPromptText("All saved times");
		btnStart.setPadding(new Insets(10, 10, 10, 10));
		btnStart.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnClear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnStart.setOnAction((event) -> {
			if (elapsedTime == 0) {
				startTime = System.currentTimeMillis();
				timer = new AnimationTimer() {
					public void handle(long now) {
						elapsedTime = System.currentTimeMillis() - startTime;
						String text = String.format("%3.1f seconds elapsed", elapsedTime / 1000.0);
						timerLabel.setText(text);
					}
				};
				timer.start();
			} else {
				timer.stop();
				long endTime = System.currentTimeMillis();
				double seconds = (endTime - startTime) / 1000.0;
				String time = ("Date: " + formatter.format(date) + "\n"
						+ String.format("Time: %1.3f seconds", seconds));
				dateLabel.setText(time);
				results.add(time);
				savedTimes.getItems().addAll(results.get(results.size() - 1));
				saveLabel.setText("Previous time: " + results.get(results.size() - 2));
				elapsedTime = 0;
			}
		});
		event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				/* results.removeAll(results); arraylistan rensas inte bara comboboxen, men funkar iaf..
				 * proff: foreach for(var i : results) { System.out.println(i); }
				 */
				savedTimes.getItems().clear();
			}
		};
		btnClear.setOnAction(event);
	}
}