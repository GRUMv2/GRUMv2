package grymV2.game;

import com.badlogic.gdx.Game;

import grymV2.game.server.Abel;
import grymV2.game.client.Cain;
import grymV2.game.config.Settings;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Adam extends Game {

    private Eve loader;
    public Settings settings;
    protected Cain client;
    protected Abel serverThreaded;

    public Adam() {
        settings = new Settings();
        GameLogger.debug(Adam.class, "Creating loader class (Eve)");
        loader = new Eve(this);
    }

    public void create() {
        GameLogger.debug(Adam.class, "LibGDX create");
        this.client.create();
        this.client.setScreen(ScreenStates.MENU);
    }

    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        GameLogger.debug(Adam.class, "LibGDX dispose");
        this.loader.dispose();
        super.dispose();
    }

    public void setState(ScreenStates state) {
        switch (state) {
            case MENU:
                break;
            case GAME:
                serverThreaded.start();
                break;
            case PAUSE:
                //serverThreaded.pause(); TODO
                break;
            case END:
                serverThreaded.endGame();
                break;
            default:
                break;
        }
        this.client.setScreen(state);
    }

    public void exit() {
        GameLogger.debug(Adam.class, "QUIT");
        dispose();
        System.exit(0);
    }
}
