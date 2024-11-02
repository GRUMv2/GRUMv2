package grymV2.game.grid;

//import grymV2.game.client.RenderStates;       // XXX: implement

// XXX: placeholder RenderStates. Import from client when that's merged
enum RenderStates {
    BACKGROUND,
    FOREGROUND,
    DYNAMIC,
    PERSONAL
}

public class Grid {
    // If the user is defining grid sizes greater than 127 in a given direction
    //  the interface is beyond unplayable already. The limit is probably ~50x28.
    final private MapSizes size;
    final private byte x;
    final private byte y;


    public Grid(MapSizes size) {
        this.size = size;
        this.x = this.size.getX(); // bit redundant
        this.y = this.size.getY();
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

    public GridLayer getRenderGrid(RenderStates state) {
        // TODO: Is it worth instantiating and passing to Cain a clone rather than the master <state>Grid?
        // Grid stateGrid = new Grid(this.getSize());
        // ...

        switch (state) {
            case BACKGROUND:
                break;

            case FOREGROUND:
                break;

            case DYNAMIC:
                break;

            case PERSONAL:
                break;

            default:
                break;
        }

        // XXX: UNFINISHED
        return new GridLayer(); // (leave me alone) XXX
    }

    public void loadMap( /* Eve pass a thing */ ) {
        // TODO: loadZmap

        //for t in loadData; do       // TODO remember how to for loop in java
        //    GridTile tile = map.tiles.get(Coord<t.x, t.y>)
        //    tile.setTile(t.data)
        //    map.updateLayers(tile)
        //fi
    }

    private void updateLayers(GridTile tile) {
        // TODO
    }

}
