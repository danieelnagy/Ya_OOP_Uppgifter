package uppgift5_Daniel_Nagy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

	private Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		HBox hbox = new HBox();
		hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 0, 0, 10));
        StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 200, 200);
        stage.setScene(scene);
        primaryStage.show();
    }
}
