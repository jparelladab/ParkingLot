package ParkingLot;

public abstract class Spot {
    Parking parking;
    protected Floor floor;
    private float hourlyRate;
    protected boolean free;
    protected int number;

    public Spot(Floor floor, int number){
        this.floor = floor;
        this.number = number;
        this.free = true;
    }

    public float getHourlyRate(){return this.hourlyRate;};
    public void setHourlyRate(int num){ this.hourlyRate = num; }

    public void occupySpot(){
        this.free = false;
    }
    public void freeSpot(){ this.free = true; }

    public int getNumber() {
        return this.number;
    }

    public boolean isFree() {
        return free;
    }


}
