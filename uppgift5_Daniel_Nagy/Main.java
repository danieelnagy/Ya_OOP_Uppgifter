package uppgift5_Daniel_Nagy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

	private Stage stage;
	SceneOne sceneOne = new SceneOne();
	SceneTwo sceneTwo;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) throws Exception {
		sceneTwo = new SceneTwo();
		stage = primaryStage;
		Scene scene = new Scene(sceneOne.getGrid(), 400, 300);
		Scene finalScene = new Scene(sceneTwo.getVbox()); 
        sceneOne.getCreate().setOnAction(e -> stage.setScene(finalScene));
        stage.setScene(scene);
        primaryStage.show();
        /* First Stage events bad praxis... */ 
        
		/*sceneOne.getCreate().setOnAction((event) -> {
			Scene finalScene = new Scene(sceneTwo.getHbox()); 
			stage.setScene(finalScene);
		}); */
    }
}
