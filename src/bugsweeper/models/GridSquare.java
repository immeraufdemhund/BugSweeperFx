package bugsweeper.models;

/**
 * Created by snyder on 2015-07-15.
 */
public class GridSquare {
    private boolean _isBug;

    public void uncoverSquare() {
    }

    public void setIsBug() {
        _isBug = true;
    }

    public boolean isBug() {
        return _isBug;
    }

    public void clearIsBug() {
        _isBug = false;
    }
}
