package grymV2.game.server;

import grymV2.game.server.Popup;
import java.util.ArrayList;

public class Abel extends Thread {
    private ArrayList<Popup> currentPopups;

    public ArrayList<Popup> getCurrentPopups() {
        return currentPopups;
    }

    // Entrypoint for the server thread from the loader
    public void run() {
        System.out.println("Thread is running...");
    }
}
