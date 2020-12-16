package uppgift5_Daniel_Nagy;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

class SceneTwo {

	private Functions functions;
	private Button takeMoney, insertMoney, showBalance, start;
	private Label account, balanceLabel, date, lastTransaction;
	private VBox vbox;
	private GridPane grid;
	private TableView table;
	private HBox hbox;
	
	public SceneTwo() {
		Styles();
	}
	

	void Styles() {
		functions = new Functions();
		
		/* Labels */
		account = new Label("Account owner: ");
		balanceLabel = new Label("Balance: ");
		date = new Label("Date: ");
		lastTransaction = new Label("Last transaction");
		
		/* Buttons */
		takeMoney = new Button("Take money");
		takeMoney = functions.ButtonStyle(takeMoney);
		
		insertMoney = new Button("Insert money");
		insertMoney = functions.ButtonStyle(insertMoney);
		
		showBalance = new Button("Show balance");
		showBalance = functions.ButtonStyle(showBalance);
		
		/* HBOX */
		hbox = new HBox();
		hbox.getChildren().addAll(account,balanceLabel,date,lastTransaction,showBalance,insertMoney,takeMoney);
	
		
		/* Grid */
		grid = new GridPane();
		grid = functions.GridStyleSceneTwo(grid);
        grid.add(account, 0, 0);
        grid.add(balanceLabel, 0, 1);
        grid.add(date, 0, 2);
        grid.add(lastTransaction, 0, 3);
        
        /* Table */
        
        table = new TableView();
        
        
		
        /* Vbox */
        
        vbox = new VBox();
        vbox.getChildren().addAll(grid, table, hbox);
	}


	public VBox getVbox() {
		return vbox;
	}


	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}
	
}
