package grymV2.game.grid;

import java.util.EnumMap;

/**
 * Tile
 */
public class Tile {
    final private byte x;
    final private byte y;
    final private EnumMap<GridLayers, TileLayer> layers;

    public Tile(byte x, byte y) {
        this.x = x;
        this.y = y;
        this.layers = new EnumMap<GridLayers, TileLayer>(GridLayers.class);
        // TODO: Literally anything that isn't this
        TileLayer tb = new TileLayer(GridLayers.BACKGROUND);
        TileLayer tf = new TileLayer(GridLayers.FOREGROUND);
        TileLayer td = new TileLayer(GridLayers.DYNAMIC);
        TileLayer tp = new TileLayer(GridLayers.PERSONAL);
        tb.setAll(BackgroundTileContent.AGNOSTIC);
        tf.setAll(ForegroundTileContent.AGNOSTIC);
        td.setAll(DynamicTileContent.AGNOSTIC);
        tp.setAll(PersonalTileContent.AGNOSTIC);
        layers.put(GridLayers.BACKGROUND, tb);
        layers.put(GridLayers.FOREGROUND, tf);
        layers.put(GridLayers.DYNAMIC, td);
        layers.put(GridLayers.PERSONAL, tp);
    }

    public byte getCoordX() {
        return x;
    }

    public byte getCoordY() {
        return y;
    }

    public TileLayer getLayer(GridLayers layer) {
        return this.layers.get(layer);
    }
}
