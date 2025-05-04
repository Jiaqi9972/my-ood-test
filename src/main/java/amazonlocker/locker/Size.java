package amazonlocker.locker;

public enum Size {
    SMALL(0),
    MEDIUM(1),
    LARGE(2);

    private int value;

    private Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
