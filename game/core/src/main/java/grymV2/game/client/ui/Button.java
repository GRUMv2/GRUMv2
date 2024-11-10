package grymV2.game.client.ui;

import com.badlogic.gdx.graphics.Color;

/**
 * Button
 */
public interface Button extends UIElement {

    public boolean hover(float x, float y);
    public Color getAltColor();
    public void setAltColor(Color altColor);
    default boolean contains(float x, float y) {
        if ((x >= this.getX() && x <= getWidth()) || (y >= this.getY() && y <= getHeight())) {
            return true;
        }
        return false;
    }
}
