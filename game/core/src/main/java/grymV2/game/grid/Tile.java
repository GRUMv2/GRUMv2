package grymV2.game.grid;

import java.util.EnumMap;

import grymV2.game.world.Developable;
import grymV2.game.world.GameObject;
import grymV2.game.world.Mutable;
import grymV2.game.world.Rotatable;

/**
 * Tile
 */
public class Tile {
    final private byte x;
    final private byte y;
    private EnumMap<GridLayers, GameObject> layers;

    public Tile(byte x, byte y) {
        this.x = x;
        this.y = y;
        this.layers = new EnumMap<GridLayers, GameObject>(GridLayers.class);
    }

    public byte getCoordX() {
        return x;
    }

    public byte getCoordY() {
        return y;
    }

    private GameObject tlg(GridLayers layer) {
        return this.layers.get(layer);
    }

    public GameObject getLayer(GridLayers layer) {
        return tlg(layer);
    }

    public void setLayer(GridLayers layer, GameObject content) {
        this.layers.put(layer, content);
    }

    public boolean isDevelopable() {
        return tlg(GridLayers.BACKGROUND) instanceof Developable;
    }

    public boolean isEmpty(GridLayers layer) {
        return tlg(layer) == null;
    }

    public boolean isMutable(GridLayers layer) {
        return tlg(layer) instanceof Mutable;
    }

    public boolean isRotatable(GridLayers layer) {
        return tlg(layer) instanceof Rotatable;
    }

}
