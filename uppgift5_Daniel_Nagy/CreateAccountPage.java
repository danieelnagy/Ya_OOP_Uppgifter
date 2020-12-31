package uppgift5_Daniel_Nagy;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class CreateAccountPage extends VBox {

	BankPage bankPage;
	static ArrayList<Konto> list = new ArrayList<>();
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	private Date dateNow = new Date(System.currentTimeMillis());
	private String time;
	private int amountInsertMoney = 0;
	private Functions functions;
	private Button btnInsert,btnAccCreate;
	private Label account, balanceLabel, pin, money, balanceShow;
	private GridPane grid;
	private HBox hbox;
	private TextField name, pinText, moneyText;
	private VBox vbox;
	private Konto konto;
	private Main main;

	public CreateAccountPage() {
		Styles();
	}

	void Styles() {
		main = new Main();
		vbox = new VBox();
		functions = new Functions();
		
		/* Scene */
		bankPage = new BankPage();
		Scene manageBankScene = new Scene(bankPage.getVbox());

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

		/* HBOX */
		hbox = new HBox();
		hbox.getChildren().addAll(btnAccCreate, btnInsert);

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
		
        btnAccCreate.setOnAction(e -> {
        	CreateAccountAccess();
        	Main.stage.setScene(manageBankScene);	    
        });

	}
	
	void CreateAccountAccess() {
		if (name.getText().equals("") || pinText.getText().equals("")) {
			;
		} else {
			time = getDate(time);
			konto = new Konto(name.getText(), time , pinText.getText(), amountInsertMoney);
			list.add(konto);
		}
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
	public Button getBtnInsert() {
		return btnInsert;
	}

	public int getAmountInsertMoney() {
		return amountInsertMoney;
	}

	public void setAmountInsertMoney(int amountInsertMoney) {
		this.amountInsertMoney = amountInsertMoney;
	}

	public Button getBtnAccCreate() {
		return btnAccCreate;
	}

	public void setBtnAccCreate(Button btnAccCreate) {
		this.btnAccCreate = btnAccCreate;
	}
	
}
