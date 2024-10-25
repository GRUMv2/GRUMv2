package grymV2.game;

public enum MapSizes {
    // x-values for map sizes
    SMALL(12),
    MEDIUM(24),
    LARGE(36),
    HUGE(48);

    private final int size;

    private MapSizes(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
