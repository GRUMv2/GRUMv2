package grymV2.game.grid;

import grymV2.game.client.RenderStates; // XXX

/**
 * GridTile
 */
public class GridTile {
    final private byte x;
    final private byte y;

    public GridTile(byte x, byte y) {
        this.x = x;
        this.y = y;
    }

    public byte getCoordX() {
        return x;
    }

    public byte getCoordY() {
        return y;
    }

    public void setTile() {
        // TODO
    }
}
