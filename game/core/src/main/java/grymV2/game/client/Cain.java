package grymV2.game.client;

import java.util.EnumMap;

import grymV2.game.Adam;
import grymV2.game.Grid;
import grymV2.game.ScreenStates;

/**
 *
 *  Cain - ScreenManager
 *
 */
public class Cain {
    final Adam game;
    final EnumMap<RenderStates, Grid> grids;

    public Cain(Adam game, EnumMap<RenderStates, Grid> grids) {
        this.game = game;
        this.grids = grids;
    }

    public void setScreen(ScreenStates screen) {
        switch (screen) {
            case MENU:
                this.game.setScreen(new CainsLeftEye(this, grids));
                break;

            case GAME:
                this.game.setScreen(new CainsLeftFoot(this, grids));
                break;

            case PAUSE:
                this.game.setScreen(new CainsLeftKnee(this, grids));
                break;

            case END:
                this.game.setScreen(new CainsLeftHand(this, grids));
                break;

            default:
                break;
        }
    }
}
