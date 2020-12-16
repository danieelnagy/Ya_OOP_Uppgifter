package uppgift5_Daniel_Nagy;

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
	Label LabelStyleSceneOne(Label label) {

		label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		label.setAlignment(Pos.CENTER);
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
		grid.setHgap(25);
		grid.setGridLinesVisible(true);
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
		grid.setPadding(new Insets(50,50,50,50));
		grid.setGridLinesVisible(true);
		return grid;
	}
	
	Button ButtonStyle(Button btn) {
		btn.setMinWidth(80);
		return btn;
	}
}
