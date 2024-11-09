package grymV2.game.client.input;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;

import grymV2.game.client.CainsLeftHand;

/**
 * EndInputHandler
 */
public class EndInputHandler extends AbstractInputHandler {
    private CainsLeftHand screen;

    public EndInputHandler(CainsLeftHand screen) {
        super(new int[] {Keys.Q});
        this.screen = screen;
    }

    @Override
    public void handleLogic(int[] mousePos, ArrayList<Integer> keys, HashMap<Integer, EnumMap<MousePositions, Integer>> clicks) {
        for (int keycode : keys) {
            switch (keycode) {
                case Keys.Q:
                    this.quitGame();
                    break;
                default:
                    break;
            }
        }
        if (clicks.size() > 0) {
            // Don't really care where or what the user clicked.
            this.quitGame();
        }
    }

    private void quitGame() {
        this.screen.quitGame();
    }
}
