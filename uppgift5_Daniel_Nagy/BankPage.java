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

public class BankPage {

	Serialization seri;
	Konto konto;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	private Date dateNow = new Date(System.currentTimeMillis());
	private String time;
	private String owner;
	FlowPane flow;
    private int balance;
	private Functions functions;
	private Button btnInsert, btnTakeOut, btnKvitto, btnSerialize;
	private Label account, accountShow, balanceLabel, takeOut, money, balanceShow;
	private GridPane grid;
	private HBox hbox;
	private TextField takeOutText, moneyText;
	private VBox vbox;

	public BankPage(Konto konto) {
		this.konto = konto;
		bankStyles();
	}
	
	
    public void bankStyles() {
		seri = new Serialization();
		ListView<String> angryMe = new ListView<String>();
		vbox = new VBox();
		functions = new Functions();

		/* Labels */
		account = new Label("Owner: ");
		owner = konto.getUserName();
		accountShow = new Label(owner);
		balanceLabel = new Label("Balance: ");
		balance = konto.getBalance();
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

		
		/* FlowPane */
		flow = new FlowPane();
		flow.setAlignment(Pos.CENTER);
		flow.getChildren().addAll(btnInsert,btnTakeOut);

		/* Grid */
		grid = new GridPane();
		grid = functions.GridStyleSceneTwo(grid);

		grid.add(account, 0, 0);
		GridPane.setHalignment(account, HPos.LEFT);
		grid.add(accountShow, 0, 0);
		GridPane.setHalignment(accountShow, HPos.CENTER);
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
			if(balance > Integer.parseInt(takeOutText.getText())) {
				
			balance = balance - Integer.parseInt(takeOutText.getText());
			balanceShow.setText(String.valueOf(balance) + " kr");
			time = getDate(time);
			angryMe.getItems().add(time + " took out this much cash: " + Integer.parseInt(takeOutText.getText()) + " kr");
			konto.setBalance(balance);
			} else {
				balanceShow.setText("DENIED, TOO LOW BALANCE, try again with less money." + " Current balance: " + String.valueOf(balance) + " kr");
			}
		});
		
		btnInsert.setOnAction((event) -> {
			balance = balance + Integer.parseInt(moneyText.getText());
			balanceShow.setText(String.valueOf(balance) + " kr");
			time = getDate(time + "");
			angryMe.getItems().add(time + " inserted this much money: " + Integer.parseInt(moneyText.getText()) + " kr");
			konto.setBalance(balance);
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Konto getKonto() {
		return konto;
	}

	public void setKonto(Konto konto) {
		this.konto = konto;
		owner = konto.getUserName();
		balance = konto.getBalance();
	}
}
