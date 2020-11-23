package data.carpetcostcalculator;

public class Floor {
    private double length=0;
    private double width=0;

    public Floor(int width, int length) {
        if(width>0){
            this.width=width;
        }
        if(length>0){
            this.length=length;
        }
    }

    public Floor() {

    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        if(length>0){
            this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width>0){
            this.width = width;
        }
    }

    public double getArea() {
        return getLength()*getWidth();
    }
}
