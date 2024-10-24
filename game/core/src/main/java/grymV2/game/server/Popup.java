package grymV2.game.server;

enum PopupType {
    DEBUG,
    INFO,
    WARNING,
    CRITICAL
}

class Popup {
    private PopupType type;
    private String message;
    private float duration;

    public PopupType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public float getDuration() {
        return duration;
    }

    public void Popup(PopupType type, String message, float duration) {
        this.type = type;
        this.message = message;
        this.duration = duration;
    }
}
