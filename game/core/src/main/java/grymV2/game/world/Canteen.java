package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * Canteen
 */
public class Canteen extends Building {
    // TODO: I pulled 200 out of thin air
    // It should be some part of the actual object logic or serverside
    private final int capacity = 200;

    public Canteen(TextureMap texture) {
        super(TextureMap.CANTEEN, "Canteen", "A social catering facility for 200 students. Only serves squid.");
    }
}
