package parkinglot;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int level;
    private final List<ParkingSpot> parkingSpots;

    public Level(int level, int largeSpot, int mediumSpot, int smallSpot) {
        this.level = level;
        this.parkingSpots = new ArrayList<>();

        for (int i = 0; i < largeSpot; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.LARGE));
        }
        for (int i = 0; i < mediumSpot; i++) {
            parkingSpots.add(new ParkingSpot(i + largeSpot, VehicleType.MEDIUM));
        }
        for (int i = 0; i < smallSpot; i++) {
            parkingSpots.add(new ParkingSpot(i + largeSpot + mediumSpot, VehicleType.SMALL));
        }
    }

    public synchronized boolean park(Vehicle vehicle) {
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.isAvailable() && vehicle.getVehicleType() == parkingSpot.getVehicleType()) {
                parkingSpot.park(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unpark(Vehicle vehicle) {
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(!parkingSpot.isAvailable() && parkingSpot.getVehicle().equals(vehicle)) {
                parkingSpot.unpark(vehicle);
                return true;
            }
        }
        return false;
    }

    public void getStatus(){
        System.out.println("Level: " + level + " availability:");
        int largeSpots = 0;
        int mediumSpots = 0;
        int smallSpots = 0;
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.isAvailable()) {
                switch (parkingSpot.getVehicleType()) {
                    case LARGE:
                        largeSpots++;
                        break;
                    case MEDIUM:
                        mediumSpots++;
                        break;
                    case SMALL:
                        smallSpots++;
                        break;
                }
            }
        }
        System.out.println("Large spots: " + largeSpots + " Medium spots: " + mediumSpots + " Small spots: " + smallSpots);
    }
}
