package data;

public class Motherboard {
    private final String model;
    private final String manufacturer;
    private final int ramSlots;
    private final int cardSlots;
    private final String bios;

    public Motherboard(String model, String manufacturer, int ramSlots, int cardSlots, String bios) {
        this.model=model;
        this.manufacturer=manufacturer;
        this.ramSlots=ramSlots;
        this.cardSlots=cardSlots;
        this.bios=bios;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public int getCardSlots() {
        return cardSlots;
    }

    public String getBios() {
        return bios;
    }

    public void loadProgram(String program) {
        System.out.println("motherboard loading "+program+"..");
    }
}
