package ParkingLot;
import java.util.*;

public abstract class Certificate {
    private Date arrival;
    private Vehicle vehicle;
    private boolean autorization;

    public Date getArrival(){
        return this.arrival;
    }
    public Vehicle getVehicle(){
        return this.vehicle;
    }
    public boolean getAutorization() {
        return autorization;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public void setAutorization(boolean autorization) {
        this.autorization = autorization;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
