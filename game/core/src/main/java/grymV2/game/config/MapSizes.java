package grymV2.game.config;

public enum MapSizes {
    // x-values for map sizes
    SMALL((byte) 12, (byte) 8),
    MEDIUM((byte) 16, (byte) 11),
    LARGE((byte) 20, (byte) 14),
    HUGE((byte) 24, (byte) 17);

    private final byte sizeX;
    private final byte sizeY;

    private MapSizes(byte sizeX, byte sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public byte getSize() {
        return sizeX;
    }

    public byte getX() {
        return sizeX;
    }

    public byte getY() {
        // For dynamic map generation, something like the below. For now, hardcoded.
        //return (byte) Math.round(((float) size / (16f /* * (1 - Settings.getUiRatio()) */) * 9f));
        return sizeY;

    }
}
