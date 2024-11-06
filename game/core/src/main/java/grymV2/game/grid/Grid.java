package grymV2.game.grid;

import java.util.ArrayList;

public class Grid {
    // If the user is defining grid sizes greater than 127 in a given direction
    //  the interface is beyond unplayable already. The limit is probably ~50x28.
    final private MapSizes size;
    final private byte x;
    final private byte y;
    final ArrayList<ArrayList<Tile>> grid;

    public Grid(MapSizes size) {
        this.size = size;
        this.x = this.size.getX(); // bit redundant
        this.y = this.size.getY();
        this.grid = gridInit(size);
    }

    private ArrayList<ArrayList<Tile>> gridInit(MapSizes size) {
        ArrayList<ArrayList<Tile>> newGrid = new ArrayList<>(size.getX());
        for (byte i = 0; i < size.getX(); i++) {
            newGrid.add(new ArrayList<Tile>());
            for (byte j = 0; j < size.getY(); j++) {
                newGrid.get(i).add(new Tile(i, j));
            }
        }

        return newGrid;
    }

    public MapSizes getSize() {
        return size;
    }

    public byte getDimensionX() {
        return x;
    }

    public byte getDimensionY() {
        return y;
    }

    public Tile getTile(byte x, byte y) {
        return this.grid.get(x).get(y);
    }

    public Boolean isPlaceable(byte x, byte y) {
        if (this.grid.get(x).get(y)
                .getLayer(GridLayers.FOREGROUND)
                .getContent() == ForegroundTileContent.AGNOSTIC) {
            return true;
        }
        return false;
    }

    public Boolean isEdge(byte x, byte y) {
        if (x == 0 || y == 0 || x == this.x || y == this.y) {
            return true;
        }
        return false;
    }
}
