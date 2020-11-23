package data;

public class Dimensions {
    private final int width;
    private final int height;
    private final int depth;

    public Dimensions(int width, int height, int depth) {
        this.width = width;
        this.height=height;
        this.depth=depth;
    }

    public String printDimensions(){
        return (width+"X"+depth+"X"+depth);
    }
}
