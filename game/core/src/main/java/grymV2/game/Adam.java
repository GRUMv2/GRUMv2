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

    /**
     *
     * Springsteen - Darkness on the Edge of Town, track 02
     *
     */
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

    /**
     * public void renderEvent(RenderEvent event)
     *     case $event in
     *         PAUSE)
     *             this.serverThread.server.gameEvent($event)
     *             this.client.setScreen(PAUSE)
     *             ...
     *             ;;
     *         RESUME)
     *             this.serverThread.server.gameEvent($event)
     *             this.client.setScreen(GAME)
     *             ...
     *             ;;
     *         OHSHIT)
     *             this.serverThread.server.gameEvent(CRASH)
     *             self.dispose()
     *             ;;
     *         ...
     *         etc
     *     esac
     *
     *
     */
}
