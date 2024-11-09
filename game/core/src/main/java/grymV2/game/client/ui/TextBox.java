package grymV2.game.client.ui;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * TextBox
 */
public class TextBox extends TextMenuShape {

    public TextBox(BitmapFont font) {
        super(font, 1, 1, 1, 1);
    }

    public TextBox(BitmapFont font, float x, float y, float width, float height) {
        super(font, x, y, width, height);
    }

    @Override
    public void draw(ShapeRenderer shape, SpriteBatch batch, Camera camera) {
        this.centreText();
        shape.setProjectionMatrix(camera.combined);
        shape.begin(ShapeType.Filled);
        shape.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        shape.setColor(this.getColor());
        shape.end();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        this.getFont().setColor(this.getTextColor());
        this.getFont().draw(batch, this.getGlyph(), this.getTextX(), this.getTextY());
        batch.end();
    }
}
