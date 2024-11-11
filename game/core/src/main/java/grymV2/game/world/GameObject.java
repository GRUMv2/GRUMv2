package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * GameObject
 */
abstract public class GameObject implements IGameObject {
    private TextureMap texture;

    public GameObject(TextureMap texture) {
        this.setTexture(texture);
    }

    public TextureMap getTexture() {
        return texture;
    }

    public void setTexture(TextureMap texture) {
        this.texture = texture;
    }

}
