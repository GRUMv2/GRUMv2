package grymV2.game.grid;

public enum ForegroundTileContent implements TileContent {
    AGNOSTIC,
    ROAD,
    BUILDING;

    public ForegroundTileContent getDefault() {
        return AGNOSTIC;
    }
}
