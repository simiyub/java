package data;

public class Rectangle {
    private double width=0;
    private double length=0;

    public Rectangle(double width, double length){
        if(width>0){
            this.width=width;
        }
        if(length>0){
            this.length=length;
        }
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
    public double getArea(){
        double area = getWidth()*getLength();
        System.out.println("area of rectangle "+getWidth()+" X "+getLength()+" = "+area);
        return area;
    }
}
