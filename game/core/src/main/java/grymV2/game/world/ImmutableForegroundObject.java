package grymV2.game.world;

import grymV2.game.config.TextureMap;

abstract class ImmutableForegroundObject extends ForegroundGameObject implements Immutable {
    public ImmutableForegroundObject(TextureMap texture) {
        super(texture);
    }
}
