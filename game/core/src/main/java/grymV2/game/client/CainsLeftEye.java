package grymV2.game.client;

import grymV2.game.client.ui.TextButton;
import grymV2.game.client.ui.Layout;
import grymV2.game.grid.Grid;

/**
 * Cain's Left Eye - Main Menu
 */
public class CainsLeftEye extends AbstractGameScreen {

    private TextButton startButton;
    private TextButton dontStartButton;
    private Layout<TextButton> menuLayout;

    public CainsLeftEye(Cain manager, Grid grid) {
        super(manager, grid);
        this.menuLayout = new Layout<TextButton>(viewport.getWorldWidth()/3, viewport.getWorldHeight()/4);
        this.menuLayout.centreLayout(viewport);
        startButton = new TextButton(this.font);
        startButton.setText("Start");
        startButton.setColor(manager.game.settings.getUIForeground());
        this.menuLayout.add(startButton);
        dontStartButton = new TextButton(this.font);
        dontStartButton.setText("Quit");
        dontStartButton.setColor(manager.game.settings.getUIForeground());
        this.menuLayout.below(dontStartButton);
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
        this.menuLayout.draw(this.shapeRenderer, this.batch, this.viewport.getCamera());
    }

    public void startGame() {
        this.manager.startGame();
    }
}
