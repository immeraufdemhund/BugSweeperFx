package bugsweeper.watchers;

import bugsweeper.bugLogic.BugPlanter;
import bugsweeper.bugLogic.PlayAreaLayout;
import bugsweeper.models.Tile;

import java.util.List;

/**
 * Created by snyder on 2015-07-19.
 */
public class GenericGridSquareWatcher extends PlayAreaLayout {
    private final int _cellCount;
    private final BugPlanter _bugPlanter;

    public GenericGridSquareWatcher(BugPlanter bugPlanter, int cellCount) {
        _bugPlanter = bugPlanter;
        _cellCount = cellCount;
    }

    @Override
    protected BugPlanter getBugPlanter() {
        return _bugPlanter;
    }

    @Override
    public int getTotalCellCount() {
        return _cellCount;
    }

    @Override
    public void setSurroundingBugCount(List<Tile> tiles) {

    }
}
