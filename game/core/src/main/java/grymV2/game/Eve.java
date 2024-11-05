package grymV2.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import grymV2.game.server.Abel;

class Eve {
    private static final Logger logger = LogManager.getLogger(Eve.class);
    private Abel gameThread;

    public Eve(Adam game, Settings settings) {
        logger.debug("Creating and starting gameserver (Abel)");

        gameThread = new Abel(120);
        gameThread.start();
        //client = new Cain(game);
    }

    public void dispose() {
        gameThread.endGame();

    }
}
