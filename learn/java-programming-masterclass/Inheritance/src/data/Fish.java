package data;

public class Fish extends Animal {
    private final int gills;
    private final int fins;

    public int getGills() {
        return gills;
    }

    public int getFins() {
        return fins;
    }
    public  void swim(int speed){
        super.move(speed);
        moveMuscles();
        moveBackFin();
    }

    private void moveBackFin() {
        System.out.println("moving back fin.");
    }

    private void moveMuscles() {
        System.out.println("moving muscles.");

    }

    public Fish(String name, int size, int weight, int gills, int fins) {
        super(name, 1,1,size, weight);
        this.gills=gills;
        this.fins=fins;
    }
}
