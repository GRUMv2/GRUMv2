package grymV2.game.server;

public abstract class Event {
    private float startTime;
    private float runEvery;

    public float getRunEvery() {
        return runEvery;
    }

    public float getStartTime() {
        return startTime;
    }

    abstract public boolean tick(float time);
}
