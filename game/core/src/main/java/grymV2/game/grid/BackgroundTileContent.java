package grymV2.game.grid;

public enum BackgroundTileContent implements TileContent {
    AGNOSTIC,
    TERRAIN,
    WATER,
    HILL;

    public BackgroundTileContent getDefault() {
        return AGNOSTIC;
    }
}
