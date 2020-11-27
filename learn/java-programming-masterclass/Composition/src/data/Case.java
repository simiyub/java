package data;

public class Case {
    private final String model;
    private final String manufacturer;
    private final String powersupply;
    private final Dimensions dimensions;

    public Case(String model, String manufacturer, String powerSupply, Dimensions dimensions) {
        this.model=model;
        this.manufacturer=manufacturer;
        this.powersupply=powerSupply;
        this.dimensions=dimensions;
    }
    public void powerUp(){
        System.out.println("case powering up.. ");
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getPowersupply() {
        return powersupply;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
