package bugsweeper.models;

import bugsweeper.GameCompletedEventListener;
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

    private BugPlanter bugPlanter = DEFAULT_BUG_PLANTER;
    private GameCompletedEventListener gameCompletedEventListener;

    public CellGrid(int cellCount) {
        _cells = Collections.unmodifiableList(generateGridSquaresList(cellCount));
    }

    private List<GridSquare> generateGridSquaresList(int squareCount) {
        List<GridSquare> temp = new ArrayList<>(squareCount);
        for (int i = 0; i < squareCount; i++) {
            temp.add(new GridSquare());
        }
        return temp;
    }

    public void uncoverSquare(int index) {
        GridSquare cell = _cells.get(index);
        cell.uncoverSquare();
        if(cell.isBug())
            gameCompletedEventListener.GameLost();
    }

    public void setBugCount(int bugCount) {
        _cells.forEach(gridSquare -> gridSquare.clearIsBug());
        bugPlanter.Plant(_cells, bugCount);
    }

    public void setPlanter(BugPlanter planter) {
        bugPlanter = planter;
    }

    public void setGameCompletedEventListener(GameCompletedEventListener gameCompletedEventListener) {
        this.gameCompletedEventListener = gameCompletedEventListener;
    }
}
