package grymV2.game.grid;

public enum BackgroundTileContent implements TileContent {
    AGNOSTIC,
    TERRAIN,
    WATER;

    public BackgroundTileContent getDefault() {
        return AGNOSTIC;
    }
}
