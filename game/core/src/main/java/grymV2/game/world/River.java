package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * River
 */
public class River extends Water implements Rotatable {
    private int orientation;

    public River(TextureMap texture) {
        super(texture);
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
