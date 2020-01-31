package ParkingLot;

public class SpotBig extends Spot {

    public SpotBig(Floor floor, int number){
        super(floor, number);
        this.setHourlyRate(4);

    }
}
