package grymV2.game.client.input;

/**
 * InputHandler
 */
public abstract class AbstractInputHandler {
    int mouseX;
    int mouseY;

    public void setMousePos(int mouseX, int mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    public void setScroll(float scrollX, float scrollY) {
        // not implemented
    }
}
