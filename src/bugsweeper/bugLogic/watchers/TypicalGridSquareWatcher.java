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
        System.out.println("setSurroundingBugCount()+");
        for (int i = 0; i < grid.size(); i++) {
            if(grid.get(i).isBug()){
                System.out.println("bug at index " + i);
                //check row above
                checkRow(grid, i-_columns);
                //check row
                checkRow(grid, i);

                checkRow(grid, i+_columns);
            }
        }
        System.out.println("setSurroundingBugCount()-");
    }

    private void checkRow(List<Tile> grid, int i) {
        System.out.println("checking around index " + i);
        if (i < 0) return;

        if(i-1 >= 0){
            System.out.println("Increase " + (i-1));
            grid.get(i-1).increaseSurroundingBugCount();
        }
        if(i+1 < _columns){
            System.out.println("Increase " + (i+1));
            grid.get(i+1).increaseSurroundingBugCount();
        }
    }
}
