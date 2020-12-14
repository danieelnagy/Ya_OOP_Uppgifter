package uppgift5_Daniel_Nagy;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class SceneTwo {

	Button takeMoney, login, insertMoney, show, start;
	Label account, balance, date, lastTransaction;
	HBox hbox = new HBox();
	public HBox getHbox() {
		return hbox;
	}
	public void setHbox(HBox hbox) {
		this.hbox = hbox;
	}
}
