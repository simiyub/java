package data;

public class Drink {
    private final String name;
    private int quantity;
    private final double price;

    public Drink(String name, int quantity) {
        this.name=name;
        this.quantity=quantity;
        this.price=this.quantity*Pricer.getPrice("coke");
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
