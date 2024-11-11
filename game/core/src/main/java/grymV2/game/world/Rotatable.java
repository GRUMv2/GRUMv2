package grymV2.game.world;


/**
 * Rotatable
 */
public interface Rotatable {
    // Probably shouldn't be an int
    public int getOrientation();
    public void setOrientation(int orientation);
}
