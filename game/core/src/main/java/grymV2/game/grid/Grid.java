package grymV2.game.grid;

import java.util.ArrayList;

import grymV2.game.config.MapSizes;
import grymV2.game.world.BackgroundGameObject;
import grymV2.game.world.Building;
import grymV2.game.world.ForegroundGameObject;
import grymV2.game.world.GameObject;
import grymV2.game.world.Lake;
import grymV2.game.world.Placeable;
import grymV2.game.world.Road;

public class Grid {
    // If the user is defining grid sizes greater than 127 in a given direction
    //  the interface is beyond unplayable already. The limit is probably ~50x28.
    final private MapSizes size;
    final private byte x;
    final private byte y;
    final ArrayList<ArrayList<Tile>> grid;

    public Grid(MapSizes size) {
        this.size = size;
        this.x = this.size.getX();
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

    public boolean isPlaceable(byte x, byte y) {
        Tile t = this.getTile(x, y);
        if (t.isDevelopable() && t.isEmpty(GridLayers.FOREGROUND)) {
            return true;
        }
        return false;
    }

    public boolean isPlaceable(Tile t) {
        byte x = t.getCoordX();
        byte y = t.getCoordY();
        if (this.isTile(x, y)) {
            return this.isPlaceable(x, y);
        }
        return false;
    }

    public boolean isEdge(byte x, byte y) {
        if (x == 0 || y == 0 || x == this.x || y == this.y) {
            return true;
        }
        return false;
    }

    public boolean isTile(byte x, byte y) {
        if (x >= 0 && x <= this.x && y >= 0 && y <= this.y) {
            return true;
        }
        return  false;
    }

    public boolean updateTile(byte x, byte y, GameObject newContent, GridLayers layer) {
        Tile t = this.getTile(x, y);
        switch (layer) {
            case BACKGROUND:
                if (!(newContent instanceof BackgroundGameObject)) {
                    return false;
                }
                // Currently sort of redundant because all BACKGROUND tiles
                // are by default immutable.
                if (!t.isMutable(layer)) {
                    return false;
                }
                break;

            case FOREGROUND:
                if (!(newContent instanceof ForegroundGameObject)) {
                    return false;
                }
                if (t.isEmpty(GridLayers.BACKGROUND)) {
                    // Foreground objects require a background tile
                    return false;
                } else if (!t.isMutable(layer)) {
                    return false;
                } else if (t.getLayer(layer) instanceof Building) {
                    // Doesn't allow for meteors
                    return false;
                } else if (newContent instanceof Placeable && ! this.isPlaceable(t)) {
                    return false;
                }
                if (newContent instanceof Road && t.getLayer(GridLayers.BACKGROUND) instanceof Lake) {
                    return false;
                }
                break;

            case DYNAMIC:
            case PERSONAL:
            default:
                return false;
        }

        //if (newContent instanceof Road && t.getLayer(GridLayers.BACKGROUND) instanceof River) {
        //    newContent = (Road) newContent;
        //    newContent.setTexture(TextureMap.BRIDGE);
        //}
        t.setLayer(layer, newContent);
        return true;
    }
}
