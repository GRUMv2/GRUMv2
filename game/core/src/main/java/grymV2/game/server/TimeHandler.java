package grymV2.game.server;

import com.badlogic.gdx.utils.TimeUtils;

class TimeHandler {
    private long startTimeMS;
    private long pausedAtMS;
    private boolean isPaused = false;

    public TimeHandler() {
        this.startTimeMS = TimeUtils.nanoTime();  // prevents calls to gameSeconds returning 0-long0
    }

    public void startGame() {
        this.startTimeMS = TimeUtils.nanoTime();
    }

    public float gameSeconds() {
        if (isPaused) {
            return (pausedAtMS - startTimeMS);
        }

        return (TimeUtils.nanoTime() - startTimeMS);
    }

    public void pause() {
        pausedAtMS = TimeUtils.nanoTime();
        isPaused = true;
    }

    public void unpause() {
        isPaused = false;

        // we need to change the start position to correctly recalculate the time
        long pausedForMS = TimeUtils.nanoTime() - pausedAtMS;
        startTimeMS += pausedForMS;
    }
}
