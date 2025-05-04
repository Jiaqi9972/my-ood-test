package amazonlocker.locker;

import java.util.UUID;

public class Package {
    private String packageNumber;
    private Size size;
    private String code;
    private PackageStatus packageStatus;
    private UUID slotId;

    public Package(String packageNumber, Size size) {
        this.packageNumber = packageNumber;
        this.size = size;
    }

    public String getPackageNumber() {
        return packageNumber;
    }

    public Size getSize(){
        return size;
    }

    public String getCode(){
        return code;
    }

    public void setSlot(UUID slotId){
        this.slotId = slotId;
    }

    public UUID getSlotId(){
        return slotId;
    }

    public void setPackageStatus(PackageStatus packageStatus){
        this.packageStatus = packageStatus;
    }

    public void setCode(String code){
        this.code = code;
    }
}
