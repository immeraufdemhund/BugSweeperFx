package bugsweeper.bugLogic;

import bugsweeper.models.PlayArea;
import bugsweeper.models.Tile;

import java.util.ArrayList;
import java.util.List;

/*
    PlayAreaLayout is responsible for creating a new PlayArea, and setting the surrounding bug count
    on each cell.
 */
public abstract class PlayAreaLayout {
    public PlayArea createPlayArea(int bugCount){
        List<Tile> tiles = createTiles(getTotalCellCount());
        getBugPlanter().Plant(tiles, bugCount);
        setSurroundingBugCount(tiles);
        return new PlayArea(tiles);
    }

    private static List<Tile> createTiles(int tileCount){
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < tileCount; i++) {
            tiles.add(new Tile());
        }

        return tiles;
    }

    protected abstract BugPlanter getBugPlanter();

    protected abstract int getTotalCellCount();

    protected abstract void setSurroundingBugCount(List<Tile> tiles);
}
