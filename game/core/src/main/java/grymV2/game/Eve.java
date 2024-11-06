package grymV2.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import grymV2.game.server.Abel;
import grymV2.game.grid.Grid;

class Eve {
    private static final Logger logger = LogManager.getLogger(Eve.class);
    private Abel serverThreaded;

    public Eve(Adam game) {
        logger.debug("Creating and starting gameserver (Abel)");

        Grid grid = new Grid(game.settings.getGameSize());

        serverThreaded = new Abel(120, grid);
        serverThreaded.start();
        game.serverThreaded = serverThreaded;
        //client = new Cain(game, grid);
        //game.client = client;
    }

    public void dispose() {
        serverThreaded.endGame();
    }
}
