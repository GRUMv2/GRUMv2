package grymV2.game;

import java.io.FileNotFoundException;

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
        try {
            grid = Map.genMap(grid.getSize());
        } catch (FileNotFoundException | Map.MapException e) {
            logger.error("Cannot load map: " + e.toString());
            System.exit(2);
        }

        serverThreaded = new Abel(120 /* , grid */);
        serverThreaded.start();
        game.serverThreaded = serverThreaded;
        //client = new Cain(game, grid);
        //game.client = client;
    }

    private void loadMap(Grid grid) {
        // TODO
    }

    public void dispose() {
        serverThreaded.endGame();
    }
}
