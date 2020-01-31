package ParkingLot;

import java.util.Calendar;

public class MainClass {

    public static void main(String[] args) {
       //first set up a new Parking, let's say 3 floors (0, 1, 2) with different amouts of small and big spots
        //we can create first an array of floors and then the parking or all in one line
        //Floor[] myFloors = {new Floor(0,10, 10), new Floor(1,20, 20), new Floor(2,30, 30)};
        Parking myParking = new Parking(new Floor[]{new Floor(0,10, 10), new Floor(1,20, 20), new Floor(2,30, 30)});
        //create Vehicles
        VehicleCar myCar = new VehicleCar();
        VehicleMotorbike myBike = new VehicleMotorbike();
        VehicleBus myBus = new VehicleBus();
        VehicleMotorbike anotherMotorbike = new VehicleMotorbike();
        //park the vehicles in your parking
        myParking.park(myCar);
        myParking.park(myBus);
        myParking.park(myBike);
        myParking.park(anotherMotorbike);
        //check their arrivals
        System.out.println(myBike.getParkingCertificate().getArrival());
    }
}
