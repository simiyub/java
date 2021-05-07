public class Item {
    private String name;
    private int itemCode, quantity;

    public Item(int itemCode, String name, int quantity) {
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.name= name;
    }
    public Item(int itemCode, int quantity) {
        this.itemCode = itemCode;
        this.quantity = quantity;
    }

    public int getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
