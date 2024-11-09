package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * BackgroundGameObject
 */
abstract public class BackgroundGameObject implements GameObject, Immutable {
    private TextureMap texture;

    public TextureMap getTexture() {
        return texture;
    }

    public void setTexture(TextureMap texture) {
        this.texture = texture;
    }
}
