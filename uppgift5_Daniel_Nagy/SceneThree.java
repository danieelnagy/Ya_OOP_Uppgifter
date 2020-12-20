package uppgift5_Daniel_Nagy;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import uppgift4_Daniel_Nagy.Person;

class SceneThree {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	private Date dateNow = new Date(System.currentTimeMillis());
	private String time;
	private String userName = "";
	private String user;
	private int balance;
	private int amountInsertMoney = 0;
	private Functions functions;
	private Button btnInsert, btnTakeOut, btnKvitto;
	private Label account, balanceLabel, takeOut, money, balanceShow;
	private GridPane grid;
	private HBox hbox;
	private TextField takeOutText, moneyText;
	private VBox vbox;

	public SceneThree() {
		Styles();
	}

	void Styles() {
		ListView<String> angryMe = new ListView<String>();
		vbox = new VBox();
		functions = new Functions();

		/* Labels */
		account = new Label(user);
		balanceLabel = new Label("Balance: ");
		balanceShow = new Label();
		takeOut = new Label("Take money out");
		money = new Label("Money to insert: ");

		/* TextField */
		takeOutText = new TextField();
		takeOutText.setPromptText("Type the amount of money here");
		moneyText = new TextField();
		moneyText.setPromptText("Type the amount of money");

		/* Buttons */

		btnInsert = new Button("Insert money");
		btnInsert = functions.ButtonStyle(btnInsert);

		btnTakeOut = new Button("Take out money");
		btnTakeOut = functions.ButtonStyle(btnTakeOut);

		btnKvitto = new Button("Kvitto");
		btnKvitto = functions.ButtonStyle(btnKvitto);

		/* HBOX */
		hbox = new HBox();
		hbox.getChildren().addAll(btnInsert, btnTakeOut, btnKvitto);
		// hbox.setPrefSize(100, 160);

		/* Grid */
		grid = new GridPane();
		grid = functions.GridStyleSceneTwo(grid);

		grid.add(account, 0, 0);
		GridPane.setHalignment(account, HPos.CENTER);
		account.setMaxSize(300, 50);

		grid.add(balanceLabel, 0, 1);
		grid.add(balanceShow, 0, 1);
		balanceShow.setText(String.valueOf(balance) + " kr");
		GridPane.setHalignment(balanceShow, HPos.CENTER);

		grid.add(takeOut, 0, 2);
		grid.add(takeOutText, 0, 2);
		GridPane.setHalignment(takeOutText, HPos.RIGHT);
		takeOutText.setMaxSize(250, 30);

		grid.add(money, 0, 3);
		grid.add(moneyText, 0, 3);
		GridPane.setHalignment(moneyText, HPos.RIGHT);
		moneyText.setMaxSize(250, 30);

		/* Vbox */

		vbox.setPrefSize(640, 480);
		vbox.getChildren().addAll(grid, hbox, angryMe);

		/* Events */

		btnTakeOut.setOnAction((event) -> {
			amountInsertMoney = amountInsertMoney - Integer.parseInt(takeOutText.getText());
			balanceShow.setText(String.valueOf(amountInsertMoney) + " kr");
			time = getDate(time);
			angryMe.getItems().add(time + " took out this much cash: " + Integer.parseInt(takeOutText.getText()) + " kr");
		});

		btnInsert.setOnAction((event) -> {
			amountInsertMoney = amountInsertMoney + Integer.parseInt(moneyText.getText());
			balanceShow.setText(String.valueOf(amountInsertMoney) + " kr");
			time = getDate(time + "");
			angryMe.getItems().add(time + " inserted this much money: " + Integer.parseInt(moneyText.getText()) + " kr");
		});
	}

	String returnName(String s) {
		return s;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

	public Button getBtnKvitto() {
		return btnKvitto;
	}

	public void setBtnKvitto(Button btnKvitto) {
		this.btnKvitto = btnKvitto;
	}

	String getDate(String time) {
		time = (formatter.format(dateNow));
		return time;
	}
}
