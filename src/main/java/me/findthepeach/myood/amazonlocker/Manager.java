package me.findthepeach.myood.amazonlocker;

import me.findthepeach.myood.amazonlocker.locker.Locker;

public class Manager {

    public Locker setUpLocker(int large, int medium, int small, String name) {
        return new Locker(large, medium, small, name);
    }
}
