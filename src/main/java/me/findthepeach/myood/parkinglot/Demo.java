package me.findthepeach.myood.parkinglot;

import me.findthepeach.myood.parkinglot.vehicle.Car;
import me.findthepeach.myood.parkinglot.vehicle.Motorcycle;
import me.findthepeach.myood.parkinglot.vehicle.Truck;
import me.findthepeach.myood.parkinglot.vehicle.Vehicle;

public class Demo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        Level level = new Level(1,5,5,5);
        Level level2 = new Level(2,5,5,5);
        Level level3 = new Level(3,5,5,5);

        parkingLot.addLevel(level);
        parkingLot.addLevel(level2);
        parkingLot.addLevel(level3);

        parkingLot.getStatus();

        Vehicle motorcycle = new Motorcycle("YSH123");
        Vehicle truck = new Truck("Ycvcx123");
        Vehicle car = new Car("aasd123");

        System.out.println("3 cars parked");
        parkingLot.park(motorcycle);
        parkingLot.park(truck);
        parkingLot.park(car);

        parkingLot.getStatus();

        System.out.println("2 cars left");
        parkingLot.unpark(car);
        parkingLot.unpark(truck);
        parkingLot.getStatus();

    }
}
