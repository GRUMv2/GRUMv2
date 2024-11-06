package grymV2.game.grid;

public enum PersonalTileContent implements TileContent {
    AGNOSTIC;

    public PersonalTileContent getDefault() {
        return AGNOSTIC;
    }
}
