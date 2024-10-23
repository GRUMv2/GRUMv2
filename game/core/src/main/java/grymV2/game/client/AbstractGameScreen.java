package grymV2.game.client;

import com.badlogic.gdx.Screen;

import grymV2.game.Grid;

public abstract class AbstractGameScreen implements Screen {

    final Cain manager;
    final Grid grid;
    int ID;

    public AbstractGameScreen(Cain manager, Grid grid) {
        this.manager = manager;
        this.grid = grid;
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
