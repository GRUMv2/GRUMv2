package grymV2.game.client;

import com.badlogic.gdx.ScreenAdapter;

import grymV2.game.Adam;
//import grymV2.game.GameLogger;
import grymV2.game.grid.Grid;
import grymV2.game.ScreenStates;
import grymV2.game.client.input.GlobalInputListener;
import grymV2.game.client.input.MenuInputHandler;
import grymV2.game.client.input.PauseInputHandler;
import grymV2.game.client.input.EndInputHandler;
import grymV2.game.client.input.GameInputHandler;

/**
 *
 *  Cain - ScreenManager
 *
 */
public class Cain {
    final Adam game;
    final Grid grid;
    private GlobalInputListener input;

    private ScreenAdapter activeScreen;

    public Cain(Adam game, Grid grid) {
        this.game = game;
        this.grid = grid;
        this.activeScreen = null;
    }

    public void create() {
        this.input = new GlobalInputListener(this);
    };

    public void setScreen(ScreenStates screen) {
        switch (screen) {
            case MENU:
                this.activeScreen = new CainsLeftEye(this, grid);
                this.input.setHandler(new MenuInputHandler((CainsLeftEye) this.activeScreen));
                this.game.setScreen(this.activeScreen);
                //GameLogger.debug(Cain.class, "setScreen MENU");
                break;

            case GAME:
                // Cain only ever acts upon the game state supplied by Grid and Abel,
                // and does not maintain any frame-to-frame logic, so it
                // should not be detrimental to always create a brand new screen
                // here despite both start and resume events being handled the same
                this.activeScreen = new CainsLeftFoot(this, grid);
                this.input.setHandler(new GameInputHandler((CainsLeftFoot) this.activeScreen));
                this.game.setScreen(this.activeScreen);
                //GameLogger.debug(Cain.class, "setScreen GAME");
                break;

            case PAUSE:
                this.activeScreen = new CainsLeftKnee(this, grid);
                this.input.setHandler(new PauseInputHandler((CainsLeftKnee) this.activeScreen));
                this.game.setScreen(this.activeScreen);
                //GameLogger.debug(Cain.class, "setScreen PAUSE");
                break;

            case END:
                this.activeScreen = new CainsLeftHand(this, grid);
                this.input.setHandler(new EndInputHandler((CainsLeftHand) this.activeScreen));
                this.game.setScreen(this.activeScreen);
                //GameLogger.debug(Cain.class, "setScreen END");
                break;

            default:
                break;
        }
    }

    public void handleInput() {
        this.input.handle();
    }

    public void pause() {
        this.game.setState(ScreenStates.PAUSE);
    }

    public void startGame() {
        this.game.setState(ScreenStates.GAME);
        this.game.serverThreaded.startGame();
    }

    public void endGame() {
        this.AmIMyBrothersKeeper();
    }

    private void AmIMyBrothersKeeper() {
        this.game.setState(ScreenStates.END);
    }

    public void quitGame() {
        //GameLogger.debug(Cain.class, "QUIT");
        this.game.exit();
    }

    public void resume() {
        this.game.setState(ScreenStates.GAME);
    }
}
