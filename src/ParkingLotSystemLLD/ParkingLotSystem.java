package ParkingLotSystemLLD;
import java.util.Scanner;
public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot= new ParkingLot();
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("================ ParkingLot System Menu ===============");
            System.out.println("1.Park vehicle");
            System.out.println("2.UnPark Vehicle");
            System.out.println("3.View parking Status");
            System.out.println("4.View Active Tickets");
            System.out.println("5.Search Vehicle");
            System.out.println("6.Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                   if( parkingLot.isAvilableSlot()) {
                       System.out.println("Enter Vehicle Number:");
                       String vehicleNumber = sc.next();
                       System.out.println("Enter Vehicle  Color:");
                       String vehicleColor = sc.next();
                       System.out.println("Enter Vehicle Owner Name:");
                       String vehicleOwner = sc.next();
                       System.out.println("Enter Vehicle type:");
                       String vehicletype = sc.next();
                       parkingLot.parkVehicle(vehicleNumber,vehicleColor,vehicleOwner,vehicletype);


                   }
                   else {
                       System.out.println("No slots are availble at this moment");
                   }
                   break;

                case 2:
                    if(!parkingLot.tickets.isEmpty()) {
                        System.out.println("Enter Ticket Id:");
                        String ticketId= sc.next();
                        System.out.println("Enter vehicle Number:");
                        String vehicleNumber= sc.next();
                        parkingLot.UnParkVehicle(ticketId,vehicleNumber);
                    }
                    else{
                        System.out.println("No Vehicle's  to UnPark at ParkingLot");
                    }
                    break;

                case 3:
                    parkingLot.viewParkingStatus();
                    break;

                case 4:
                    parkingLot.viewActiveTickets();
                    break;

                case 5:
                    if(!parkingLot.isAvilableVehicleToUnPark()) {
                        System.out.println("Enter vehicle Number:");
                        String vehicleNumber= sc.next();
                        parkingLot.searchVehicle(vehicleNumber);
                    }
                    else{
                        System.out.println("No Vehicle's  to search from History");
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("Exiting.....");
                    System.exit(0);

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}