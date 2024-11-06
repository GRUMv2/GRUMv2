package grymV2.game.grid;

public enum GridLayers {
    BACKGROUND(BackgroundTileContent.class),
    FOREGROUND(ForegroundTileContent.class),
    DYNAMIC(DynamicTileContent.class),
    PERSONAL(PersonalTileContent.class);

    private final Class<? extends TileContent> C;

    private GridLayers(Class<? extends TileContent> C) {
        this.C = C;
    }

    protected Class<? extends TileContent> getContentEnum() {
        return C;
    }
}
