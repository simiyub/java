package data;

public class Car {
    private final int cylinders;
    private final String make;
    private final int wheels;
    private final boolean engine;

    public Car(int cylinders, String make, int wheels, boolean engine) {
        this.cylinders=cylinders;
        this.make=make;
        this.wheels=wheels;
        this.engine=engine;
    }

    public  static Car getCar(int maxSpeed){
        return maxSpeed>120?
                new RangeRover(6,maxSpeed):
                new Honda(4,120);
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getMake() {
        return make;
    }

    public int getWheels() {
        return wheels;
    }

    public boolean isEngine() {
        return engine;
    }
    public void startEngine(){
        System.out.println("Starting engine..");
    }
    public  void accelerate(){
        System.out.println("Accelerating..");

    }
    public void brake(){
        System.out.println("Braking..");
    }
}

class Honda extends Car{

    private int maxSpeed=120;

    public Honda(int cylinders, int maxSpeed) {
        super(cylinders, "Honda", 4, true);
        this.maxSpeed=maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void startEngine(){
        System.out.println("Doing engine checks..");
        super.startEngine();
    }

    @Override
    public void accelerate() {
        System.out.println("Checking speed limit..");
        super.accelerate();
    }

    @Override
    public void brake() {
        System.out.println("Braking cautiously..");
    }
}

class RangeRover extends Car{

    private int maxSpeed=140;

    public RangeRover(int cylinders, int maxSpeed) {
        super(cylinders, "Range Rover", 4, true);
        this.maxSpeed=maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void startEngine(){
        System.out.println("Doing engine checks..");
        System.out.println("Checking transmission..");
        super.startEngine();
    }

    @Override
    public void accelerate() {
        System.out.println("Activating accelerator controls..");
        super.accelerate();
    }

    @Override
    public void brake() {
        System.out.println("Choosing brakes..");
        System.out.println("Applying brakes..");
    }
}
