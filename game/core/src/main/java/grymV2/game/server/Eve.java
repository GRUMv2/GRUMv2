package grymV2.game;

import grymV2.game.Popup;
import java.util.ArrayList;

class Eve extends Thread {
    private ArrayList<Popop> currentPopups;

    public ArrayList<Popop> getCurrentPopups() {
        return currentPopups;
    }

    // Entrypoint for the server thread from the loader
    public void run() {
        System.out.println("Thread is running...");
    }
}
