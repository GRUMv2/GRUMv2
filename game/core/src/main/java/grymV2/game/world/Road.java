package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * Road
 */
public class Road extends ImmutableForegroundObject implements Rotatable {
    private int orientation;
    public Road(TextureMap texture) {
        super(texture);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
