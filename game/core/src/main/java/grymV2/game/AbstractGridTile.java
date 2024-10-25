package grymV2.game;

/**
 * GridTile
 */
abstract public class AbstractGridTile {
    final private byte x;
    final private byte y;

    public AbstractGridTile(byte x, byte y) {
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

    }
}
