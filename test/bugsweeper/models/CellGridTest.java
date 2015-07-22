package bugsweeper.models;

import bugsweeper.GameCompletedEventListener;
import bugsweeper.SequentialBugPlanter;
import bugsweeper.bugLogic.PlayAreaLayout;
import bugsweeper.watchers.GenericGridSquareWatcher;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by snyder on 2015-07-15.
 * Creates a CellGrid of 20 squares, the first 10 are bugs (mines)
 */
public class CellGridTest implements GameCompletedEventListener {

    boolean gameLostCalled = false;
    boolean gameWonCalled = false;
    private PlayArea _cellGrid;
    private int plantedBugs = 10;
    private int gridSquareCount = 20;
    @BeforeMethod
    public void setUp() throws Exception {
        _cellGrid = new GenericGridSquareWatcher(new SequentialBugPlanter(),gridSquareCount).createPlayArea(plantedBugs);
        _cellGrid.setGameCompletedEventListener(this);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Reset();
    }

    @Test
    public void testWhenBugIsUncoveredGameLostEventIsFired() {
        _cellGrid.uncoverSquare(0);

        assertFalse(gameWonCalled, "you uncovered a bug, game should be lost, not won");
        assertTrue(gameLostCalled, "you uncovered a bug, game should be lost should have been called");
    }

    @Test
    public void testWhenAllMinesAreFlaggedButNoSquaresAreUncoveredGameWonIsNotCalled(){
        for (int i = 0; i < plantedBugs; i++) {
            _cellGrid.setTileFlag(i);
        }

        assertFalse(gameWonCalled, "all squares need to be uncovered to win, not just flagged");
        assertFalse(gameLostCalled, "no squares were uncovered, impossible to loose");
    }

    @Test
    public void testWhenNoMinesAreFlaggedButAllSquaresAreUncoveredGameWonIsCalled(){
        for (int i = plantedBugs; i < gridSquareCount; i++) {
            _cellGrid.uncoverSquare(i);
        }

        assertTrue(gameWonCalled, "all non bug squares were uncovered, game should have been won");
        assertFalse(gameLostCalled, "no squares were uncovered were bugs, impossible to loose");
    }

    @Override
    public void GameWon() {
        gameWonCalled = true;
    }

    @Override
    public void GameLost() {
        gameLostCalled = true;
    }

    private void Reset() {
        gameLostCalled = false;
        gameWonCalled = false;
    }
}