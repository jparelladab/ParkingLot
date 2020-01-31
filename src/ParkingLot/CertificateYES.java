package ParkingLot;

import java.util.Calendar;

public class CertificateYES extends Certificate {
    private Spot spot;
    private Spot[] spots;

    public CertificateYES(Vehicle vehicle, Spot spot){
        this.setVehicle(vehicle);
        this.spot = spot;
        this.setArrival(Calendar.getInstance().getTime());
        this.setAutorization(true);
    }
    //for the bus, we need a double spot certificate
    public CertificateYES(Vehicle vehicle, Spot[] spots){
        this.setVehicle(vehicle);
        this.spots = spots;
        this.setArrival(Calendar.getInstance().getTime());
        this.setAutorization(true);
    }

}
