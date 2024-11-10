package grymV2.game.client.ui;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * TextButton
 */
public class TextButton extends TextMenuShape implements Button {

    private Color altColor;
    private boolean active;

    public TextButton(BitmapFont font) {
        this(font, 1, 1, 1, 1);
    }

    public TextButton(BitmapFont font, float x, float y, float width, float height) {
        super(font, x, y, width, height);
        this.active = false;
        this.altColor = Color.RED;
    }

    public void draw(ShapeRenderer shape, SpriteBatch batch, Camera camera) {
        this.centreText();
        shape.setProjectionMatrix(camera.combined);
        shape.begin(ShapeType.Filled);
        shape.setColor(this.active ? this.getAltColor() : this.getColor());
        shape.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        shape.end();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        this.getFont().setColor(this.active ? this.getColor() : this.getTextColor());
        this.getFont().draw(batch, this.getGlyph(), this.getTextX(), this.getTextY());
        batch.end();
    }

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
