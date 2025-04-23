package me.findthepeach.myood.amazonlocker;

import me.findthepeach.myood.amazonlocker.locker.Locker;

public class Customer {

    public void pickUpPackage(Locker locker, String code){
        locker.pickUpPackage(code);
    }
}
