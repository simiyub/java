package data;

public class Room {
    private final Dimensions dimensions;
    private final String name;


    public Room(String name, int length, int width, int height) {
        this.name=name;
        this.dimensions = new Dimensions(width,height,length);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getName() {
        return name;
    }
}
