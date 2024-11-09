package grymV2.game.client;

import grymV2.game.Adam;
import grymV2.game.GameLogger;
import grymV2.game.grid.Grid;
import grymV2.game.ScreenStates;
import grymV2.game.client.input.GlobalInputListener;
import grymV2.game.client.input.MenuInputHandler;



/**
 *
 *  Cain - ScreenManager
 *
 */
public class Cain {
    final Adam game;
    final Grid grid;
    private GlobalInputListener input;

    private AbstractGameScreen activeScreen;

    public Cain(Adam game, Grid grid) {
        this.game = game;
        this.grid = grid;
    }

    public void create() {
        this.input = new GlobalInputListener();
    };

    public void setScreen(ScreenStates screen) {
        switch (screen) {
            case MENU:
                this.activeScreen = new CainsLeftEye(this, grid);
                this.input.setHandler(new MenuInputHandler((CainsLeftEye) this.activeScreen));
                this.game.setScreen(this.activeScreen);
                GameLogger.debug(Cain.class, "setScreen MENU");
                break;

            case GAME:
                this.activeScreen = new CainsLeftFoot(this, grid);
                this.game.setScreen(this.activeScreen);
                GameLogger.debug(Cain.class, "setScreen GAME");
                break;

            case PAUSE:
                this.activeScreen = new CainsLeftKnee(this, grid);
                this.game.setScreen(this.activeScreen);
                GameLogger.debug(Cain.class, "setScreen PAUSE");
                break;

            case END:
                this.activeScreen = new CainsLeftHand(this, grid);
                this.game.setScreen(this.activeScreen);
                GameLogger.debug(Cain.class, "setScreen END");
                break;

            default:
                break;
        }
    }

    public void handleInput() {
        this.input.handle();
    }

    //protected void pause() {
    //    this.game.setState(ScreenStates.PAUSE);
    //}

}
