package uppgift5_Daniel_Nagy;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

class Functions {

	SceneOne sceneOne;
	SceneTwo sceneTwo;
	private ArrayList<Konto> kontoList = new ArrayList<>();

	public ArrayList<Konto> getKontoList() {
		return kontoList;
	}

	public void setKontoList(ArrayList<Konto> kontoList) {
		this.kontoList = kontoList;
	}

	Label LabelStyleSceneOne(Label label) {

		label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		label.setAlignment(Pos.BASELINE_CENTER);
		return label;
	}

	GridPane GridStyleSceneOne(GridPane grid) {
		int numCols = 1;
		int numRows = 3;
		for (int i = 0; i < numCols; i++) {
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100 / numCols);
			grid.getColumnConstraints().add(colConst);
		}
		for (int i = 0; i < numRows; i++) {
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100 / numRows);
			grid.getRowConstraints().add(rowConst);
		}
		grid.setGridLinesVisible(false);
		return grid;
	}

	GridPane GridStyleSceneTwo(GridPane grid) {
		int numCols = 1;
		int numRows = 4;
		for (int i = 0; i < numCols; i++) {
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100 / numCols);
			grid.getColumnConstraints().add(colConst);
		}
		for (int i = 0; i < numRows; i++) {
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100 / numRows);
			grid.getRowConstraints().add(rowConst);
		}
		grid.setGridLinesVisible(true);
		return grid;
	}
	
	Button ButtonStyle(Button btn) {
		btn.setMinWidth(80);
		return btn;
	}
}
