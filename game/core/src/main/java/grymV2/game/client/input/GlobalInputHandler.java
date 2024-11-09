package grymV2.game.client.input;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;

import grymV2.game.GameLogger;
import grymV2.game.client.Cain;

/**
 * GlobalInputHandler - Application global shortcuts
 */
public class GlobalInputHandler extends AbstractInputHandler {

    private Cain manager;

    public GlobalInputHandler(Cain manager) {
        super(new int[] {Keys.Q});
        this.manager = manager;
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
    }

    @Override
    public boolean click(int button, Boolean event) {
        // Pass all click events through to screen handler
        return false;
    }

    @Override
    public boolean setKey(int key, Boolean event) {
        // Retroactive time-saving hack
        // The input handling needs to be tweaked to pass through Mod+Key combinations
        //  as a single key event, and then have each *Handler read them in full
        // The current implementation can't tell the difference between <Key> and CTRL+<Key>
        //
        // This works around the issue by having all CTRL+<Key> events automatically global
        // handler and all regular keys screen handled
        if (key == Keys.CONTROL_LEFT || key == Keys.CONTROL_RIGHT) {
            this.setCTRL(event);
            return true;
        }
        if (!this.getCTRL()) {
            return false;
        }
        return super.setKey(key, event);
    }

    public void quitGame() {
        this.manager.quitGame();
    }
}
