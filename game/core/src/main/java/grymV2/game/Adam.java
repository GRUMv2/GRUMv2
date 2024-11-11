package grymV2.game;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.badlogic.gdx.Game;

import grymV2.game.server.Abel;
import grymV2.game.client.Cain;
import grymV2.game.config.Settings;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Adam extends Game {

    private Eve loader;
    public Settings settings;
    protected Cain client;
    public Abel serverThreaded;

    private float hackTimer = 0;
    private float hackTimerLast = 0;

    public Adam() {
        settings = new Settings();
        //GameLogger.debug(Adam.class, "Creating loader class (Eve)");
        loader = new Eve(this);
    }

    public void create() {
        //GameLogger.debug(Adam.class, "LibGDX create");
        this.client.create();
        this.client.setScreen(ScreenStates.MENU);
    }

    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        //GameLogger.debug(Adam.class, "LibGDX dispose");
        this.loader.dispose();
        super.dispose();
    }

    public void setState(ScreenStates state) {
        switch (state) {
            case MENU:
                break;
            case GAME:
                if (serverThreaded.isPaused()) {
                    serverThreaded.unpause();
                }
                break;
            case PAUSE:
                serverThreaded.pause();
                break;
            case END:
                serverThreaded.endGame();
                break;
            default:
                break;
        }
        this.client.setScreen(state);
    }

    //synchronized public String[] getStats() {
    //    return new String[] {
    //        String.valueOf(this.serverThreaded.simulation.get_current_balance()),
    //        String.valueOf(this.serverThreaded.simulation.get_current_income()),
    //        String.valueOf(this.serverThreaded.simulation.get_current_income_trend()),
    //        String.valueOf(this.serverThreaded.simulation.get_number_students_trend()),
    //        String.valueOf(this.serverThreaded.simulation.get_student_satisfaction()),
    //        String.valueOf(this.serverThreaded.simulation.get_student_satisfaction_trend())
    //    };
    //}

    synchronized public float getTimer() {
        Date date = new java.util.Date((long) (this.serverThreaded.getTime() / 1000000));
        // Deprecated
        float dateseconds = (date.getMinutes() * 60) + date.getSeconds();
        if (dateseconds > this.hackTimerLast) {
            this.hackTimerLast = dateseconds;
            this.hackTimer++;
        }
        return this.hackTimer;
    }

    public void exit() {
        //GameLogger.debug(Adam.class, "QUIT");
        dispose();
        System.exit(0);
    }
}
