package grymV2.game.client;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import grymV2.game.Adam;
import grymV2.game.Grid;
import grymV2.game.ScreenStates;
import grymV2.game.client.input.GlobalInputListener;

/**
 *
 *  Cain - ScreenManager
 *
 */
public class Cain {
    final Adam game;
    final Grid grid;
    final GlobalInputListener input;
    protected SpriteBatch batch;
    protected BitmapFont font;
    protected BitmapFontCache fontcache;
    protected FitViewport viewport;

    public Cain(Adam game, Grid grid) {
        this.game = game;
        this.grid = grid;
        this.input = new GlobalInputListener();
        this.viewport = new FitViewport((float) this.grid.getX() / 2, (float) this.grid.getY() / 2);
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.fontcache = new BitmapFontCache(this.font);
    }

    public void setScreen(ScreenStates screen) {
        switch (screen) {
            case MENU:
                this.game.setScreen(new CainsLeftEye(this, grid));
                break;

            case GAME:
                this.game.setScreen(new CainsLeftFoot(this, grid));
                break;

            case PAUSE:
                this.game.setScreen(new CainsLeftKnee(this, grid));
                break;

            case END:
                this.game.setScreen(new CainsLeftHand(this, grid));
                break;

            default:
                break;
        }
    }

    protected void pause() {
        this.game.setState(ScreenStates.PAUSE);
    }

}
