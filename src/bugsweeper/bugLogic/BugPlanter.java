package bugsweeper.bugLogic;

import bugsweeper.models.GridSquare;

import java.util.List;

/**
 * Created by snyder on 2015-07-15.
 */
public interface BugPlanter {
    void Plant(List<GridSquare> grid, int bugsToPlant);
}
