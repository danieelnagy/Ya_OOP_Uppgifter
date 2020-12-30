package uppgift5_Daniel_Nagy;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

class BankPage {

	Serialization seri;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	private Date dateNow = new Date(System.currentTimeMillis());
	private String time;
	FlowPane flow;
	private String userName;
    int balance;
	private int amountInsertMoney = 0;
	private Functions functions;
	private Button btnInsert, btnTakeOut, btnKvitto, btnSerialize;
	private Label account, balanceLabel, takeOut, money, balanceShow;
	private GridPane grid;
	private HBox hbox;
	private TextField takeOutText, moneyText;
	private VBox vbox;

	public BankPage() {
		Styles();
	}

	void Styles() {
		seri = new Serialization();
		ListView<String> angryMe = new ListView<String>();
		vbox = new VBox();
		functions = new Functions();

		/* Labels */
		account = new Label(userName);
		balanceLabel = new Label("Balance: ");
		balanceShow = new Label(String.valueOf(balance));
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
		
		btnSerialize = new Button("Save");
		btnSerialize = functions.ButtonStyle(btnSerialize);
		
		/* FlowPane */
		flow = new FlowPane();
		flow.setAlignment(Pos.CENTER);
		flow.getChildren().addAll(btnInsert,btnTakeOut,btnKvitto,btnSerialize);

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
		vbox.getChildren().addAll(grid, flow, angryMe);

		/* Events */

		btnTakeOut.setOnAction((event) -> {
			amountInsertMoney = amountInsertMoney - Integer.parseInt(takeOutText.getText());
			balanceShow.setText(String.valueOf(amountInsertMoney) + " kr");
			time = getDate(time);
			angryMe.getItems().add(time + " took out this much cash: " + Integer.parseInt(takeOutText.getText()) + " kr");
		});
		
		btnTakeOut.setOnAction((event) -> {
			amountInsertMoney = amountInsertMoney - Integer.parseInt(takeOutText.getText());
			balanceShow.setText(String.valueOf(amountInsertMoney) + " kr");
			time = getDate(time);
		});

		btnInsert.setOnAction((event) -> {
			amountInsertMoney = amountInsertMoney + Integer.parseInt(moneyText.getText());
			balanceShow.setText(String.valueOf(amountInsertMoney) + " kr");
			time = getDate(time + "");
			angryMe.getItems().add(time + " inserted this much money: " + Integer.parseInt(moneyText.getText()) + " kr");
		});
		btnSerialize.setOnAction((event) -> {
			try {
				seri.serializeToXML(CreateAccountPage.list);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Label getAccount() {
		return account;
	}

	public void setAccount(Label account) {
		this.account = account;
	}
	
}
