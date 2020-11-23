package data;

public class Car extends Vehicle{

    private final String steeringType;
    private final int gears;
    private final String make;
    private final String model;
    private final int yearOfManufacture;
    private final int wheels;
    private final int doors;
    private final boolean isManual;
    private int gear;


    public Car(String steeringType, String make, String model, int yearOfManufacture, int wheels, int doors, boolean isManual,int gears, int speed, int length, int width, int height) {
        super("car", speed, length, width, height);
        this.steeringType=steeringType;
        this.gears=gears;
        this.make=make;
        this.model=model;
        this.yearOfManufacture = yearOfManufacture;
        this.wheels=wheels;
        this.doors=doors;
        this.isManual=isManual;

    }
    public void changeGear(int gear){
        this.gear=gear;
        System.out.println("gear now is "+this.gear);
    }

    public void changeVelocity(int velocity, int direction){
        move(velocity,direction);
        System.out.println("changed velocity to "+getVelocity()+" in direction "+getDirection());
    }

    public void accelerate(int rate) {
        int newVelocity = ((getVelocity() + rate));
        if (newVelocity > 0) {
            changeVelocity(newVelocity, getDirection());
        }
    }

    public String getSteeringType() {
        return steeringType;
    }

    public int getGears() {
        return gears;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public int getWheels() {
        return wheels;
    }

    public int getDoors() {
        return doors;
    }

    public boolean isManual() {
        return isManual;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }
}
