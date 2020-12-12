package uppgift4_Daniel_Nagy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private UiElements elements = new UiElements();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) throws Exception {
		VBox vbox = new VBox();
		vbox.getChildren().addAll(elements.GetGrid(), elements.GetTable());
		Scene scene = new Scene(vbox, 600, 320);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
