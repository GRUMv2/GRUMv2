package grymV2.game.client;

import grymV2.game.grid.Grid;

/**
 * Cain's Left Knee - Pause Screen
 */
public class CainsLeftKnee extends AbstractGameScreen {
    public CainsLeftKnee(Cain manager, Grid grid) {
        super(manager, grid);
    }

    @Override
    public void input() {
        // TODO Auto-generated method stub
    }

    @Override
    public void logic() {
        // TODO Auto-generated method stub
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub

    }


    @Override
    public void pause() {
        this.manager.pause();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }
}
