package data;

public class Vehicle {
    private final String type;
    private int speed;
    private final int length;
    private final int width;
    private final int height;
    private int velocity;
    private int direction;

    public Vehicle(String type, int speed, int length, int width, int height){
        this.type=type;
        this.speed=speed;
        this.length=length;
        this.width=width;
        this.height=height;

    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    public void steer(int direction){
        this.direction+=direction;
        System.out.println("current direction="+direction+" degrees.");
    }
    public void move(int velocity, int direction){
        this.velocity = velocity;
        this.direction=direction;
        System.out.println("vehicle moving at "+velocity+" in "+direction+" direction.");
    }

    public void stop(){
        setVelocity(0);
    }

}
