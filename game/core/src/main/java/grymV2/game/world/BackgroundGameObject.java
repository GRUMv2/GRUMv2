package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * BackgroundGameObject
 */
abstract public class BackgroundGameObject extends GameObject implements Immutable {

    public BackgroundGameObject(TextureMap texture) {
        super(texture);
    }
}
