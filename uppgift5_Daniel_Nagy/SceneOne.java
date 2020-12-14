package uppgift5_Daniel_Nagy;

import java.io.IOException;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

class SceneOne {
	
	private Functions functions = new Functions();
	private Button create, login;
	private Label pin;
	private TextField pinOne, pinTwo, pinThree, pinFour;
	private GridPane grid;
	private FlowPane flow;
	
	public SceneOne() {
		Style();
	}
	
	void Style() {
		
		create = new Button("Create account");
		login = new Button("Login");
		pin = new Label("Please write in your PIN code(OBS its 4444)"); //använd 4444 for login, annars create acc.
		
		/* Text Field */
		pinOne = new TextField();
		pinOne.setPromptText("1st number of pin");
		pinOne.setMinSize(10, 40);
		pinTwo = new TextField();
		pinTwo.setPromptText("2nd number of pin");
		pinTwo.setMinSize(10, 40);
		pinThree = new TextField();
		pinThree.setPromptText("3rd number of pin");
		pinThree.setMinSize(10, 40);
		pinFour = new TextField();
		pinFour.setPromptText("4th number of pin");
		pinFour.setMinSize(10, 40);
		
		/* FlowPane */
		
		flow = new FlowPane();
		flow.getChildren().addAll(pinOne, pinTwo, pinThree, pinFour);
		FlowPane.setMargin(pinOne, new Insets(20, 20, 20, 30));
		FlowPane.setMargin(pinTwo, new Insets(20, 20, 20, 20));
		FlowPane.setMargin(pinThree, new Insets(20, 20, 20, 30));
		FlowPane.setMargin(pinFour, new Insets(20, 20, 20, 20));
		flow.setHgap(0);
		
		/* Label */
		pin = functions.LabelStyle(pin);
		
		/* Buttons */ 
		GridPane.setHalignment(create, HPos.LEFT);
		create.setMinWidth(100);
		GridPane.setMargin(create, new Insets(20, 20, 20, 80));
		GridPane.setHalignment(login, HPos.RIGHT);
		login.setMinWidth(100);
		GridPane.setMargin(login, new Insets(20, 80, 20, 20));
		
		/* Grid */
		grid = new GridPane();
		grid = functions.GridStyle(grid);
		grid.add(pin, 0, 0);
		grid.add(flow, 0, 1);
		grid.add(create, 0, 2);
		grid.add(login, 0, 2);
		
		/* Events */
		create.setOnAction((event) -> {
	
		});	
		
		login.setOnAction((event) -> {
			
		});	
	
	}

	public Button getCreate() {
		return create;
	}

	public void setCreate(Button create) {
		this.create = create;
	}

	public Button getLogin() {
		return login;
	}

	public void setLogin(Button login) {
		this.login = login;
	}

	public GridPane getGrid() {
		return grid;
	}
}
