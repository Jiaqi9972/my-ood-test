package parkinglot.vehicle;

public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.LARGE);
    }
}
