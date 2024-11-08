package grymV2.game.server;

import grymV2.game.server.EventHandler;
import grymV2.game.server.TimeHandler;
import grymV2.game.server.Simulation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Abel extends Thread {
    private static final Logger logger = LogManager.getLogger(Abel.class);
    private ArrayList<Popup> currentPopups;
    private EventHandler eventHandler;
    public TimeHandler timeHandler;
    public Simulation simulation;
    private boolean isRunning = true;
    private int sDelay;

    public Abel(int TPS) {
        sDelay = (int)(1000 / TPS);
        eventHandler = new EventHandler();
        timeHandler = new TimeHandler();
        simulation = new Simulation();
    }

    public void endGame() {
        this.isRunning = false;
    }

    public ArrayList<Popup> getCurrentPopups() {
        return currentPopups;
    }

    // Entrypoint for the server thread from the loader
    public void run() {
        logger.info("GameServer running");

        while (isRunning) {
            // maintain server TPS
            // TODO: check system clock to maintain tps duing lag.
            try {
                Thread.sleep(sDelay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Verry verbose
            // logger.debug("Server tick" + timeHandler.gameSecondsRemaining());

            // check all events
            eventHandler.tick(timeHandler.gameSeconds());
            simulation.tick(0.0666f); // 20/300, roughly gives 20 years in 5 mins
        }
    }
}
