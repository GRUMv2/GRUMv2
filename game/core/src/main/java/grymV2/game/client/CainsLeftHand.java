package grymV2.game.client;

import grymV2.game.grid.Grid;
import grymV2.game.client.ui.TextBox;
import grymV2.game.client.ui.Layout;

/**
 * Cain's Left Hand - End Screen
 */
public class CainsLeftHand extends AbstractGameScreen {

    private Layout<TextBox> endLayout;
    private TextBox endText;

    public CainsLeftHand(Cain manager, Grid grid) {
        super(manager, grid);
        this.endLayout = new Layout<TextBox>(viewport.getWorldWidth() * 0.7f, viewport.getWorldHeight());
        this.endLayout.centreLayout(viewport);
        this.endText = new TextBox(this.font);
        this.endText.setText("GAME OVER");
        this.endText.setTextColor(this.manager.game.settings.getUIForeground());
        this.endText.setColor(this.manager.game.settings.getUIBackground());
        this.endLayout.add(this.endText);
    }

    @Override
    public void input() {
        this.manager.handleInput();
    }

    @Override
    public void logic() {
    }

    @Override
    public void draw() {
        this.viewport.apply();
        this.endLayout.draw(this.shapeRenderer, this.batch, this.viewport.getCamera());
    }

    @Override
    public void dispose() {
    }

    public void quitGame() {
        this.manager.quitGame();
    }
}
