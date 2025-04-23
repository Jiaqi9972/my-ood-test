package me.findthepeach.myood.elevatormanagement;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final int id;
    private final int maxWeight;
    private Direction direction;
    private int currFloor;
    private final int maxFloor;
    private final int minFloor;
    private final List<Request> requests;

    public Elevator(int id, int maxWeigh, int maxFloor, int minFloor) {
        this.id = id;
        this.maxWeight = maxWeigh;
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
        this.currFloor = 1;
        this.direction = Direction.UP;
        this.requests = new ArrayList<>();
    }

    public synchronized void addRequest(Request request){
        requests.add(request);
        System.out.println("Elevator " + id + " added request: " + request);
        notifyAll();
    }

    public synchronized Request getNext(){
        while(requests.isEmpty()){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return requests.remove(0);
    }

    public synchronized void processRequests(){
        while(true){
            while(!requests.isEmpty()){
                Request request = getNext();
                processRequest(request);
            }
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void processRequest(Request request){
        int startFloor = currFloor;
        int destFloor = request.getDestFloor();
        if(destFloor > startFloor){
            direction = Direction.UP;
            for(int i = startFloor; i <= destFloor; i++){
                currFloor = i;
                System.out.println("Elevator number " + id + " is working, " + "current Floor: " + currFloor);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }else if(destFloor < startFloor){
            direction = Direction.DOWN;
            for(int i = startFloor; i >= destFloor; i--){
                currFloor = i;
                System.out.println("Elevator number " + id + " is working, " + "current Floor: " + currFloor);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        processRequests();
    }

    public int getCurrFloor(){
        return currFloor;
    }

    public Direction getDirection(){
        return direction;
    }

}
