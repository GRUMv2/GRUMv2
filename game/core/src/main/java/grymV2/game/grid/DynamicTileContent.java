package grymV2.game.grid;

public enum DynamicTileContent implements TileContent {
    AGNOSTIC;

    public DynamicTileContent getDefault() {
        return AGNOSTIC;
    }

}
