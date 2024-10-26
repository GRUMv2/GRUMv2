package grymV2.game.server;

import grymV2.game.Adam;
import grymV2.game.server.Popup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Abel extends Thread {
    private static final Logger logger = LogManager.getLogger(Abel.class);
    private ArrayList<Popup> currentPopups;
    public ArrayList<Popup> getCurrentPopups() {
        return currentPopups;
    }

    // Entrypoint for the server thread from the loader
    public void run() {
        logger.info("GameServer running");
    }
}
