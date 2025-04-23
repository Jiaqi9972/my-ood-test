package me.findthepeach.myood.elevatormanagement;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    private final List<Elevator> elevators;

    public ElevatorController() {
        elevators = new ArrayList<>();
    }

    public void addElevator(int id, int maxWeight, int maxFloor, int minFloor) {
        Elevator elevator = new Elevator(id, maxWeight, maxFloor, minFloor);
        elevators.add(elevator);
        new Thread(elevator::run).start();;
    }

    public Elevator addOutMove(int userFloor){
        Elevator elevator = null;
        OuterRequest outerRequest = new OuterRequest(userFloor);
        elevator = findOptimizedElevator(userFloor);
        elevator.addRequest(outerRequest);
        return elevator;
    }

    public void addInMove(int destFloor, Elevator elevator){
        InnerRequest innerRequest = new InnerRequest(elevator.getCurrFloor(), destFloor);
        elevator.addRequest(innerRequest);
    }

    public Elevator findOptimizedElevator(int userFloor) {
        List<Elevator> sameDirectionElevators = new ArrayList<>();
        for(Elevator elevator : elevators) {
            if (elevator.getCurrFloor() <= userFloor && elevator.getDirection() == Direction.UP){
                sameDirectionElevators.add(elevator);
            }else if (elevator.getCurrFloor() > userFloor && elevator.getDirection() == Direction.DOWN){
                sameDirectionElevators.add(elevator);
            }
        }
        if(!sameDirectionElevators.isEmpty()) {
            return findClosetElevator(sameDirectionElevators,userFloor);
        }else{
            return findClosetElevator(elevators,userFloor);
        }

    }

    private Elevator findClosetElevator(List<Elevator> elevators, int userFloor) {
        int diff = Integer.MAX_VALUE;
        Elevator optimalElevator = null;
        for(Elevator elevator : elevators) {
            int diffFloor = elevator.getCurrFloor() - userFloor;
            if(diffFloor < diff) {
                diff = diffFloor;
                optimalElevator = elevator;
            }
        }
        return optimalElevator;
    }
}
