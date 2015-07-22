package bugsweeper.models;

/**
 * Created by snyder on 2015-07-15.
 */
public class Tile {
    private boolean _isBug;
    private boolean _isFlagged;
    private boolean _uncovered;
    private int _surroundingBugCount;

    public void uncoverSquare() {
        _uncovered = true;
    }

    public void setIsBug() {
        _isBug = true;
    }

    public boolean isBug() {
        return _isBug;
    }

    public void reset() {
        _isBug = false;
        _surroundingBugCount = 0;
        _isFlagged = false;
    }

    public void setIsFlagged() {
        _isFlagged = true;
    }

    public boolean isFlagged() {
        return _isFlagged;
    }

    public boolean isUncovered() {
        return _uncovered;
    }

    public int getSurroundBugCount() {
        return _surroundingBugCount;
    }

    public void increaseSurroundingBugCount() {
        _surroundingBugCount++;
    }
}
