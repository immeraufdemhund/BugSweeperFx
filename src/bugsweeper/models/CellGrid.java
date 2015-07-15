package bugsweeper.models;

import bugsweeper.bugLogic.BugPlanter;
import bugsweeper.bugLogic.planters.RandomBugPlanter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by snyder on 2015-07-15.
 */
public class CellGrid {
    private static final BugPlanter DEFAULT_BUG_PLANTER = new RandomBugPlanter();

    private final List<GridSquare> _cells;
    private final int _columns;
    private final int _rows;

    private BugPlanter bugPlanter = DEFAULT_BUG_PLANTER;

    public CellGrid(int columns, int rows) {
        _rows = rows;
        _columns = columns;

        _cells = Collections.unmodifiableList(generateGridSquaresList(columns * rows));
    }

    private List<GridSquare> generateGridSquaresList(int squareCount) {
        List<GridSquare> temp = new ArrayList<>(squareCount);
        for (int i = 0; i < squareCount; i++) {
            temp.add(new GridSquare());
        }
        return temp;
    }

    public void uncoverSquare(int column, int row) {
        _cells.get(column + (row * _rows)).uncoverSquare();
    }

    public void setBugCount(int bugCount) {
        _cells.forEach(gridSquare -> gridSquare.clearIsBug());
        bugPlanter.Plant(_cells, bugCount);
    }

    public void setPlanter(BugPlanter planter) {
        bugPlanter = planter;
    }
}
