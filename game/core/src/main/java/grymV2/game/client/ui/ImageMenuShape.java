package grymV2.game.client.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

abstract public class ImageMenuShape extends MenuShape {

    private Texture texture;
    private Sprite imgSprite;

    public ImageMenuShape(Texture texture, float x, float y, float width, float height) {
        super(x, y, width, height);
        this.texture = texture;
        this.imgSprite = new Sprite(this.texture);
        this.imgSprite.setCenterX(x  + (width / 2));
        this.imgSprite.setCenterY(y  + (height / 2));
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
        this.imgSprite.setTexture(this.texture);
    }

    public Texture getTexture() {
        return texture;
    }

    public Sprite getSprite() {
        return imgSprite;
    }
}
