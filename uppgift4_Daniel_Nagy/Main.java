package uppgift4_Daniel_Nagy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

	private UiElements elements = new UiElements();
	Serialization ser = new Serialization();
	Events eve = new Events();
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
		Scene scene = new Scene(vbox, 1024, 768);
        stage.setScene(scene);
        primaryStage.show();
    }
}
