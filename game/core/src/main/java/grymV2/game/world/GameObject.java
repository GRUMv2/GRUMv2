package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * GameObject
 */
public interface GameObject {
    public TextureMap getTexture();
    public void setTexture(TextureMap asset);
}
