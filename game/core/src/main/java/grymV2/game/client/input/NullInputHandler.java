package grymV2.game.client.input;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

/**
 *
 * NullInputHandler - Does nothing
 * Exists to sponge the time between Listener init and first handler assignment.
 * Should not otherwise be used.
 *
 */
public class NullInputHandler extends AbstractInputHandler {

    public NullInputHandler() {
        // Does nothing
        super(new int[] {});
    }

    @Override
    public void handleLogic(int[] mousePos, ArrayList<Integer> keys, HashMap<Integer, EnumMap<MousePositions, Integer>> clicks) {
        // Still does nothing
    }
}
