package uppgift5v2_Daniel_Nagy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class StartPage extends Application {

	private Stage stage;
	Stage stageTwo;
	SceneOne sceneOne = new SceneOne();
	//SceneTwo sceneTwo = new SceneTwo();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stageTwo = primaryStage;
		Scene scene = new Scene(sceneOne.getGrid(), 400, 200);
		//Scene finalScene = new Scene(sceneTwo.getVbox());
        stage.setScene(scene);
        /*sceneOne.getCreate().setOnAction(e -> {
        	stage.setScene(finalScene);
        });
        sceneTwo.getBtnDone().setOnAction((e) -> {
        	stage.setScene(scene);
        });*/
        primaryStage.show();
    }
}
