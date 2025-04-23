package me.findthepeach.myood.parkinglot;

import me.findthepeach.myood.parkinglot.vehicle.Vehicle;
import me.findthepeach.myood.parkinglot.vehicle.VehicleType;

public class ParkingSpot {
    private final int id;
    private final VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSpot(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable(){
        return vehicle == null;
    }

    public synchronized void park(Vehicle vehicle) {
        if(isAvailable() && vehicleType.equals(vehicle.getVehicleType())){
            this.vehicle = vehicle;
            System.out.println("Successfully parked " + vehicle.getLicensePlate() + " at id " + id);
        }else{
            throw new IllegalStateException("Vehicle is not available");
        }
    }

    public synchronized void unpark(Vehicle vehicle) {
        System.out.println("successfully unparked " + vehicle.getLicensePlate() + " at id " + id);
        this.vehicle = null;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
