package grymV2.game;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Adam extends Game {
    private Eve gameLoader;
    // private Cain renderer;

    public Adam() {
        // Load settings of some sort, e.g. predefined viewport values
        gameLoader = new Eve();
        // this.renderer = Eve.birth(new Cain)
    }

    /**
     *
     * Springsteen - Darkness on the Edge of Town, track 02
     *
     */
    public void create() {
        // batch
        // font
        // viewport
        // potentially need to define GlobalInputListener here
        // Cain.audio.init, if not handled by Screens
        // Cain.setScreen(MENU)
    }

    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        // batch.dispose()
        // font.dispose()
        super.dispose();
    }

}
