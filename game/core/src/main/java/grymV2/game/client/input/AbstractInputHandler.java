package grymV2.game.client.input;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Input;

/**
 * AbstractInputHandler
 */
public abstract class AbstractInputHandler {
    private int mouseX;
    private int mouseY;
    protected enum MousePositions { STARTX, STARTY, ENDX, ENDY };
    private EnumMap<MousePositions, Integer> leftClickPos;
    private boolean leftClicked;
    private boolean CTRL;
    final int[] keysEnabled;
    private HashMap<Integer, Boolean> keysActive;
    private HashMap<Integer, EnumMap<MousePositions, Integer>> clickActive;

    public AbstractInputHandler(int[] keysEnabled) {
        this.keysEnabled = keysEnabled;
        this.keysActive = new HashMap<Integer, Boolean>();
        this.clickActive = new HashMap<Integer, EnumMap<MousePositions, Integer>>();
        this.leftClickPos = new EnumMap<MousePositions, Integer>(MousePositions.class);
        this.leftClicked = false;
        this.CTRL = false;
        for (int k : keysEnabled) {
            this.keysActive.put(k, false);
        }
    }

    public void setMousePos(int mouseX, int mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    public int[] getMousePos() {
        return new int[]{this.mouseX, this.mouseY};
    }

    public void setScroll(float scrollX, float scrollY) {
        // not implemented
    }

    public boolean leftClick(Boolean event) {
        if (event && !this.leftClicked) {
            this.leftClickPos.put(MousePositions.STARTX, this.mouseX);
            this.leftClickPos.put(MousePositions.STARTY, this.mouseY);
        } else if (!event && this.leftClicked) {
            this.leftClickPos.put(MousePositions.ENDX, this.mouseX);
            this.leftClickPos.put(MousePositions.ENDY, this.mouseY);
            this.clickActive.put(Input.Buttons.LEFT, new EnumMap<>(leftClickPos));
        }
        this.leftClicked = event;
        return true;
    }

    public boolean rightClick(Boolean event) {
        // Unused
        return false;
    }

    public boolean click(int button, Boolean event) {
        switch (button) {
            case Input.Buttons.LEFT:
                return leftClick(event);
            case Input.Buttons.RIGHT:
                return rightClick(event);
            default:
                return false;
        }
    }

    public HashMap<Integer, EnumMap<MousePositions, Integer>> getClicks() {
        return clickActive;
    }

    public void setCTRL(Boolean event) {
        this.CTRL = event;
    }

    public boolean getCTRL() {
        return this.CTRL;
    }

    public boolean setKey(int key, Boolean event) {
        if (this.keysActive.containsKey(key)) {
            this.keysActive.put(key, event);

            // XXX: Mod + Key will eat standalone Key mappings in the multiplexer here
            // Better solution needed.
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getKeys() {
        ArrayList<Integer> keys = new ArrayList<Integer>();
        for (Map.Entry<Integer, Boolean> e : keysActive.entrySet()) {
            if (e.getValue()) {
                keys.add(e.getKey());
            }
        }
        return keys;
    }


    public void handle() {
        // Get mouse/key events for current frame, hand over to subclass specific implementation, then reset them
        handleLogic(this.getMousePos(), this.getKeys(), this.getClicks());
        for (int k : keysActive.keySet()) {
            keysActive.put(k, false);
        }
        this.clickActive = new HashMap<Integer, EnumMap<MousePositions, Integer>>();
    }

    abstract public void handleLogic(int[] mousePos, ArrayList<Integer> keys, HashMap<Integer, EnumMap<MousePositions, Integer>> clicks);

}
