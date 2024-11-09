package grymV2.game;

import java.io.FileNotFoundException;

import grymV2.game.server.Abel;
import grymV2.game.client.Cain;
import grymV2.game.grid.Grid;

class Eve {
    private Abel serverThreaded;
    private Cain client;

    public Eve(Adam game) {
        GameLogger.debug(Eve.class, "Creating and starting gameserver (Abel)");

        Grid grid = new Grid(game.settings.getGameSize());
        try {
            grid = Map.genMap(grid.getSize());
        } catch (FileNotFoundException | Map.MapException e) {
            GameLogger.error(Eve.class, "Cannot load map: " + e.toString());
            System.exit(2);
        }

        serverThreaded = new Abel(120 /* , grid */);
        serverThreaded.start();
        game.serverThreaded = serverThreaded;
        client = new Cain(game, grid);
        game.client = client;
    }

    private void loadMap(Grid grid) {
        // TODO
    }

    public void dispose() {
        serverThreaded.endGame();
    }
}
