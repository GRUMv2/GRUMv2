package grymV2.game.grid;

/**
 * TileLayer
 */
public class TileLayer {
    private final GridLayers layer;
    private Enum<? extends TileContent> north;
    private Enum<? extends TileContent> east;
    private Enum<? extends TileContent> south;
    private Enum<? extends TileContent> west;
    private Enum<? extends TileContent> content;

    public enum Direction { SELF, NORTH, EAST, SOUTH, WEST }

    public TileLayer(GridLayers layer) {
        this.layer = layer;
    }

    public GridLayers getLayer() {
        return layer;
    }

    public Boolean set(Enum<? extends TileContent> e, Direction dir) {
        if (e.getClass() != this.layer.getContentEnum()) {
            return false;
        }
        switch (dir) {
            case SELF:
                this.content = e;
                break;
            case NORTH:
                this.north = e;
                break;
            case EAST:
                this.east = e;
                break;
            case SOUTH:
                this.south = e;
                break;
            case WEST:
                this.west = e;
                break;
            default:
                break;
        }
        return true;
    }

    public <E extends Enum<? extends TileContent>> Boolean setAll(E self, E north, E east, E south, E west) {
        if (! set(self, Direction.SELF)) {
            return false;
        } else if (! set(east, Direction.NORTH)) {
            return false;
        } else if (! set(east, Direction.EAST)) {
            return false;
        } else if (! set(south, Direction.SOUTH)) {
            return false;
        } else if (! set(west, Direction.WEST)) {
            return false;
        }
        return true;
    }

    public Boolean setAll(Enum<? extends TileContent> content) {
        return setAll(content,content, content, content, content);
    }

    public Boolean setNorth(Enum<? extends TileContent> e) {
        return set(e, Direction.NORTH);
    }

    public Enum<? extends TileContent> getNorth() {
        return north;
    }

    public Boolean setEast(Enum<? extends TileContent> e) {
        return set(e, Direction.EAST);
    }

    public Enum<? extends TileContent> getEast() {
        return east;
    }

    public Boolean setSouth(Enum<? extends TileContent> e) {
        return set(e, Direction.SOUTH);
    }

    public Enum<? extends TileContent> getSouth() {
        return south;
    }

    public Boolean setWest(Enum<? extends TileContent> e) {
        return set(e, Direction.WEST);
    }

    public Enum<? extends TileContent> getWest() {
        return west;
    }

    public Enum<? extends TileContent> getContent() {
        return content;
    }

    public Boolean setContent(Enum<? extends TileContent> e) {
        return set(e, Direction.SELF);
    }
}
