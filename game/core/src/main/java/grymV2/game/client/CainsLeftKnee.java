package grymV2.game.client;

import grymV2.game.grid.Grid;

import grymV2.game.client.ui.Layout;
import grymV2.game.client.ui.TextBox;

/**
 * Cain's Left Knee - Pause Screen
 */
public class CainsLeftKnee extends AbstractGameScreen {

    private Layout<TextBox> pauseLayout;
    private TextBox pauseText;

    public CainsLeftKnee(Cain manager, Grid grid) {
        super(manager, grid);
        this.pauseLayout = new Layout<TextBox>(viewport.getWorldWidth() * 0.7f, viewport.getWorldHeight());
        this.pauseLayout.centreLayout(viewport);
        this.pauseText = new TextBox(this.font);
        this.pauseText.setText("Game Paused");
        this.pauseText.setTextColor(this.manager.game.settings.getUIForeground());
        this.pauseText.setColor(this.manager.game.settings.getUIBackground());
        this.pauseLayout.add(this.pauseText);
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
        this.pauseLayout.draw(this.shapeRenderer, this.batch, this.viewport.getCamera());
    }

    @Override
    public void resume() {
        this.manager.resume();
    }

    @Override
    public void dispose() {
    }
}
