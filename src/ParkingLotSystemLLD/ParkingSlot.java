package ParkingLotSystemLLD;

public class ParkingSlot {

    private String slotId;
    private VehicleType vehicleType;
    private boolean isOccupied=false;
    public ParkingSlot(VehicleType vehicleType, String slotId) {
        this.vehicleType = vehicleType;
        this.slotId = slotId;
        this.isOccupied= false;
    }

    public void setSlotId(String slotId) {
            this.slotId = slotId;
    }
    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    public String getSlotId(){
        return slotId;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }
}
