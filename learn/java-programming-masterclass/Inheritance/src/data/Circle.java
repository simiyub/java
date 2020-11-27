package data;

public class Circle {
    private double radius=0;

    public Circle(double radius){
        if (radius>0){
            this.radius=radius;
        };
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        double area = radius*radius * Math.PI;
        System.out.println("area of circle radius="+getRadius()+" is "+area);
        return area;
    }
}
