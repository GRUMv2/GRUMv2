package grymV2.game;

import grymV2.game.grid.MapSizes;

/**
 * Settings
 */
public class Settings {
    // Future: Load from settings.cfg or otherwise

    //private final static float UI_RATIO = 0.2f;
    public MapSizes GAME_SIZE = MapSizes.LARGE;

    public MapSizes getGameSize() {
        return GAME_SIZE;
    }

    public void setGameSize(MapSizes size) {
        this.GAME_SIZE = size;
    }

    //public static float getUiRatio() {
    //    return UI_RATIO;
    //}
}
