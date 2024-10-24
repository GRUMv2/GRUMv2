package grymV2.game.client.input;

import com.badlogic.gdx.InputAdapter;

/**
 * AbstractInputProcessor - Abstract class for InputProcessors
 */
public abstract class AbstractInputProcessor extends InputAdapter {
    private AbstractInputHandler handler;
    public AbstractInputProcessor(AbstractInputHandler handler) {
        this.handler = handler;
    }

    public AbstractInputHandler getHandler() {
        return handler;
    }

    public void setHandler(AbstractInputHandler handler) {
        this.handler = handler;
    }
}
