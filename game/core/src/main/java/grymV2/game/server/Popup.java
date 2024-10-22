package grymV2.game;

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

    public PopupType Type() {
        return type;
    }

    public String Message() {
        return message;
    }

    public float Duration() {
        return duration;
    }

    public void Popup(PopupType type, String message, float duration) {
        this.type = type;
        this.message = message;
        this.duration = duration;
    }
}
