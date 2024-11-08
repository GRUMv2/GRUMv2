package grymV2.game.client;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import grymV2.game.grid.Grid;

public abstract class AbstractGameScreen extends ScreenAdapter {

    final Cain manager;
    final Grid grid;
    final SpriteBatch batch;
    final BitmapFont font;
    final BitmapFontCache fontcache;
    int ID; // TODO I can't remember what this was for

    public AbstractGameScreen(Cain manager, Grid grid) {
        this.manager = manager;
        this.grid = grid;
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.fontcache = new BitmapFontCache(font);
    }

    public void render(float delta) {
        input();
        logic();
        draw();
    }

    abstract public void input();
    abstract public void logic();
    abstract public void draw();

    @Override
    public void resize(int width, int height) {
        this.manager.viewport.update(width, height, true);
    }
}
