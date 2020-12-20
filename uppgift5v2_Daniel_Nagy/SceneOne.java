package uppgift5v2_Daniel_Nagy;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

class SceneOne {
	
	private Functions functions = new Functions();
	private Button create, login;
	private Label pin;
	private GridPane grid;
	private FlowPane flow;
	User user = new User();
	Text userName = new Text();
	ArrayList<User> sad = new ArrayList<>();

	public SceneOne() {
		Style();
	}
	
	void Style() {
		userName.textProperty().bind(user.userNameProperty());

		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Password");

		// Single direction bind of user.password
		user.passwordProperty().bind(passwordField.textProperty());

		// listener for password changes
		passwordField.textProperty()
				.addListener((observable, oldValue, newValue) -> System.out.println("the password is: " + newValue));


		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println(user.getPassword());
			}
		};

		//login.setOnAction(event);
		
		
		create = new Button("Create account");
		login = new Button("Login");
		pin = new Label("Please write in your pin & acc down below in the textboxes,\notherwise click on the create account button");
		
		/* Text */

		/* FlowPane  */
		
		flow = new FlowPane();
		flow.setAlignment(Pos.CENTER);
		flow.getChildren().addAll(userName, passwordField);
		FlowPane.setMargin(passwordField, new Insets(20, 20, 20, 30));
		flow.setHgap(0);
		
		/* Label */
		pin = functions.LabelStyleSceneOne(pin);
		GridPane.setHalignment(pin, HPos.CENTER);
		
		/* Buttons */ 
		GridPane.setHalignment(create, HPos.LEFT);
		create.setMinWidth(100);
		GridPane.setMargin(create, new Insets(20, 20, 20, 80));
		GridPane.setHalignment(login, HPos.RIGHT);
		login.setMinWidth(100);
		GridPane.setMargin(login, new Insets(20, 80, 20, 20));
		
		/* Grid */
		grid = new GridPane();
		grid = functions.GridStyleSceneOne(grid);
		grid.add(pin, 0, 0);
		grid.add(flow, 0, 1);
		grid.add(create, 0, 2);
		grid.add(login, 0, 2);
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
