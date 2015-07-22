package bugsweeper;

import bugsweeper.models.PlayArea;
import bugsweeper.models.Tile;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.testng.Assert.fail;

/**
 * Created by snyder on 2015-07-19.
 */
public class GridAssertions {
    private int _expectedCount;

    public static GridAssertions assertGrid(PlayArea grid){
        return new GridAssertions(grid);
    }

    private final PlayArea _grid;
    private Stream<Tile> _gridSquares;

    public GridAssertions(PlayArea grid) {
        _grid = grid;
    }

    public GridAssertions cellIndexes(int...indexes){
        _gridSquares = Arrays.stream(indexes).mapToObj(x -> _grid.get(x));
        return this;
    }

    public void haveSurroundingBugCount(int expectedCount){
        _expectedCount = expectedCount;
        _gridSquares.filter(this::getSquaresWithWrongSurroundingBugCount).forEach(gridSquare -> {
            fail("Not all squares had surrounding bug count of " + expectedCount +
                    "at least one had a count of " + gridSquare.getSurroundBugCount());
        });

    }
    private boolean getSquaresWithWrongSurroundingBugCount(Tile index){
        return index.getSurroundBugCount() != _expectedCount;
    }
    public GridAssertions allCells() {
        _gridSquares = _grid.getWhere(x->true);
        return this;
    }
}
