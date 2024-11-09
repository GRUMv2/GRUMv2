package grymV2.game.client.input;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;

import grymV2.game.client.CainsLeftEye;

/**
 * MenuInputHandler
 */
public class MenuInputHandler extends AbstractInputHandler {
    private CainsLeftEye screen;

    public MenuInputHandler(CainsLeftEye screen) {
        super(new int[] {Keys.ENTER, Keys.SPACE});
        //GameLogger.debug(CainsLeftEye.class, "Init MenuInputHandler");
        this.screen = screen;
    }

    @Override
    public void handleLogic(int[] mousePos, ArrayList<Integer> keys, HashMap<Integer, EnumMap<MousePositions, Integer>> clicks) {
        ArrayList<Integer> unhandledKeys = new ArrayList<Integer>();
        for (int keycode : keys) {
            switch (keycode) {
                case Keys.ENTER:
                case Keys.SPACE:
                    this.startGame();
                    break;
                default:
                    unhandledKeys.add(keycode);
                    break;
            }
        }
    }

    private void startGame() {
        this.screen.startGame();
    }

}
