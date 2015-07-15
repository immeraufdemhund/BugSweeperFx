package bugsweeper.bugLogic.planters;

import bugsweeper.models.GridSquare;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by snyder on 2015-07-15.
 */
public class RandomBugPlanterTest {
    private static final RandomBugPlanter planter = new RandomBugPlanter();

    private static void assertEachSquareGetsSetAsBug(int squareCount) {
        int[] indexCount = new int[squareCount];

        plant_X_Bugs_Y_Times_thenCountIsBugIndex(squareCount, 10 * squareCount, indexCount);
        for (int i = 0; i < squareCount; i++) {
            assertTrue(indexCount[i] > 0, "index " + i + " was never set");
        }
    }

    private static void plant_X_Bugs_Y_Times_thenCountIsBugIndex(int squareCount, int times, int[] indexCount) {
        for (int i = 0; i < times; i++) {
            List<GridSquare> grid = generateGridSquares(squareCount);
            planter.Plant(grid, 1);
            countIsBug(grid, indexCount);
        }
    }

    private static List<GridSquare> generateGridSquares(int generateCount) {
        List<GridSquare> grid = new ArrayList<>(generateCount);
        for (int i = 0; i < generateCount; i++) {
            grid.add(new GridSquare());
        }

        return grid;
    }

    private static void countIsBug(List<GridSquare> grid, int[] indexCount) {
        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i).isBug()) {
                indexCount[i]++;
            }
        }
    }

    @Test
    public void testRandomSquaresGetIsBugSet() throws Exception {
        assertEachSquareGetsSetAsBug(1);
        assertEachSquareGetsSetAsBug(2);
        assertEachSquareGetsSetAsBug(10);
    }

}