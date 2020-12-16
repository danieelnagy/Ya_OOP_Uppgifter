package uppgift5_Daniel_Nagy;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

class SceneTwo {

	private Functions functions;
	private Button takeMoney, insertMoney, showBalance, start;
	private Label account, balanceLabel, date, lastTransaction;
	private HBox hbox;
	private StackPane pane;
	
	public SceneTwo() {
		Styles();
	}
	
	public StackPane getPane() {
		return pane;
	}

	public void setPane(StackPane pane) {
		this.pane = pane;
	}

	void Styles() {
		
		takeMoney = new Button("Take money");
		insertMoney = new Button("Insert money");
		showBalance = new Button("Show balance");
		account = new Label("Account owner: ");
		balanceLabel = new Label("Balance: ");
		date = new Label("Date: ");
		lastTransaction = new Label("Last transaction");
		hbox = new HBox();
		functions = new Functions();
		
		/* Buttons */
		takeMoney = functions.ButtonStyle(takeMoney);
		insertMoney = functions.ButtonStyle(insertMoney);
		showBalance = functions.ButtonStyle(showBalance);
		
		/* HBOX */
		
		hbox.getChildren().addAll(account,balanceLabel,date,lastTransaction,showBalance,insertMoney,takeMoney);
		
		/* Pane */
		pane = new StackPane();
		pane.getChildren().add(hbox);
	}
}
