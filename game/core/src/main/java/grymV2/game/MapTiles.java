package grymV2.game;

import grymV2.game.grid.BackgroundTileContent;
import grymV2.game.grid.ForegroundTileContent;

/**
 * MapTiles
 */
public class MapTiles {

    public enum Background {
        T(BackgroundTileContent.TERRAIN),
        W(BackgroundTileContent.WATER),
        H(BackgroundTileContent.HILL);

        private final BackgroundTileContent tile;

        private Background(BackgroundTileContent tile) {
            this.tile = tile;
        }

        public BackgroundTileContent getTile() {
            return tile;
        }
    }

    public enum Foreground {
        E(ForegroundTileContent.AGNOSTIC),
        R(ForegroundTileContent.ROAD),
        B(ForegroundTileContent.BUILDING);

        private final ForegroundTileContent tile;

        private Foreground(ForegroundTileContent tile) {
            this.tile = tile;
        }

        public ForegroundTileContent getTile() {
            return tile;
        }
    }
}
