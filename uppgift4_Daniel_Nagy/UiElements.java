package uppgift4_Daniel_Nagy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

class UiElements {

	private Person person;
	private ObservableList<Person> list;
	private Serialization ser = new Serialization();
	private GridPane gridPane;
	private TableView<Person> tableView;
	private Label firstName, lastName, age;
	private Button btnAdd, btnUpdate, btnDelete, btnSave;
	private TextField fName, lName, ageText;
	private ArrayList<Person> s = new ArrayList<Person>();

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
		Rows();

		/* Labels */
		firstName = new Label("First Name: ");
		firstName.setPadding(new Insets(0, 0, 0, 30));
		lastName = new Label("Last Name: ");
		lastName.setPadding(new Insets(0, 0, 0, 30));
		age = new Label("Age: ");
		age.setPadding(new Insets(0, 0, 0, 30));
		gridPane.add(firstName, 0, 0);
		gridPane.add(lastName, 0, 1);
		gridPane.add(age, 0, 2);

		/* Buttons */
		btnAdd = new Button("Add");
		btnUpdate = new Button("Update");
		btnDelete = new Button("Delete");
		btnSave = new Button("Save");
		gridPane.add(btnAdd, 0, 0);
		GridPane.setHalignment(btnAdd, HPos.RIGHT);
		btnAdd.setMinWidth(80);
		gridPane.add(btnDelete, 0, 1);
		GridPane.setHalignment(btnDelete, HPos.RIGHT);
		btnDelete.setMinWidth(80);
		gridPane.add(btnUpdate, 0, 2);
		GridPane.setHalignment(btnUpdate, HPos.RIGHT);
		btnUpdate.setMinWidth(80);
		gridPane.add(btnSave, 0, 3);
		GridPane.setHalignment(btnSave, HPos.RIGHT);
		btnSave.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

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

		tableView = new TableView<Person>();
		TableColumn<Person, String> columnOne = new TableColumn<>("First name");
		columnOne.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		TableColumn<Person, String> columnTwo = new TableColumn<>("Last name");
		columnTwo.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		TableColumn<Person, String> columnThree = new TableColumn<>("Age");
		columnThree.setCellValueFactory(new PropertyValueFactory<>("age"));
		tableView.getColumns().addAll(columnOne, columnTwo, columnThree);
		tableView.setItems(getList());
		/* Events */

		/* Add */
		btnAdd.setOnAction((event) -> {
			person = new Person(fName.getText(), lName.getText(), ageText.getText());
			tableView.getItems().add(person);
			s.add(person);
			fName.clear();
			lName.clear();
			ageText.clear();
		});

		/* Remove */
		btnDelete.setOnAction((event) -> {

			Person pers = tableView.getSelectionModel().getSelectedItem();
			tableView.getItems().remove(pers);
			s.remove(pers);
			tableView.refresh();

		});

		/* Update */
		btnUpdate.setOnAction((event) -> {

			Person pers = tableView.getSelectionModel().getSelectedItem();
			pers.setFirstName(fName.getText());
			pers.setLastName(lName.getText());
			pers.setAge(ageText.getText());
			tableView.refresh();

		});

		/* Serialize */

		btnSave.setOnAction((event) -> {
			try {
				ser.serializeToXML(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	void Rows() {
		int numCols = 1;
		int numRows = 4;
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

	public ObservableList<Person> getList() {
		list = FXCollections.observableArrayList();
		s = ser.deserializeFromXML(s);
		if(s.isEmpty()) {
			;
		} else {
		list.addAll(s); 
		}
		return list;
	}

	public ArrayList<Person> getS() {
		return s;
	}

	public void setS(ArrayList<Person> s) {
		this.s = s;
	}
	
}
