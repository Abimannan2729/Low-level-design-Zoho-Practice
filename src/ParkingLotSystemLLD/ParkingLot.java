package ParkingLotSystemLLD;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class ParkingLot {
    ArrayList<ArrayList<ParkingSlot>> parkingslots= new ArrayList<>();
    ArrayList<Ticket> tickets= new ArrayList<>();
    int parkingSlotSize=3;
    int parkingLevelSize=3;
    int ticketCounter=0;

    public ParkingLot(){
        for(int i=0;i<parkingLevelSize;i++){
            parkingslots.add(new ArrayList<>());
        }
    }

    public boolean isAvilableSlot(){
      for(int i=0;i<parkingLevelSize;i++){
          if(parkingslots.get(i).size()<parkingSlotSize) return true;
      }
      return false;
    }
    public void parkVehicle(String vehicleNumber, String vehicleColor, String vehicleOwner, String vehicletype) {
        VehicleType type;
        if (vehicletype.equalsIgnoreCase("CAR")) {
            type = VehicleType.CAR;
        } else if (vehicletype.equalsIgnoreCase("BIKE")) {
            type = VehicleType.BIKE;
        } else {
            type = VehicleType.TRUCK;
        }

        Vehicle newVehicle = new Vehicle(vehicleNumber, vehicleColor, vehicleOwner, type);
        String ticketId = "T" + (++ticketCounter);

        // ✅ Check for a free slot first
        for (int i = 0; i < parkingLevelSize; i++) {
            for (ParkingSlot slot : parkingslots.get(i)) {
                if (!slot.getIsOccupied()) { // reuse existing freed slot
                    slot.setIsOccupied(true);
                    slot.setVehicleType(type);
                    Ticket generatedticket = new Ticket(newVehicle, slot, ticketId);
                    tickets.add(generatedticket);

                    printTicket(generatedticket);
                    return;
                }
            }
        }

        // ✅ If no free slot found, add a new one (if capacity allows)
        for (int i = 0; i < parkingLevelSize; i++) {
            if (parkingslots.get(i).size() < parkingSlotSize) {
                String slotId = "L" + (i + 1) + "S" + (parkingslots.get(i).size() + 1);
                ParkingSlot slot = new ParkingSlot(type, slotId);
                slot.setIsOccupied(true);
                Ticket generatedticket = new Ticket(newVehicle, slot, ticketId);
                tickets.add(generatedticket);

                parkingslots.get(i).add(slot);

                printTicket(generatedticket);
                return;
            }
        }

        System.out.println("🚫 No available parking slots!");
    }

    // ✅ Utility method to avoid duplicate print logic
    private void printTicket(Ticket ticket) {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-15s %-15s %-15s \n",
                "Ticket Id", "Slot Id", "Vehicle Type", "Vehicle Number", "Owner");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-15s %-15s %-15s \n",
                ticket.getTicketId(),
                ticket.getSlot().getSlotId(),
                ticket.getVehicleDetails().getVehicleType(),
                ticket.getVehicleDetails().getVehicleNumber(),
                ticket.getVehicleDetails().getVehicleOwner());
        System.out.println("---------------------------------------------------------------------------------------------------\n");
    }


    public void UnParkVehicle(String ticketId, String vehicleNumber){
        double bill= 0.0;
        LocalDateTime entryTime=null;
        LocalDateTime exitTime=null;
        VehicleType type=null;
        for(Ticket ticket: tickets){
            if(ticket.getSlot().getIsOccupied() && ticket.getTicketId().equalsIgnoreCase(ticketId)
                    && ticket.getVehicleDetails().getVehicleNumber().equalsIgnoreCase(vehicleNumber)){
                ticket.setExitTime(LocalDateTime.now());
                  bill= generateBill(ticket.getEntryTime(),ticket.getExitTime(),ticket.getVehicleDetails().getVehicleType());
                  ticket.getSlot().setIsOccupied(false);
                  ticket.getSlot().setVehicleType(null);
                  type=ticket.getVehicleDetails().getVehicleType();
                  entryTime=ticket.getEntryTime();
                  exitTime=ticket.getExitTime();
                  break;
            }
        }
        if(type!=null)
             printBill(vehicleNumber,type,entryTime,exitTime,bill);
        else System.out.println("Your Vehicle is Not Parked here . Or your Ticket Expired ");
    }
    public void printBill(String vehicleNumber,VehicleType type,LocalDateTime entryTime,LocalDateTime  exitTime,double bill){
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-30s %-30s %-15s \n","VehicleNumber","Vehicle Type","EntryTime","ExitTime","Bill Amount");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-30s %-30s %-15s\n",vehicleNumber,type,entryTime,exitTime,bill);
        System.out.println("------------------------------------------------------------------------------------------------");
    }
    public double generateBill(LocalDateTime entryTime,LocalDateTime exitTime,VehicleType type){
        double ratePerHour=0.0;
        switch (type) {
            case CAR:
                ratePerHour = 50.0;
                break;
            case BIKE:
                ratePerHour = 30.0;
                break;
            case TRUCK:
                ratePerHour = 100.0;
                break;
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
        Duration duration = Duration.between(entryTime,exitTime);
        long minutes= duration.toMinutes();
        long hours = Math.max(1, (minutes + 59) / 60);
        return ratePerHour * hours;
    }

    public void viewParkingStatus() {
        int level = 1;
        for (ArrayList<ParkingSlot> parkingLevel : parkingslots) {
            System.out.println("Level " + level);
            for (int i = 0; i < parkingSlotSize; i++) {
                if (i < parkingLevel.size()) {
                    ParkingSlot slot = parkingLevel.get(i);
                    if (slot.getIsOccupied()) {
                        System.out.println("Slot " + (i + 1) + " : " + slot.getVehicleType());
                    } else {
                        System.out.println("Slot " + (i + 1) + " : EMPTY");
                    }
                } else {
                    System.out.println("Slot " + (i + 1) + " : EMPTY");
                }
            }
            level++;
            System.out.println("------------------------------------------");
        }
    }


    public  void viewActiveTickets(){
        if(!tickets.isEmpty()) {
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-10s %-15s %-15s %-15s \n", "Ticket Id", "Slot Id", "Vehicle Type", "Vehicle Number", "Owner");
            System.out.println("---------------------------------------------------------------------------------------------------");
            for (Ticket ticket : tickets) {
                if (ticket.getSlot().getIsOccupied()) {
                    System.out.printf("%-10s %-10s %-15s %-15s %-15s \n",
                            ticket.getTicketId(),
                            ticket.getSlot().getSlotId(),
                            ticket.getVehicleDetails().getVehicleType(),
                            ticket.getVehicleDetails().getVehicleNumber(),
                            ticket.getVehicleDetails().getVehicleOwner());
                }
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println();
            }
        }
        else{
            System.out.println("No Active Tickets....");
            System.out.println();
        }
    }

    public void searchVehicle(String vehicleNumber) {
        boolean found = false;
        System.out.println("================================= Search Vehicle Result ==============================");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-15s %-15s %-15s \n","Ticket Id","Slot Id","Vehicle Type","Vehicle Number","Owner");
        System.out.println("---------------------------------------------------------------------------------------------------");

        for (Ticket ticket : tickets) {
            if (ticket.getSlot().getIsOccupied() &&
                    ticket.getVehicleDetails().getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                System.out.printf("%-10s %-10s %-15s %-15s %-15s \n",
                        ticket.getTicketId(),
                        ticket.getSlot().getSlotId(),
                        ticket.getVehicleDetails().getVehicleType(),
                        ticket.getVehicleDetails().getVehicleNumber(),
                        ticket.getVehicleDetails().getVehicleOwner());
                found = true;
            }
        }

        System.out.println("---------------------------------------------------------------------------------------------------");
        if (!found) {
            System.out.println("Vehicle with number " + vehicleNumber + " is NOT found in the parking lot.");
        }
    }


    public boolean isAvilableVehicleToUnPark(){
        for (int i = 0; i < parkingLevelSize; i++) {
            for (ParkingSlot slot : parkingslots.get(i)) {
                if (slot.getIsOccupied()) { // reuse existing freed slot
                   return true;
                }
            }
        }
        return false;
    }
}
