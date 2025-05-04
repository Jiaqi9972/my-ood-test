package amazonlocker;

import amazonlocker.locker.Locker;
import amazonlocker.locker.Package;
import amazonlocker.locker.Size;

public class Demo {

    public static void main(String[] args) {

        Manager manager = new Manager();
        Locker locker01 = manager.setUpLocker(5,5,5,"Locker01");
        Locker locker02 = manager.setUpLocker(5,5,5,"Locker02");

        DeliverMan deliverMan = new DeliverMan();
        deliverMan.addAvailableLocker(locker01);
        deliverMan.addAvailableLocker(locker02);

        Package package01 = new Package("001", Size.LARGE);
        Package package02 = new Package("002", Size.MEDIUM);
        Package package03 = new Package("003", Size.LARGE);
        deliverMan.deliverPackage(package01);
        deliverMan.deliverPackage(package02);
        deliverMan.deliverPackage(package03);

        Customer customer = new Customer();
        customer.pickUpPackage(locker01, package01.getCode());
    }
}
