package uppgift5_Daniel_Nagy;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	private Serialization ser = new Serialization();
	static Stage stage;
	private LoginPage loginPage;
	static Scene scene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) throws Exception {
		CreateAccountPage.list = ser.deserializeFromXML(CreateAccountPage.list);
		loginPage = new LoginPage();
		stage = primaryStage;
		scene = new Scene(loginPage.getGrid(), 400, 200);
		stage.setScene(scene);
		primaryStage.show();
        primaryStage.setOnCloseRequest((event) -> {
    		try {
    			ser.serializeToXML(CreateAccountPage.list);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        Platform.exit();
        });
    }
	

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}
