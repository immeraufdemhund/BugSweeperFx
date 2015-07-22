package bugsweeper.bugLogic;

import bugsweeper.models.Tile;

import java.util.List;

/**
 * Created by snyder on 2015-07-15.
 */
public interface BugPlanter {
    void Plant(List<Tile> grid, int bugsToPlant);
}
