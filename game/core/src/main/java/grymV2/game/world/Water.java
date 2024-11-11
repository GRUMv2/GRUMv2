package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * Water
 */
abstract public class Water extends BackgroundGameObject {
    public Water(TextureMap texture) {
        super(texture);
    }
    final static private boolean hasDucks = true;
    final static private void ducks() {
        if (!hasDucks) {
            System.err.println("No ducks.");
            System.exit(2);
        }
    }
}
