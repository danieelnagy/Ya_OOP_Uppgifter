package uppgift4_Daniel_Nagy;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private UiElements elements = new UiElements();
	private Person person;
	private Stage stage;
	private String filename;

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
		Seri();
		Scene scene = new Scene(vbox, 600, 320);
        stage.setScene(scene);
        primaryStage.show();
    }
	public void Seri() {
		filename = "thisIsIt.xml";
		XMLEncoder encoder = null;
		 try { 
			  encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
			  System.out.println("asdddd");
	  
	            // Method for serialization of object 
	            System.out.println("Object has been serialized\n" + "Data before Deserialization.");
	        } 
	  
	        catch (IOException ex) { 
	            System.out.println("IOException is caught"); 
	        } 
	  
	        person = null; 
	}

}
