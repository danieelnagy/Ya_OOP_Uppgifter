package uppgift4_Daniel_Nagy;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

class Events {

	
	public TableView<Person> tableView;

	
	TableView<Person> GetTable() {
		return tableView;
	}
	public ObservableList<Person> getListe() {
		ObservableList<Person> data = FXCollections.observableArrayList(
		new Person("Abby", "Lax", "StrongCat"),
		new Person("Ellie", "Fireflies", "SneakyCat"),
		new Person("Medi", "Strawberry", "GoodDog"),
		new Person("Daisy", "Duck", "YorkieDog"),
		new Person("Daphne", "Turkey", "Puppy"),
		new Person("Joel", "Beef", "Puppy"));
		return data;
		}

	public void asd() {
	tableView = new TableView<>();

    TableColumn<Person, String> columnOne = new TableColumn<>("First name");
    columnOne.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    TableColumn<Person, String>  columnTwo = new TableColumn<>("Last name");
    columnTwo.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    TableColumn<Person, String>  columnThree = new TableColumn<>("Age");
    columnThree.setCellValueFactory(new PropertyValueFactory<>("age"));
    tableView.setItems(getListe());
    tableView.getColumns().addAll(columnOne, columnTwo, columnThree);
	}
}
