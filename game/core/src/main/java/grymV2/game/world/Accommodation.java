package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * Accommodation
 */
public class Accommodation extends Building {
    // TODO: I pulled 200 out of thin air
    // It should be some part of the actual object logic or serverside
    private final int capacity = 200;

    public Accommodation(TextureMap texture) {
        super(TextureMap.ACCOMMODATION, "Accommodation", "Enough living space for 200 students.");
    }
}
