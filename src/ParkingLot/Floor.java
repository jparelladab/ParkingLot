package ParkingLot;

public class Floor {
    private Spot[] smallSpots;
    private Spot[] bigSpots;
    private int number;
    public int getNumber(){return this.number;}
    public Spot[] getSmallSpots() {
        return this.smallSpots;
    }
    public Spot[] getBigSpots(){
        return this.bigSpots;
    }
    public Spot[][] getSpots(){
        Spot[][] spots = new Spot[2][];
        spots[0] = smallSpots;
        spots[1] = bigSpots;
        return spots;
    }

    public Floor(int num, int smaSpots, int bgSpots){
        this.number = num;
        this.smallSpots = new Spot[smaSpots];
        this.bigSpots = new Spot[bgSpots];
        for (int i=0; i < smaSpots; i++) {
            //small spots are the first numbers, big ones the last ones
            this.smallSpots[i] = new SpotSmall(this,i+1);
        }
        for (int j=0; j < bgSpots; j++) {
            //small spots are the first numbers, big ones the last ones
            this.bigSpots[j] = new SpotBig(this, smaSpots+j+1);
        }
    }

}
