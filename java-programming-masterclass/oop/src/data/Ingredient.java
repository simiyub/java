package data;

public class Ingredient {
    private final String name;
    private int quantity;
    private double price;

    public Ingredient(String name, int quantity) {
        this.name=name;
        this.quantity=quantity;
        this.price=Pricer.getPrice(name)*quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
