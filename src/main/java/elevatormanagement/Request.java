package elevatormanagement;

public abstract class Request {
    private int destFloor;
    public Request(int destFloor) {
        this.destFloor = destFloor;
    }
    public int getDestFloor() {
        return destFloor;
    }
}
