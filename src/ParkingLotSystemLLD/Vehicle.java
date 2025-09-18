package ParkingLotSystemLLD;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleColor;
    private String vehicleOwner;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNumber, String vehicleColor, String vehicleOwner, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleColor = vehicleColor;
        this.vehicleOwner = vehicleOwner;
        this.vehicleType = vehicleType;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }
}
