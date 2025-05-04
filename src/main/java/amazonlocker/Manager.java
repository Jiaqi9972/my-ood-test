package amazonlocker;

import amazonlocker.locker.Locker;

public class Manager {

    public Locker setUpLocker(int large, int medium, int small, String name) {
        return new Locker(large, medium, small, name);
    }
}
