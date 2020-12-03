package uppgift3_Daniel_Nagy;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage stage;
	private GridLayOut grid;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	
	public void start(Stage primaryStage) throws Exception {
		grid = new GridLayOut();
		stage = primaryStage;
		stage.setTitle("Stoppuret");
		//Label
		Label timerLabel = new Label();
		timerLabel.setText("BLABLABASDASDWASD");
		Label timerLabel1 = new Label();
		timerLabel1.setText("BLABLABASDASDWASD");
		Label timerLabel2 = new Label();
		timerLabel2.setText("BLABLABASDASDWASD");
		Label timerLabel3 = new Label();
		timerLabel3.setText("BLABLABASDASDWASD");
		Label timerLabel4 = new Label();
		timerLabel4.setText("BLABLABASDASDWASD");
		//timerLabel.setPadding(new Insets(0, 0, 0, 185));
		
		//Button
		/*
		Button btnStartStop = new Button("Start/Stop");
		btnStartStop.getStyleClass().add("btnStartStop");
		grid.add(timerLabel, 0,0);
		grid.add(timerLabel1, 0,1);
		grid.add(timerLabel2, 0,2);
		grid.add(timerLabel3, 0,1);
		grid.add(timerLabel4, 0,2);
		grid.add(btnStartStop, 0, 0);
		GridPane.setHalignment(btnStartStop, HPos.RIGHT);
		GridPane.setHalignment(timerLabel3, HPos.RIGHT);
		GridPane.setHalignment(timerLabel4, HPos.RIGHT);
		*/
		
		
		//grid.getChildren().addAll(timerLabel,btnStartStop);
		/*Group group = new Group();
		Label timerLabel = new Label("22222");
		Button btnStartStop = new Button("Start/Stop");
		VBox vbox = new VBox();
        vbox.getChildren().addAll(btnStartStop, timerLabel);
        group.getChildren().add(vbox);
        */
		
		
		/*
		//Hbox style
		HBox hbox = new HBox();
		hbox.setMinSize(400, 400);
		hbox.setPadding(new Insets(25,50,25,50));
		hbox.setVisible(true);
		
		/*
		//Vbox styles
		VBox vbox = new VBox();
		vbox.setMinSize(200, 200);
		vbox.setPadding(new Insets(25,50,25,50));
		VBox vboxTwo = new VBox();
		vboxTwo.setMinSize(200, 200);
		vboxTwo.setPadding(new Insets(25,50,25,50));
		hbox.getChildren().addAll(vbox,vboxTwo);
		*/
		Scene scene = new Scene(grid.getGrid());
		/*
		//Elements styles
		Button btn = new Button("WWWWWWWWWWWW");
		Label lbl= new Label("asd");
		lbl.setAlignment(Pos.TOP_RIGHT);
		Label lbl1= new Label("wad");
		Label lbl2= new Label("grd");
		vboxTwo.getChildren().addAll(lbl1,lbl2);
		vbox.getChildren().addAll(btn,lbl);
		*/
		//scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		primaryStage.show();
		
	}
}