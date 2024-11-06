package grymV2.game.grid;

import grymV2.game.Settings;

public enum MapSizes {
    // x-values for map sizes
    SMALL((byte) 12),
    MEDIUM((byte) 16),
    LARGE((byte) 20),
    HUGE((byte) 24);

    private final byte size;

    private MapSizes(byte size) {
        this.size = size;
    }

    public byte getSize() {
        return size;
    }

    public byte getX() {
        return size;
    }

    public byte getY() {
        // Just assume 16:9 for now and let Viewport handle it
        return (byte) Math.round(((float) size / (16f * (1 - Settings.getUiRatio())) * 9f));
    }
}
