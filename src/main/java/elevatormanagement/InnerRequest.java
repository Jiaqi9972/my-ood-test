package elevatormanagement;

public class InnerRequest extends Request {

    private int srcFloor;
    public InnerRequest(int srcFloor, int destFloor) {
        super(destFloor);
        this.srcFloor = srcFloor;
    }
    public int getSrcFloor() {
        return srcFloor;
    }
}
