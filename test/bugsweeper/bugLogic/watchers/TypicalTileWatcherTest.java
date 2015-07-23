package bugsweeper.bugLogic.watchers;

import bugsweeper.bugLogic.BugPlanter;
import bugsweeper.models.PlayArea;
import bugsweeper.models.Tile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static bugsweeper.GridAssertions.*;

/**
 * Created by snyder on 2015-07-16.
 */
public class TypicalTileWatcherTest {
    PlayArea grid;
    SpecificBugSetterPlanter planter;
    private TypicalGridSquareWatcher watcher;

    @BeforeMethod
    public void setUp() throws Exception {
        planter = new SpecificBugSetterPlanter();
        watcher = new TypicalGridSquareWatcher(3,3){
            @Override
            protected BugPlanter getBugPlanter() {
                return planter;
            }
        };
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testWhenNoBugsAreNextToSquareBugCountIsZero(){
        planter.setIndexesWhereBugsArePlanted();
        grid = watcher.createPlayArea(0);
        assertGrid(grid).allCells().haveSurroundingBugCount(0);
    }

    @Test
    public void testWhenSingleBugIsPlacedSurroundingBugCountIsOne(){
        planter.setIndexesWhereBugsArePlanted(0);
        grid = watcher.createPlayArea(1);
        /*
        B 1 0
        1 1 0
        0 0 0
         */
        assertGrid(grid).cellIndexes(2,5,6,7,8).haveSurroundingBugCount(0);
        assertGrid(grid).cellIndexes(1,3,4).haveSurroundingBugCount(1);

        planter.setIndexesWhereBugsArePlanted(1);
        grid = watcher.createPlayArea(1);
        /*
        1 B 1
        1 1 1
        0 0 0
         */
        assertGrid(grid).cellIndexes(6,7,8).haveSurroundingBugCount(0);
        assertGrid(grid).cellIndexes(2,3,4,5).haveSurroundingBugCount(1);
    }

    private class SpecificBugSetterPlanter implements BugPlanter{
        private int[] _indexes;
        public void setIndexesWhereBugsArePlanted(int...indexes){
            _indexes = indexes;
        }

        @Override
        public void Plant(List<Tile> grid, int bugsToPlant) {
            for (int index : _indexes)
                grid.get(index).setIsBug();
        }
    }
}