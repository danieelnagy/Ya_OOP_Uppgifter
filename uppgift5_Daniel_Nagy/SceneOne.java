package uppgift5_Daniel_Nagy;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

class SceneOne {
	
	SceneThree three;
	private Functions functions;
	private Button create, login, decode;
	private TextField userNameField;
	private PasswordField pwField;
	private Label pin;
	private GridPane grid;
	private FlowPane flow;
	static public int index = 0;
	String accName;
	String pw;

	public SceneOne() {
		Style();
	}

	void Style() {
		
		three = new SceneThree();
		functions = new Functions();
		
		create = new Button("Create account");
		decode = new Button("Get accounts");
		login = new Button("Login");
		pin = new Label(
				"Please write in your pin & acc down below in the textboxes,\notherwise click on the create account button");

		/* Texts */

		userNameField = new TextField();
		userNameField.setPromptText("Type userName");
		;
		pwField = new PasswordField();
		pwField.setPromptText("Type password");

		/* FlowPane */

		flow = new FlowPane();
		flow.setAlignment(Pos.CENTER);
		flow.getChildren().addAll(userNameField, pwField);
		FlowPane.setMargin(pwField, new Insets(20, 20, 20, 30));
		flow.setHgap(0);

		/* Label */
		pin = functions.LabelStyleSceneOne(pin);
		GridPane.setHalignment(pin, HPos.CENTER);

		/* Buttons */
		GridPane.setHalignment(decode, HPos.LEFT);
		decode.setMinWidth(100);
		GridPane.setMargin(decode, new Insets(20, 20, 20, 20));
		GridPane.setHalignment(create, HPos.CENTER);
		create.setMinWidth(100);
		GridPane.setMargin(create, new Insets(20, 20, 20, 20));
		GridPane.setHalignment(login, HPos.RIGHT);
		login.setMinWidth(100);
		GridPane.setMargin(login, new Insets(20, 20, 20, 20));

		/* Grid */
		grid = new GridPane();
		grid = functions.GridStyleSceneOne(grid);
		grid.add(pin, 0, 0);
		grid.add(flow, 0, 1);
		grid.add(create, 0, 2);
		grid.add(login, 0, 2);
		grid.add(decode, 0, 2);
	}
	
	Boolean Access(Boolean b) {
		accName = userNameField.getText();
		pw = pwField.getText();
		for(int i = 0;i < SceneTwo.list.size();i++) {
		if(accName.equals(SceneTwo.list.get(i).getUserName()) && pw.equals(SceneTwo.list.get(i).getPassword())) {
			three.setUserName(SceneTwo.list.get(i).getUserName());
			three.setBalance(SceneTwo.list.get(i).getBalance());
			b = true;
		} else {
			b = false;
		}
		}
		return b;
	}
	
	String AccName(String userName) {
		userName = userNameField.getText();
		return userName;
	}
	String Password(String password) {
		password = pwField.getText();
		return password;
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

	public Button getDecode() {
		return decode;
	}

	public void setDecode(Button decode) {
		this.decode = decode;
	}
	
}
