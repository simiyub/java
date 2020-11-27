package data;

public class Cylinder extends Circle {
    private double height=0;

    public Cylinder(double radius, double height) {
        super(radius);
        if(height>0){
            this.height=height;
        }
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        double volume = getArea()*getHeight();
        System.out.println("volume of cylinder of radius "+getRadius()+" and height of "+getHeight()+" is "+volume);
        return volume;
    }
}
