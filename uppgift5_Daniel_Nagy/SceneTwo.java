package uppgift5_Daniel_Nagy;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import uppgift4_Daniel_Nagy.Person;

class SceneTwo {

	static ArrayList<Konto> list = new ArrayList<>();
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	private Date dateNow = new Date(System.currentTimeMillis());
	private String time;
	private int amountInsertMoney = 0;
	private Functions functions;
	private Button btnInsert, btnDone, btnAccCreate;
	private Label account, balanceLabel, pin, money, balanceShow;
	private GridPane grid;
	private HBox hbox;
	private TextField name, pinText, moneyText;
	private VBox vbox;
	private Konto konto;

	public SceneTwo() {
		Styles();
	}

	void Styles() {
		vbox = new VBox();
		functions = new Functions();

		/* Labels */
		account = new Label("Account owner: ");
		balanceLabel = new Label("Balance: ");
		balanceShow = new Label();
		pin = new Label("PIN(format: xxxx): ");
		money = new Label("Money to insert: ");

		/* TextField */
		name = new TextField("");
		name.setPromptText("Type your name here");
		pinText = new TextField();
		pinText.setPromptText("Type pin here, format: XXXX");
		moneyText = new TextField();
		moneyText.setPromptText("Type the amount of money");

		/* Buttons */

		btnInsert = new Button("Insert money");
		btnInsert = functions.ButtonStyle(btnInsert);

		btnAccCreate = new Button("Create Account");
		btnAccCreate = functions.ButtonStyle(btnAccCreate);

		btnDone = new Button("Done");
		btnDone = functions.ButtonStyle(btnDone);

		/* HBOX */
		hbox = new HBox();
		hbox.getChildren().addAll(btnAccCreate, btnInsert, btnDone);
		// hbox.setPrefSize(100, 160);

		/* Grid */
		grid = new GridPane();
		grid = functions.GridStyleSceneTwo(grid);

		grid.add(account, 0, 0);
		grid.add(name, 0, 0);
		GridPane.setHalignment(name, HPos.RIGHT);
		name.setMaxSize(250, 30);

		grid.add(pin, 0, 1);
		grid.add(pinText, 0, 1);
		GridPane.setHalignment(pinText, HPos.RIGHT);
		pinText.setMaxSize(250, 30);

		grid.add(balanceLabel, 0, 2);
		grid.add(balanceShow, 0, 2);
		GridPane.setHalignment(balanceShow, HPos.CENTER);

		grid.add(money, 0, 3);
		grid.add(moneyText, 0, 3);
		GridPane.setHalignment(moneyText, HPos.RIGHT);
		moneyText.setMaxSize(250, 30);

		/* Vbox */

		vbox.setPrefSize(640, 480);
		vbox.getChildren().addAll(grid, hbox);

		/* Events */
		btnInsert.setOnAction((event) -> {
			amountInsertMoney = amountInsertMoney + Integer.parseInt(moneyText.getText());
			balanceShow.setText(String.valueOf(amountInsertMoney) + " kr");
		});

		btnAccCreate.setOnAction((event) -> {

			if (name.getText().equals("") || pinText.getText().equals("")) {
				;
			} else {
				time = getDate(time);
				konto = new Konto(name.getText(), time , pinText.getText(), amountInsertMoney);
				list.add(konto);
			}
		});
		
	}
	

	String getDate(String time) {
		time = (formatter.format(dateNow));
		return time;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

	public Button getBtnDone() {
		return btnDone;
	}

	public void setBtnDone(Button btnDone) {
		this.btnDone = btnDone;
	}

	public Button getBtnInsert() {
		return btnInsert;
	}
}
