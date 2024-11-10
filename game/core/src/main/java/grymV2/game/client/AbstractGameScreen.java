package grymV2.game.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import grymV2.game.grid.Grid;

public abstract class AbstractGameScreen extends ScreenAdapter {
    final private int VIEWPORT_WIDTH = 40;
    final private int VIEWPORT_HEIGHT = 40;

    final Cain manager;
    final Grid grid;
    final FitViewport viewport;
    private float delta;
    final SpriteBatch batch;
    final BitmapFont font;
    final ShapeRenderer shapeRenderer;
    int ID; // TODO I can't remember what this was for

    public AbstractGameScreen(Cain manager, Grid grid) {
        this.manager = manager;
        this.grid = grid;
        this.viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.shapeRenderer = new ShapeRenderer();
        this.font.setUseIntegerPositions(false);
        this.font.getData().setScale(this.viewport.getWorldHeight() / Gdx.graphics.getHeight());
        this.delta = 0;
    }

    public void render(float delta) {
        this.delta = delta;
        ScreenUtils.clear(this.manager.game.settings.getUIBackground());
        input();
        logic();
        draw();
    }

    abstract public void input();
    abstract public void logic(); // Not actually used.
    abstract public void draw();

    public float getDelta() {
        return delta;
    }

    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.shapeRenderer.dispose();
        this.font.dispose();
    }
}
