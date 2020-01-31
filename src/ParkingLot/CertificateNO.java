package ParkingLot;

import java.util.*;

public class CertificateNO extends Certificate {

    public CertificateNO(Vehicle vehicle){
        this.setVehicle(vehicle);
        this.setArrival(Calendar.getInstance().getTime());
        this.setAutorization(false);
    }
}
