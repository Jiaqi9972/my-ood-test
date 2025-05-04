package elevatormanagement;

public class Demo {
    public static void main(String[] args){
        // add 3 elevators
        ElevatorController elevatorController = new ElevatorController();
        elevatorController.addElevator(1, 800, 1, 20);
        elevatorController.addElevator(2, 800, 1, 20);
        elevatorController.addElevator(3, 800, 1, 20);

        // user press at 6
        Elevator currElevator01 = elevatorController.addOutMove(6);
        // user press 10
        elevatorController.addInMove(10, currElevator01);

        // another user press at 1
        Elevator currElevator02 = elevatorController.addOutMove(1);
        // user press 19
        elevatorController.addInMove(19, currElevator02);

    }
}
