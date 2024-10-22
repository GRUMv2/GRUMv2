package grymV2.game;

import grymV2.game.Popup;
import java.util.ArrayList;

class Eve extends Thread {
    private ArrayList<Popup> currentPopups;

    public ArrayList<Popup> getCurrentPopups() {
        return currentPopups;
    }

    // Entrypoint for the server thread from the loader
    public void run() {
        System.out.println("Thread is running...");
    }
}
