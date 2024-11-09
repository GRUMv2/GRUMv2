package grymV2.game.client.ui;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Camera;

/**
 * UIElement
 */
public interface UIElement {
    public float getX();
    public float getY();
    public float getWidth();
    public float getHeight();
    public void setX(float x);
    public void setY(float y);
    public void setWidth(float width);
    public void setHeight(float height);
    public void draw(ShapeRenderer shape, SpriteBatch batch, Camera camera);
}
