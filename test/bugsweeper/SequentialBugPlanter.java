package bugsweeper;

import bugsweeper.bugLogic.BugPlanter;
import bugsweeper.models.Tile;

import java.util.List;

/**
 * Created by snyder on 2015-07-22.
 */
public class SequentialBugPlanter implements BugPlanter {

    public SequentialBugPlanter() {

    }

    @Override
    public void Plant(List<Tile> grid, int bugsToPlant) {
        for (int i = 0; i < bugsToPlant; i++) {
            grid.get(i).setIsBug();
        }
    }
}
