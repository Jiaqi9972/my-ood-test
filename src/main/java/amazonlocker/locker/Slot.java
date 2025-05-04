package amazonlocker.locker;

import java.util.Random;
import java.util.UUID;

public class Slot {
    private Size size;
    private UUID slotId;
    private SlotStatus status;
    private String code;
    private Package packageItem;

    public Slot(Size size){
        this.size = size;
        this.slotId = UUID.randomUUID();
        this.status = SlotStatus.AVAILABLE;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setStatus(SlotStatus status){
        this.status = status;
    }

    public UUID getSlotId(){
        return slotId;
    }

    public String getCode(){
        return code;
    }

    public SlotStatus getStatus(){
        return status;
    }

    public void setPackageItem(Package packageItem){
        this.packageItem = packageItem;
    }

    public boolean acceptPackage(Package pkg){
        if(status == SlotStatus.AVAILABLE && size == pkg.getSize()) {
            String code = codeGenerator();
            // store pkg
            pkg.setSlot(slotId);
            pkg.setPackageStatus(PackageStatus.IN_SLOT);
            pkg.setCode(code);
            //set slot code
            setCode(code);
            setStatus(SlotStatus.USED);
            setPackageItem(pkg);
            System.out.println("Package id" + pkg.getPackageNumber() + " accepted, stored in slot " + slotId + " with code " + code);
            return true;
        }
        return false;
    }

    public boolean pickUpPackage(){
        packageItem.setSlot(null);
        packageItem.setPackageStatus(PackageStatus.PICKED_UP);
        setPackageItem(null);
        status = SlotStatus.AVAILABLE;
        code = null;
        return true;
    }

    private String codeGenerator(){
        Random rand = new Random();
        // 生成0-9999之间的随机数
        int randomNum = rand.nextInt(10000);
        // 格式化为4位数，不足4位前面补0
        return String.format("%04d", randomNum);
    }
}
