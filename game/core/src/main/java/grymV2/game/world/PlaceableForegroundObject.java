package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * MutableForegroundObject
 */
abstract public class PlaceableForegroundObject extends ForegroundGameObject implements Placeable {
    public PlaceableForegroundObject(TextureMap texture) {
        super(texture);
    }
}
