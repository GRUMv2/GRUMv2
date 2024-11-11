package grymV2.game.client.input;

/**
 * PointerProcessor - InputProcessor for mouse/touch events
 */
public class PointerProcessor extends AbstractInputProcessor {
    public PointerProcessor(AbstractInputHandler handler) {
        super(handler);
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return this.getHandler().setMousePos(screenX, screenY);
    }

    public boolean scrolled(float amountX, float amountY) {
        this.getHandler().setScroll(amountX, amountY);
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return this.getHandler().click(button, true);
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return this.getHandler().click(button, false);
    }
}
