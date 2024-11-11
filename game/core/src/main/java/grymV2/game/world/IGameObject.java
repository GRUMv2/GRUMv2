package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * GameObject
 */
public interface IGameObject {
    public TextureMap getTexture();
    public void setTexture(TextureMap texture);
}
