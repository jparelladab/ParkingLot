package ParkingLot;

public abstract class Vehicle {
    private String plateNumber;
    private Certificate parkingCertificate;

    public String getPlateNumber() {
        return this.plateNumber;
    };

    public Certificate getParkingCertificate(){
        return this.parkingCertificate;
    }

    public void setParkingCertificate(Certificate certificate){
        this.parkingCertificate = certificate;
    }


}
