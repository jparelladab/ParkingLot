package ParkingLot;

public class SpotSmall extends Spot {

    public SpotSmall(Floor floor, int number){
        super(floor, number);
        this.setHourlyRate(4);
    }

}
