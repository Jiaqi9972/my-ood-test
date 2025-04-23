package me.findthepeach.myood.amazonlocker.locker;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Locker {
    private final Map<Size, Queue<Slot>> availableSlots;
    private final String lockerName;
    private final Map<String, Slot> usedSlots;

    public Locker(int large, int medium, int small, String lockerName) {
        availableSlots = new HashMap<>();
        usedSlots = new HashMap<>();

        Queue<Slot> smallSLots = new ArrayDeque<>(small);
        Queue<Slot> mediumSLots = new ArrayDeque<>(medium);
        Queue<Slot> largeSLots = new ArrayDeque<>(large);

        for (int i = 0; i < large; i++) {
            largeSLots.offer(new Slot(Size.LARGE));
        }
        for (int i = 0; i < medium; i++) {
            mediumSLots.offer(new Slot(Size.MEDIUM));
        }
        for (int i = 0; i < small; i++) {
            smallSLots.offer(new Slot(Size.SMALL));
        }
        availableSlots.put(Size.SMALL, smallSLots);
        availableSlots.put(Size.MEDIUM, mediumSLots);
        availableSlots.put(Size.LARGE, largeSLots);
        this.lockerName = lockerName;
    }

    public boolean acceptPackage(Package pkg) {
        Slot slot = availableSlots.get(pkg.getSize()).poll();
        if(slot != null){
            slot.acceptPackage(pkg);
            usedSlots.put(pkg.getCode(), slot);
            System.out.println("Package accepted");
            return true;
        }else{
            System.out.println("Package rejected");
            return false;
        }
    }

    public void pickUpPackage(String code) {
        Slot slot = usedSlots.get(code);
        slot.pickUpPackage();
        usedSlots.remove(code);
        System.out.println("Package picked up");
    }
}
