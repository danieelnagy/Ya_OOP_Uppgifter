package uppgift4_Daniel_Nagy;

import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

class UiElements {
	Person person;
	private Serialization ser = new Serialization();
	private GridPane gridPane;
	private TableView<Person> tableView;
	private Label firstName, lastName, age;
	private Button btnAdd, btnUpdate, btnDelete;
	private TextField fName, lName, ageText;
	ArrayList<String> s = new ArrayList<>();
	
	public UiElements() {
		Styles();
	}
	GridPane GetGrid() {
		return gridPane;
	}
	TableView<Person> GetTable() {
		return tableView;
	}
	
	void Styles() {
		/* Grid Styles */
		gridPane = new GridPane();
		gridPane.setHgap(5);
		//gridPane.setPadding(new Insets(20,20,20,20));
		gridPane.setGridLinesVisible(true);
		Rows();
		
		/* Labels */
		firstName = new Label("First Name: ");
		firstName.setPadding(new Insets(0,0,0,30));
		lastName = new Label("Last Name: ");
		lastName.setPadding(new Insets(0,0,0,30));
		age = new Label("Age: ");
		age.setPadding(new Insets(0,0,0,30));
		gridPane.add(firstName, 0, 0);
		gridPane.add(lastName, 0, 1);
		gridPane.add(age, 0, 2);
		
		/* Buttons*/		
		btnAdd = new Button("Add");
		btnUpdate = new Button("Update");
		btnDelete = new Button("Delete");
		gridPane.add(btnAdd, 0, 0);
		GridPane.setHalignment(btnAdd, HPos.RIGHT);
		btnAdd.setMinWidth(80);
		gridPane.add(btnDelete, 0, 1);
		GridPane.setHalignment(btnDelete, HPos.RIGHT);
		btnDelete.setMinWidth(80);
		gridPane.add(btnUpdate, 0, 2);
		GridPane.setHalignment(btnUpdate, HPos.RIGHT);
		btnUpdate.setMinWidth(80);
		
		/* TextFields */
		fName = new TextField("");
		fName.setPromptText("Type first name here");
		lName = new TextField("");
		lName.setPromptText("Type last Name here");
		ageText = new TextField("");
		ageText.setPromptText("Type age here");

		gridPane.add(fName, 0, 0);
		fName.setMaxSize(350, 20);
		GridPane.setHalignment(fName, HPos.CENTER);
		gridPane.add(lName, 0, 1);
		lName.setMaxSize(350, 20);
		GridPane.setHalignment(lName, HPos.CENTER);
		gridPane.add(ageText, 0, 2);
		ageText.setMaxSize(350, 20);
		GridPane.setHalignment(ageText, HPos.CENTER);
		/* Table */
		
	    tableView = new TableView<>();

	    TableColumn<Person, String> columnOne = new TableColumn<Person, String>("First name");
	    TableColumn<Person, String>  columnTwo = new TableColumn<Person, String>("Last name");
	    TableColumn<Person, String>  columnThree = new TableColumn<Person, String>("Age");

	    tableView.getColumns().addAll(columnOne, columnTwo, columnThree);
       
        /* Events */
        btnAdd.setOnAction((event) -> {
        	
        	/*String S = fName.getText();
        	String f = lName.getText();
        	String l = ageText.getText();*/
    	    //columnOne.setCellValueFactory(c -> new SimpleStringProperty(fName.getText()));
    	    //columnTwo.setCellValueFactory(c -> new SimpleStringProperty(lName.getText()));
    	    //columnThree.setCellValueFactory(c -> new SimpleStringProperty(ageText.getText()));
    	    person = new Person(fName.getText(),lName.getText(),ageText.getText());
    	    fName.clear();
    	    lName.clear();
    	    ageText.clear();
    	    /*person.setName(fName.getText());
    	    person.setLastName(lName.getText());
    	    person.setAge(ageText.getText());
        	/*List<Person> list = new ArrayList<>();
        	list.add(person);*/
        	Serialization ser = new Serialization();
        	//ser.setPers(list);
        	tableView.getItems().add(person);
        	s.add(person.toString());
        	try {
				ser.serializeToXML(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	void Rows () {
		int numCols = 1;
		int numRows = 3;
		for (int i = 0; i < numCols; i++) {
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100 / numCols);
			gridPane.getColumnConstraints().add(colConst);
		}
		for (int i = 0; i < numRows; i++) {
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100 / numRows);
			gridPane.getRowConstraints().add(rowConst);
		}
	}
}
