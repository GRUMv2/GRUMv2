package grymV2.game.client.input;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;

import grymV2.game.client.CainsLeftKnee;

/**
 * PauseInputHandler
 */
public class PauseInputHandler extends AbstractInputHandler {

    private CainsLeftKnee screen;

    public PauseInputHandler(CainsLeftKnee screen) {
        super(new int[] {Keys.ESCAPE});
        this.screen = screen;
    }

    @Override
    public void handleLogic(int[] mousePos, ArrayList<Integer> keys, HashMap<Integer, EnumMap<MousePositions, Integer>> clicks) {
        for (int keycode : keys) {
            switch (keycode) {
                case Keys.ESCAPE:
                    this.resume();
                    break;
                default:
                    break;
            }
        }
    }

    public void resume() {
        this.screen.resume();
    }
}
