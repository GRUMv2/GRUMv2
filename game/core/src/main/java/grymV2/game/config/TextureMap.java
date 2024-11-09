package grymV2.game.config;

public enum TextureMap {
    // Background
    TERRAIN("terrain.png"),
    LAKE("lake.png"),
    RIVER_STRAIGHT("river_straight.png"),
    RIVER_CORNER("river_corner.png"),

    // Foreground (Map)
    ROAD_STRAIGHT("road_straight.png"),
    ROAD_CORNER("road_corner.png"),
    ROAD_END("road_end.png"),
    ROAD_CROSSROADS("road_crossroads.png"),
    ROAD_TJUNCTION("road_tjunction.png"),

    // Foreground (Buildings)
    ACCOMMODATION("accommodation.png"),
    CANTEEN("canteen.png");

    private String texture;

    private TextureMap(String texture) {
        this.texture = texture;
    }

    public String getTexture() {
        return this.texture;
    }
}
