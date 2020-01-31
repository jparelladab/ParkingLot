package ParkingLot;


public class Parking {
    private Floor[] floors;
    private boolean busy;

    public Parking(Floor[] floors) {
        this.floors = floors;
        this.busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    public boolean checkParkingBusy(){
        for(Floor k : this.floors){
            for(Spot sp : k.getSpots()[0]){
                if (sp.isFree()){
                    this.busy = false;
                    return false;
                }
            }
            for(Spot sp : k.getSpots()[1]){
                if (sp.isFree()){
                    this.busy = false;
                    return false;
                }
            }
        }
        this.busy = true;
        return true;
    }

    public int getTotalFreeSmallSpots() {
        int sum = 0;
        for (int m = 0; m < this.floors.length; m++) {
            sum += floors[m].getSmallSpots().length;
        }
        return sum;
    }

    public int getTotalFreeBigSpots() {
        int sum = 0;
        for (int m = 0; m < this.floors.length; m++) {
            sum += floors[m].getBigSpots().length;
        }
        return sum;
    }


    //If there are free spots allocates one according to vehicle size starting by the ground floor and going up.
    //Small spots are the first ones at every floor
   public boolean park(Vehicle vehicle) {
       System.out.println("Welcome!");
       //update busy state
       this.checkParkingBusy();
       if (this.busy) {
           System.out.println("Parking full. No empty spots. Please wait");
       } else if (vehicle.getClass().getSimpleName().equals("VehicleMotorbike")) {
           if (this.getTotalFreeSmallSpots() + this.getTotalFreeBigSpots() > 0) {
               System.out.println("There are free spots for your Motorbike");
               //look first for small spots, from floor 0 upwards
               for (Floor k : this.floors) {
                   if (k.getSmallSpots().length > 0) {
                       for (Spot sp : k.getSmallSpots()) {
                           if (sp.isFree()) {
                               System.out.printf("Please park your Motorbike at floor %d, spot %d \n", k.getNumber(), sp.getNumber());
                               sp.occupySpot();
                               vehicle.setParkingCertificate(new CertificateYES(vehicle, sp));
                               return true;
                           }
                       }
                   }
               }
               //if no small spots look for big ones
               for (Floor k : this.floors) {
                   if (k.getBigSpots().length > 0) {
                       for (Spot sp : k.getBigSpots()) {
                           if (sp.isFree()) {
                               System.out.printf("Please park your Motorbike at floor %d, spot %d \n", k.getNumber(), sp.getNumber());
                               sp.occupySpot();
                               vehicle.setParkingCertificate(new CertificateYES(vehicle, sp));
                               return true;
                           }
                       }
                   }
               }
           }
       } else if (vehicle.getClass().getSimpleName().equals("VehicleCar")) {
           if (this.getTotalFreeBigSpots() > 0) {
               System.out.println("There are free spots for your Car");
               for (Floor k : this.floors) {
                   if (k.getBigSpots().length > 0) {
                       for (Spot sp : k.getBigSpots()) {
                           if (sp.isFree()) {
                               System.out.printf("Please park your Car at floor %d, spot %d \n", k.getNumber(), sp.getNumber());
                               sp.occupySpot();
                               vehicle.setParkingCertificate(new CertificateYES(vehicle, sp));
                               return true;
                           }
                       }
                   }
               }
           }
       } else if (vehicle.getClass().getSimpleName().equals("VehicleBus")) {
           if (this.getTotalFreeBigSpots() > 0) {
               System.out.println("There are free spots for your Bus");
               for (Floor k : this.floors) {
                   if (k.getBigSpots().length > 1) {
                       //Buses occupy 2 spaces, so they get a double certificate
                       for (int i=0; i < k.getBigSpots().length; i++) {
                           if (k.getBigSpots()[i].isFree()) {
                               System.out.printf("Please park your Bus at floor %d, across spots %d and %d \n", k.getNumber(), k.getBigSpots()[i].getNumber(), k.getBigSpots()[i].getNumber()+1);
                               k.getBigSpots()[i].occupySpot();
                               k.getBigSpots()[i+1].occupySpot();
                               vehicle.setParkingCertificate(new CertificateYES(vehicle, new Spot[] {k.getBigSpots()[i], k.getBigSpots()[i+1]}));
                               return true;
                           }
                       }
                   }
               }
           }
       }
       vehicle.setParkingCertificate(new CertificateNO(vehicle));
       return false;
   }
}
