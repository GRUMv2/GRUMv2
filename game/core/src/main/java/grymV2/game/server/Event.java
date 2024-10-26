package grymV2.game.server;

public abstract class Event {
    protected float startTime;
//    protected float runEvery;

//    public float getRunEvery() {
//        return runEvery;
//    }

    public float getStartTime() {
        return this.startTime;
    }

    abstract public boolean tick(float time);
}
