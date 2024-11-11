package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * Building
 */
public class Building extends PlaceableForegroundObject {
    private String name;
    private String description;

    public Building(TextureMap texture, String name, String description) {
        super(texture);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
