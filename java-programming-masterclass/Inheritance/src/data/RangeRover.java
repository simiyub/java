package data;

public class RangeRover extends Car{
    public RangeRover(String steeringType, String model, int yearOfManufacture,int doors, int speed, boolean isManual, int length, int width, int height) {
        super(steeringType, "range rover", model, yearOfManufacture, 4, doors, isManual, 6, speed,length, width, height);
    }

    @Override
    public void accelerate(int rate) {
        super.accelerate(rate);
        if(!isManual()){
            int gear = getVelocity()<=10? 1
                    : getVelocity()<=20? 2
                    : getVelocity()<=30? 3
                    : 4;
            changeGear(gear);
        }

    }
}
