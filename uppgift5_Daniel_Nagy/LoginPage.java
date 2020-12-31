package uppgift5_Daniel_Nagy;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

class LoginPage {
	
	BankPage bankPage;
	Main main;
	private CreateAccountPage createPage;
	private Functions functions;
	private Button btnCreate, btnLogin;
	private TextField userNameField;
	private PasswordField pwField;
	private Label pin;
	private GridPane grid;
	private FlowPane flow;
	static public int index = 0;
	String accName;
	String pw;

	public LoginPage() {
		Style();
	}

	void Style() {
		bankPage = new BankPage();
		main = new Main();
		functions = new Functions();
		
		btnCreate = new Button("Create account");
		btnLogin = new Button("Login");
		pin = new Label(
				"Please write in your pin & acc down below in the textboxes,\notherwise click on the create account button");

		/* Texts */

		userNameField = new TextField();
		userNameField.setPromptText("Type userName");
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
		GridPane.setHalignment(btnCreate, HPos.CENTER);
		btnCreate.setMinWidth(100);
		GridPane.setMargin(btnCreate, new Insets(20, 80, 20, 20));
		GridPane.setHalignment(btnLogin, HPos.RIGHT);
		btnLogin.setMinWidth(100);
		GridPane.setMargin(btnLogin, new Insets(20, 20, 80, 20));

		/* Grid */
		grid = new GridPane();
		grid = functions.GridStyleSceneOne(grid);
		grid.add(pin, 0, 0);
		grid.add(flow, 0, 1);
		grid.add(btnCreate, 0, 2);
		grid.add(btnLogin, 0, 2);
		
		
		/* Events */
		
		/* CreateAccountScene */ 
		createPage = new CreateAccountPage();
		Scene CreateAccountScene = new Scene(createPage.getVbox());
		
		/* BankPage */
		bankPage = new BankPage();
		Scene manageBankScene = new Scene(bankPage.getVbox());
		
		
		/* LoginScene Events */
		/*
	        sceneOne.getLogin().setOnAction((e) -> {
	        	b = sceneOne.Access(b);
	        	if(b == true) {
	        		stage.setScene(finalFinalScene);
	        	}
	        }); */
	        
	        btnCreate.setOnAction(e -> {
	        	Main.stage.setScene(CreateAccountScene);	    
	        });
	     
	        
	        /*
			createPage.getBtnAccCreate().setOnAction((event) -> {
				createPage.CreateAccountAccess();
				stage.setScene(manageBankScene);
			});		*/
		
		
		
		
		
		
		/*
		btnCreate.setOnAction(e -> {
        });
		/*
        btnLogin.setOnAction((e) -> {
        	b = sceneOne.Access(b);
        	if(b == true) {
        		stage.setScene(finalFinalScene);
        	}
        }); */
	}
	/*
	Boolean Access(Boolean b) {
		accName = userNameField.getText();
		pw = pwField.getText();
		for(int i = 0;i < CreateAccountPage.list.size();i++) {
		if(accName.equals(CreateAccountPage.list.get(i).getUserName()) && pw.equals(CreateAccountPage.list.get(i).getPassword())) {
			bankPage.setUserName(CreateAccountPage.list.get(i).getUserName());
			bankPage.setBalance(CreateAccountPage.list.get(i).getBalance());
			b = true;
		} else {
			b = false;
		}
		}
		return b;
	}
	*/
	String AccName(String userName) {
		userName = userNameField.getText();
		return userName;
	}
	String Password(String password) {
		password = pwField.getText();
		return password;
	}

	public GridPane getGrid() {
		return grid;
	}

	public Button getBtnCreate() {
		return btnCreate;
	}

	public void setBtnCreate(Button btnCreate) {
		this.btnCreate = btnCreate;
	}

	public Button getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(Button btnLogin) {
		this.btnLogin = btnLogin;
	}
	
}
