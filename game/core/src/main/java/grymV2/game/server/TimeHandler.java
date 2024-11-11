package grymV2.game.server;

class TimeHandler {
    private long startTimeMS;
    private long pausedAtMS;
    private boolean isPaused = false;

    public TimeHandler() {
        this.startTimeMS = System.currentTimeMillis();  // prevents calls to gameSeconds returning 0-long0
    }

    public void startGame() {
        this.startTimeMS = System.currentTimeMillis();
    }

    public float gameSeconds() {
        if (isPaused) {
            return (pausedAtMS - startTimeMS) / 1000f;
        }

        return (System.currentTimeMillis() - startTimeMS) / 1000f;
    }

    public void pause() {
        pausedAtMS = System.currentTimeMillis();
        isPaused = true;
    }

    public void unpause() {
        isPaused = false;

        // we need to change the start position to correctly recalculate the time
        long pausedForMS = System.currentTimeMillis() - pausedAtMS;
        startTimeMS += pausedForMS;
    }
}
