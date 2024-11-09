package grymV2.game.config;

import com.badlogic.gdx.graphics.Color;

/**
 * Config
 */
public class Config {
    // TODO: game.settings.get("ui.FOREGROUND") : Settings -> Config -> UI.get("FOREGROUND") -> enum UI.Keys.FOREGROUND.value() -> "#13371337"

    private final float UI_RATIO = 0.2f;
    private final Color UI_FOREGROUND = Color.valueOf("f88300ff");
    private final Color UI_BACKGROUND = Color.valueOf("444444ff");

    private MapSizes GAME_SIZE = MapSizes.LARGE;

    public MapSizes getGameSize() {
        return GAME_SIZE;
    }

    public void setGameSize(MapSizes size) {
        this.GAME_SIZE = size;
    }

    public float getUIRatio() {
        return UI_RATIO;
    }

    public Color getUIForeground() {
        return UI_FOREGROUND;
    }

    public Color getUIBackground() {
        return UI_BACKGROUND;
    }
}
