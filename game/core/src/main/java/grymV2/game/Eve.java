package grymV2.game;

import grymV2.game.*;
import grymV2.game.server.Abel;

class Eve {
    private Abel gameThread;

    private void Eve() {
        gameThread = new Abel();
        gameThread.start();
    }
}
