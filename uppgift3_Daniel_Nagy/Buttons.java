package uppgift3_Daniel_Nagy;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

class Buttons {

	private Button btnStartStop;

	public Buttons() {
		ButtonStyles();
	}

	public Button getButton() {
		return btnStartStop;
	}

	public void setName(Button btnStartStop) {
		this.btnStartStop = btnStartStop;
	}

	void ButtonStyles() {
		btnStartStop = new Button("Start/Stop");

	}

}
