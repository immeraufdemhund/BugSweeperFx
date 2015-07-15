package bugsweeper.models;

import bugsweeper.GameCompletedEventListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-07-15.
 */
public class CellGridTest {

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testWhenBugIsUncoveredGameLostEventIsFired(){
        GameCompletedEventListenerSpy listenerSpy = new GameCompletedEventListenerSpy();
        CellGrid grid = new CellGrid(1);
        grid.setBugCount(1);
        grid.setGameCompletedEventListener(listenerSpy);
        grid.uncoverSquare(0);

        assertFalse(listenerSpy.gameWonCalled, "you uncovered a bug, game should be lost, not won");
        assertTrue(listenerSpy.gameLostCalled, "you uncovered a bug, game should be lost should have been called");
    }

    private class GameCompletedEventListenerSpy implements GameCompletedEventListener{
        public boolean gameLostCalled = false;
        public boolean gameWonCalled = false;
        @Override
        public void GameWon() {
            gameWonCalled = true;
        }

        @Override
        public void GameLost() {
            gameLostCalled = true;
        }
    }
}