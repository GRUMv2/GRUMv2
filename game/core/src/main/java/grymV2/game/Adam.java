package grymV2.game;

import com.badlogic.gdx.Game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Adam extends Game {
    private static final Logger logger = LogManager.getLogger(Adam.class);

    private Eve gameLoader;
    public Settings settings;
    // private Cain client;

    public Adam() {
        settings = new Settings();

        logger.debug("Creating loader class (Eve)");
        gameLoader = new Eve(this, settings);
    }

    /**
     *
     * Springsteen - Darkness on the Edge of Town, track 02
     *
     */
    public void create() {
        logger.debug("LibGDX create");

        // try pass everything to Cain; Adam's libGDX is just a puppet wrapper
        // this.client.create();
    }

    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        logger.debug("LibGDX dispose");
        this.gameLoader.dispose();
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
