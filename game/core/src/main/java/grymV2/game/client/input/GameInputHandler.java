package grymV2.game.client.input;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;

import grymV2.game.client.CainsLeftFoot;

/**
 * GameInputHandler
 */
public class GameInputHandler extends AbstractInputHandler {

    private CainsLeftFoot screen;

    public GameInputHandler(CainsLeftFoot screen) {
        super(new int[] {Keys.ESCAPE});
        this.screen = screen;
    }

    @Override
    public void handleLogic(int[] mousePos, ArrayList<Integer> keys, HashMap<Integer, EnumMap<MousePositions, Integer>> clicks) {
        for (int keycode : keys) {
            switch (keycode) {
                case Keys.ESCAPE:
                    this.pause();
                    break;
                default:
                    break;
            }
        }
    }

    public void pause() {
        this.screen.pause();
    }
}
