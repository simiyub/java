public interface ParkingManager {

    ParkingId park();
    boolean canPark();
    void slotsAvailable();
    void whereDidIPark();
    boolean unPark();

}
