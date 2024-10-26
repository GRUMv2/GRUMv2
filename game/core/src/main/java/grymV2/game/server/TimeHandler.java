package grymV2.game.server;

class TimeHandler {
    private long startTimeMS;

    public TimeHandler() {
        this.startTimeMS = System.currentTimeMillis();  // prevents calls to gameSeconds returning 0-long0
    }

    public void startGame() {
        this.startTimeMS = System.currentTimeMillis();
    }

    public float gameSeconds() {
        return (System.currentTimeMillis() - startTimeMS) / 1000f;
    }
}
