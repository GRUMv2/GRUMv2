package grymV2.game.client.input;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;

/**
 * GlobalInputHandler - Application global shortcuts
 */
public class GlobalInputHandler extends AbstractInputHandler {

    public GlobalInputHandler() {
        super(new int[] {Keys.Q});
    }

    @Override
    public void handleLogic(int[] mousePos, ArrayList<Integer> keys, HashMap<Integer, EnumMap<MousePositions, Integer>> clicks) {
        // TODO Auto-generated method stub

    }
}
