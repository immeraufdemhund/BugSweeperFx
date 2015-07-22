package bugsweeper.models;

import bugsweeper.GameCompletedEventListener;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by snyder on 2015-07-15.
 */
public class PlayArea {
    private final List<Tile> _cells;

    private GameCompletedEventListener gameCompletedEventListener;

    public PlayArea(List<Tile> cells) {
        _cells = Collections.unmodifiableList(cells);
    }

    public void setGameCompletedEventListener(GameCompletedEventListener gameCompletedEventListener) {
        this.gameCompletedEventListener = gameCompletedEventListener;
    }

    public void uncoverSquare(int index) {
        Tile cell = _cells.get(index);
        cell.uncoverSquare();
        if(cell.isBug())
            gameCompletedEventListener.GameLost();

        if(allMatch(gridSquare -> gridSquare.isUncovered(),
                gridSquare -> !gridSquare.isBug())){
            gameCompletedEventListener.GameWon();
        }
    }

    public Stream<Tile> getWhere(Predicate<Tile> filter){
        return _cells.stream().filter(filter);
    }

    public void setTileFlag(int squareIndex) {
        _cells.get(squareIndex).setIsFlagged();
    }

    /**
     * Checks all Tiles against a given gondition
     * @param allmatch the given condition to check all Tiles
     * @param filter *NULLABLE* if null, all tiles assumed.
     * @return true if all filtered elements match the given conditions, false otherwise
     */
    private boolean allMatch(Predicate<Tile> allmatch, Predicate<Tile> filter) {
        if(filter == null) filter = x->true;
        return _cells.stream().filter(filter).allMatch(allmatch);
    }

    public Tile get(int index) {
        return _cells.get(index);
    }
}
