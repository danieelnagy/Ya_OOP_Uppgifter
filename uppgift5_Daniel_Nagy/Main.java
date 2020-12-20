package uppgift5_Daniel_Nagy;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

	Boolean b = false;
	static String name = "";
	private Stage stage;
	Stage stageTwo;
	Functions func = new Functions();
	SceneOne sceneOne = new SceneOne();
	SceneTwo sceneTwo = new SceneTwo();
	SceneThree sceneThree = new SceneThree();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stageTwo = primaryStage;
		Scene scene = new Scene(sceneOne.getGrid(), 400, 200);
		Scene finalScene = new Scene(sceneTwo.getVbox());
		Scene finalFinalScene = new Scene(sceneThree.getVbox());
        stage.setScene(scene);
        sceneOne.getCreate().setOnAction(e -> {
        	stage.setScene(finalScene);
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
        primaryStage.show();
    }
}
