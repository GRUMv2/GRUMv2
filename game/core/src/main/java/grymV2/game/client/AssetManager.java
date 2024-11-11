package grymV2.game.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * AssetManager
 */
public class AssetManager {
    // Originally planned to be far more complex
    public AssetManager() {
    }

    public Sprite getSprite(String texture) {
        Texture t = new Texture(texture);
        Sprite s = new Sprite(t);
        return s;
    }
}
