package grymV2.game.client.input;

/**
 * KeyProcessor - InputProcessor for key events
 */
public class KeyProcessor extends AbstractInputProcessor {
    public KeyProcessor(AbstractInputHandler handler) {
        super(handler);
    }

    public boolean keyDown(int keycode) {
        return this.getHandler().setKey(keycode, true);
    }

    public boolean keyUp(int keycode) {
        return this.getHandler().setKey(keycode, false);
    }
}
