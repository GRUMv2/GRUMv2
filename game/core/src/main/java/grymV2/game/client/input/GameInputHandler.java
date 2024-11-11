package grymV2.game.client.input;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;

import grymV2.game.client.CainsLeftFoot;

/**
 * GameInputHandler
 */
public class GameInputHandler extends AbstractInputHandler {

    private CainsLeftFoot screen;

    public GameInputHandler(CainsLeftFoot screen) {
        super(new int[] {Keys.ESCAPE, Keys.NUM_1, Keys.NUM_2, Keys.NUM_3, Keys.NUM_4});
        this.screen = screen;
    }

    @Override
    public void handleLogic(int[] mousePos, ArrayList<Integer> keys, HashMap<Integer, EnumMap<MousePositions, Integer>> clicks) {
        for (int keycode : keys) {
            switch (keycode) {
                case Keys.ESCAPE:
                    this.pause();
                    break;
                case Keys.NUM_1:
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
