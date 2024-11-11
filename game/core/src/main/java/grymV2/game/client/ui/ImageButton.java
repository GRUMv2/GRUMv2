package grymV2.game.client.ui;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * ImageButton
 */
public class ImageButton extends ImageMenuShape implements Button {

    private boolean active;
    private Color altColor;

    public ImageButton(Texture texture) {
        this(texture, 1, 1, 1, 1);
    }

    public ImageButton(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        this.active = false;
        this.altColor = Color.RED;
    }

    @Override
    public void draw(ShapeRenderer shape, SpriteBatch batch, Camera camera) {
        shape.setProjectionMatrix(camera.combined);
        shape.begin(ShapeType.Filled);
        shape.setColor(this.active ? this.getAltColor() : this.getColor());
        shape.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        shape.end();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        this.getSprite().setSize(this.getWidth(), this.getHeight());
        this.getSprite().setCenterX(this.getX() + (this.getWidth() / 2));
        this.getSprite().setCenterY(this.getY() + (this.getHeight() / 2));
        this.getSprite().draw(batch);
        batch.end();
    }

    @Override
    public boolean hover(float x, float y) {
        if (!this.contains(x, y)) {
            this.active = false;
            return false;
        }
        this.active = true;
        return true;
    }

    public Color getAltColor() {
        return altColor;
    }

    public void setAltColor(Color altColor) {
        this.altColor = altColor;
    }
}
