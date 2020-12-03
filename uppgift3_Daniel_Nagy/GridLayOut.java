package uppgift3_Daniel_Nagy;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

class GridLayOut {
	
	private Buttons btn = new Buttons();
	/*
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
	
	private GridPane grid;
	private int numCols;
	private int numRows;
	
	public GridLayOut()
	{
		Grid();
	}
	
	private void Grid()
	{
		grid = new GridPane();
		grid.add(btn.getButton(), 0, 0);
		GridPane.setHalignment(btn.getButton(), HPos.RIGHT);
		grid.setMinSize(400, 200);
		grid.setGridLinesVisible(true);
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setVgap(5); 
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
	public GridPane getGrid() {
	    return grid;
	}
	  public void setName(GridPane grid) {
	    this.grid = grid;
	}
}
