package grymV2.game.client.input;

/**
 * PointerProcessor - InputProcessor for mouse/touch events
 */
public class PointerProcessor extends AbstractInputProcessor {
    private AbstractInputHandler handler;
    public PointerProcessor(AbstractInputHandler handler) {
        super(handler);
        this.handler = this.getHandler();
    }

    public boolean mouseMoved(int screenX, int screenY) {
        this.handler.setMousePos(screenX, screenY);
        return true;
    }

    public boolean scrolled(float amountX, float amountY) {
        this.handler.setScroll(amountX, amountY);
        return false;
    }
}
