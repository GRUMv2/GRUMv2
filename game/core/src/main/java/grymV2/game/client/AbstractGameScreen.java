package grymV2.game.client;

import com.badlogic.gdx.ScreenAdapter;

import grymV2.game.grid.Grid;

public abstract class AbstractGameScreen extends ScreenAdapter {

    final Cain manager;
    final Grid grid;
    int ID; // TODO I can't remember what this was for

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
        this.manager.viewport.update(width, height, true);
    }
}
