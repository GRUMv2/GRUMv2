package grymV2.game.client.ui;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * TextMenuShape
 */
abstract public class TextMenuShape extends MenuShape {

    private String text;
    private float textX;
    private float textY;
    private Color textColor;
    private BitmapFont font;
    private GlyphLayout glyph;

    public TextMenuShape(BitmapFont font, float x, float y, float width, float height) {
        super(x, y, width, height);
        this.textColor = Color.BLACK;
        this.font = font;
        this.font.setColor(this.textColor);
        this.text = "";
        this.glyph = new GlyphLayout(this.font, "");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.glyph.setText(font, text);
        this.text = text;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
        this.font.setColor(textColor);
    }

    public void centreText() {
        setTextX(this.getX() + ((this.getWidth() - this.glyph.width) / 2));
        setTextY(this.getY() + ((this.getHeight() + this.glyph.height) / 2));
    }

    public float getTextX() {
        return textX;
    }

    public float getTextY() {
        return textY;
    }

    public void setTextX(float textX) {
        this.textX = textX;
    }

    public void setTextY(float textY) {
        this.textY = textY;
    }

    public BitmapFont getFont() {
        return font;
    }

    public GlyphLayout getGlyph() {
        return glyph;
    }

    abstract public void draw(ShapeRenderer shape, SpriteBatch batch, Camera camera);
}
