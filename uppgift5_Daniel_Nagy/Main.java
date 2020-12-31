package uppgift5_Daniel_Nagy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	/*
	Boolean b = false;
	private Stage stage;
	Stage stageTwo;
	Functions func = new Functions();
	LoginPage sceneOne = new LoginPage();
	CreateAccountPage sceneTwo = new CreateAccountPage();
	BankPage bankPage = new BankPage();
	Save save = new Save();
	Serialization ser = new Serialization();
	*/
	static Stage stage;
	private LoginPage loginPage;
	static Scene scene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) throws Exception {
		/* LoginScene */
		loginPage = new LoginPage();
		stage = primaryStage;
		scene = new Scene(loginPage.getGrid(), 400, 200);
		stage.setScene(scene);
		primaryStage.show();
		
		
		
		/*
		stage = primaryStage;
		stageTwo = primaryStage;
		Scene scene = new Scene(sceneOne.getGrid(), 400, 200);
		Scene finalScene = new Scene(sceneTwo.getVbox());
		Scene finalFinalScene = new Scene(bankPage.getVbox());
        stage.setScene(scene);
        sceneOne.getCreate().setOnAction(e -> {
        	stage.setScene(finalScene);
        	
        });
        sceneOne.getDecode().setOnAction(e -> {
        	CreateAccountPage.list = ser.deserializeFromXML();
        });
        sceneTwo.getBtnDone().setOnAction((e) -> {
        	stage.setScene(scene);
        });
        sceneOne.getLogin().setOnAction((e) -> {
        	b = sceneOne.Access(b);
        	if(b == true) {
        		stage.setScene(finalFinalScene);
        	}
        });
        bankPage.getBtnKvitto().setOnAction((e) -> {
            save.SaveAcc();
        });
        primaryStage.show();
        */
    }
	

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}
