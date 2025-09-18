package ParkingLotSystemLLD;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private ParkingSlot slot;
    private Vehicle vehicleDetails;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(Vehicle vehicleDetails, ParkingSlot slot, String ticketId) {
        this.vehicleDetails = vehicleDetails;
        this.slot=slot;
        this.ticketId = ticketId;
        this.entryTime = LocalDateTime.now();
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }


    public void setVehicleDetails(Vehicle vehicleDetails){
        this.vehicleDetails=vehicleDetails;
    }


    public  Vehicle getVehicleDetails(){
        return vehicleDetails;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

}
