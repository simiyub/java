package data;

public class Point {
    private int y;
    private int x;

    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public Point() {
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double distance() {
        return distance(0,0);
    }

    public double distance(int x, int y) {
        double value=0;
        return Math.sqrt(
                ((getX()-x)*(getX()-x))
                +((getY()-y)*(getY()-y)));
    }

    public double distance(Point point) {
        return distance(point.getX(),point.getY());
    }
}
