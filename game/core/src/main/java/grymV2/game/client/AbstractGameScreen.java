package grymV2.game.client;

import java.util.EnumMap;

import com.badlogic.gdx.Screen;

import grymV2.game.Grid;

public abstract class AbstractGameScreen implements Screen {

    final Cain manager;
    final EnumMap<RenderStates, Grid> grids;
    int ID;

    public AbstractGameScreen(Cain manager, EnumMap<RenderStates, Grid> grids) {
        this.manager = manager;
        this.grids = grids;
    }

    public void render(float delta) {
        //user_input();
        render_background();
        render_foreground();
        render_dynamic();
        render_personal();
    }

    abstract public void render_background();
    abstract public void render_foreground();
    abstract public void render_dynamic();
    abstract public void render_personal();

    @Override
    public void resize(int width, int height) {
        manager.game.viewport.update(width, height, true);
    }


    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }
}
