package grymV2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import grymV2.*;
import grymV2.game.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Adam extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Abel server;

    public Adam() {
        // Load and start the Server Thread
        server = new Abel();
        server.start();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 140, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
