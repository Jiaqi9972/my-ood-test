package amazonlocker;

import amazonlocker.locker.Locker;

public class Customer {

    public void pickUpPackage(Locker locker, String code){
        locker.pickUpPackage(code);
    }
}
