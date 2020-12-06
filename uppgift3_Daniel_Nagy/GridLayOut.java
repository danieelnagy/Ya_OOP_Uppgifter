package uppgift3_Daniel_Nagy;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

class GridLayOut {

	private Elements elements = new Elements();
	private GridPane grid;
	private int numCols;
	private int numRows;

	public GridLayOut() {
		GridStyles();
	}

	public GridPane getGrid() {
		return grid;
	}

	private void GridStyles() {
		grid = new GridPane();
		grid.add(elements.getTimeLabel(), 0, 0);
		grid.add(elements.getStartButton(), 0, 0);
		grid.add(elements.getStopButton(), 0, 1);
		grid.add(elements.getDateLabel(), 0, 2);
		GridPane.setHalignment(elements.getStartButton(), HPos.RIGHT);
		GridPane.setHalignment(elements.getStopButton(), HPos.CENTER);
		GridPane.setHalignment(elements.getDateLabel(), HPos.CENTER);
		grid.setMinSize(400, 200);
		grid.setGridLinesVisible(true);
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		numCols = 1;
		numRows = 3;
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
	}
}
