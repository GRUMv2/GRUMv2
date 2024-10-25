package grymV2.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import grymV2.game.server.Abel;

class Eve {
    private static final Logger logger = LogManager.getLogger(Eve.class);
    private Abel gameThread;

    public Eve() {
        logger.debug("Creating and starting gameserver (Abel)");

        gameThread = new Abel();
        gameThread.start();
    }
}
