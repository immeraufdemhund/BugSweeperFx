package bugsweeper.bugLogic.watchers;

import bugsweeper.bugLogic.BugPlanter;
import bugsweeper.bugLogic.PlayAreaLayout;
import bugsweeper.bugLogic.planters.RandomBugPlanter;
import bugsweeper.models.Tile;

import java.util.List;

/**
 * Created by snyder on 2015-07-16.
 * TypicalGridSquareWatcher is used for a typical 2d layout of a minesweeper board
 * x,y coordinates: 0,0 being top left, index is laid out left to right (3x3 example)
 * 0 1 2
 * 3 4 5
 * 6 7 8
 */
public class TypicalGridSquareWatcher extends PlayAreaLayout {
    private final int _rows;
    private final int _columns;

    public TypicalGridSquareWatcher(int rows, int columns) {
        _rows = rows;
        _columns = columns;
    }

    @Override
    protected BugPlanter getBugPlanter() {
        return new RandomBugPlanter();
    }

    @Override
    public int getTotalCellCount() {
        return _rows * _columns;
    }

    @Override
    public void setSurroundingBugCount(List<Tile> grid) {
        if(grid.get(0).isBug()){
            grid.get(1).increaseSurroundingBugCount();
            grid.get(3).increaseSurroundingBugCount();
            grid.get(4).increaseSurroundingBugCount();
        }
        if(grid.get(1).isBug()){
            grid.get(0).increaseSurroundingBugCount();
            grid.get(2).increaseSurroundingBugCount();
            grid.get(3).increaseSurroundingBugCount();
            grid.get(4).increaseSurroundingBugCount();
            grid.get(5).increaseSurroundingBugCount();
        }
    }
}
