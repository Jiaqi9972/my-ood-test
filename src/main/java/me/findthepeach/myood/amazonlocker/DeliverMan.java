package me.findthepeach.myood.amazonlocker;

import me.findthepeach.myood.amazonlocker.locker.Locker;
import me.findthepeach.myood.amazonlocker.locker.Package;
import me.findthepeach.myood.amazonlocker.locker.Size;

import java.util.ArrayList;
import java.util.List;

public class DeliverMan {

    private final List<Locker> lockers;

    public DeliverMan() {
        lockers = new ArrayList<>();
    }

    public void addAvailableLocker(Locker locker) {
        lockers.add(locker);
    }

    public Package createPackage(String packageNumber, Size size){
        return new Package(packageNumber, size);
    }

    public boolean deliverPackage(Package packageToDeliver){
        for(Locker locker : lockers) {
            if(locker.acceptPackage(packageToDeliver)){
                return true;
            }
        }
        System.out.println("No available locker slot found");
        return false;
    }
}
