package grymV2.game.client.input;

/**
 * KeyProcessor - InputProcessor for key events
 */
public class KeyProcessor extends AbstractInputProcessor {
    private AbstractInputHandler handler;
    public KeyProcessor(AbstractInputHandler handler) {
        super(handler);
        this.handler = this.getHandler();
    }

    public boolean keyDown(int keycode) {
        return this.handler.setKey(keycode, true);
    }

    public boolean keyUp(int keycode) {
        return this.handler.setKey(keycode, false);
    }
}
