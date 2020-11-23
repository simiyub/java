package data;

public class Toner {
    private final String colour;
    private double level;

    public Toner(String colour, double level) {
        this.colour=colour;
        this.level=level;
    }

    public String getColour() {
        return colour;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }
}
