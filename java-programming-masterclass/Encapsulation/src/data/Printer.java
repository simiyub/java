package data;

public class Printer {
    private final String make;
    private final String model;
    private final boolean isColour;
    private Toner toner;
    private int printedPages=0;

    public Printer(String make, String model, boolean isColour) {
        this.make=make;
        this.model=model;
        this.isColour=isColour;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean isColour() {
        return isColour;
    }

    public int getPrintedPages() {
        return printedPages;
    }

    public void addToner(Toner toner) {
        this.toner=toner;
        System.out.println("Added "+toner.getColour()+" toner.");
    }

    public void print(int pages) {
        double tonerToBeUsed=(pages*0.001);
        if(tonerLevel()>=tonerToBeUsed) {
            printedPages = printedPages + pages;

            toner.setLevel(toner.getLevel() - tonerToBeUsed);
            System.out.println("Printed " + pages);
            System.out.println("Total pages printed now is " + getPrintedPages());
            System.out.println("Toner used here is " + tonerToBeUsed);
            System.out.println("Toner level now " + tonerLevel());
        }
        else{
            System.out.println("Not enough toner to print "+pages+" pages");
        }
    }

    private double tonerLevel() {
        return toner.getLevel();
    }
}
