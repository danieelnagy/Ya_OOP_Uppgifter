package uppgift4_Daniel_Nagy;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

	private UiElements elements = new UiElements();
	private Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		VBox vbox = new VBox();
		vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(elements.GetGrid(), elements.GetTable());
		Scene scene = new Scene(vbox, 600, 320);
        stage.setScene(scene);
        primaryStage.show();
    }
}
