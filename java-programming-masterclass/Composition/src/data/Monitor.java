package data;

public class Monitor {

    private final String model;
    private final String manufacturer;
    private final int size;
    //monitor is composed of resolution
    private final Resolution nativeResolution;

    public Monitor(String model, String manufacturer, int size, Resolution nativeResolution) {
        this.model=model;
        this.manufacturer=manufacturer;
        this.size=size;
        this.nativeResolution=nativeResolution;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getNativeResolution() {
        return nativeResolution;
    }

    public void drawPixelAt(int x, int y, String colour) {
        System.out.println("drawing resolution at "+x+","+y+" in "+colour);
    }
}
