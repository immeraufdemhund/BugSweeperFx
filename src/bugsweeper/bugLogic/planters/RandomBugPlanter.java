package bugsweeper.bugLogic.planters;

import bugsweeper.bugLogic.BugPlanter;
import bugsweeper.models.GridSquare;
import bugsweeper.utilities.ShuffleUtil;

import java.util.List;


/**
 * Created by snyder on 2015-07-15.
 */
public class RandomBugPlanter implements BugPlanter {

    @Override
    public void Plant(List<GridSquare> grid, int bugsToPlant) {

        for (int i = 0; i < bugsToPlant; i++) {
            grid.get(i).setIsBug();
        }
        ShuffleUtil.shuffle(grid);
    }
}
