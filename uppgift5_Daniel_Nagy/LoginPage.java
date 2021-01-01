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
	
	private BankPage bankPage;
	private CreateAccountPage createPage;
	private Functions functions;
	private Button btnCreate, btnLogin;
	private TextField userNameField;
	private PasswordField pwField;
	private Label pin;
	private GridPane grid;
	private FlowPane flow;
	private String accName;
	private String pw;
	static int index = 0;

	public LoginPage() {
		Style();
	}

	void Style() {
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
		GridPane.setHalignment(btnCreate, HPos.LEFT);
		btnCreate.setMinWidth(100);
		GridPane.setMargin(btnCreate, new Insets(50, 50, 50, 50));
		GridPane.setHalignment(btnLogin, HPos.RIGHT);
		btnLogin.setMinWidth(100);
		GridPane.setMargin(btnLogin, new Insets(50, 50, 50, 50));

		/* Grid */
		grid = new GridPane();
		grid = functions.GridStyleSceneOne(grid);
		grid.add(pin, 0, 0);
		grid.add(flow, 0, 1);
		grid.add(btnCreate, 0, 2);
		grid.add(btnLogin, 0, 2);
		
		/* CreateAccountScene */ 
		createPage = new CreateAccountPage();
		Scene CreateAccountScene = new Scene(createPage.getVbox());
		
		/* LoginScene Events */
		
	        btnLogin.setOnAction((e) -> {
	        	accName = userNameField.getText();
	    		pw = pwField.getText();
	    		for(int i = 0; i < CreateAccountPage.list.size();i++) {
	    			if(accName.equals(CreateAccountPage.list.get(i).getUserName()) && pw.equals(CreateAccountPage.list.get(i).getPassword())) {
	    				index = i;
	    				bankPage = new BankPage(CreateAccountPage.list.get(i));
	    				BankPage.angryMe.getItems().addAll(CreateAccountPage.list.get(i).getKvittoList());
	    				Scene manageBankScene = new Scene(bankPage.getVbox());
	    				Main.stage.setScene(manageBankScene);
	    				break;
	    			} else {
	    				;
	    			}
	    		}
	        });
	        
	        btnCreate.setOnAction(e -> {
	        	Main.stage.setScene(CreateAccountScene);	    
	        });
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
