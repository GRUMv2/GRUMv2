package grymV2.game.client;

import grymV2.game.Grid;

import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Cain's Left Knee - Pause Screen
 */
public class CainsLeftKnee extends AbstractGameScreen {
    public CainsLeftKnee(Cain manager, Grid grid) {
        super(manager, grid);
    }

    @Override
    public void render_background() {
        ScreenUtils.clear(0, 0, 0, 1);;
    }

    @Override
    public void render_foreground() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render_dynamic() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render_personal() {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        this.manager.pause();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }
}
