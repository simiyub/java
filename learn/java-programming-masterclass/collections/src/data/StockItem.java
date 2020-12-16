package data;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantity;

    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setPrice(double price) {
        if(price>0){
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        if(quantity>0){
            this.quantity += quantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj ==  this? true :
                obj == null || (obj instanceof StockItem) ? false:
                        this.getName().equalsIgnoreCase(((StockItem)obj).getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode()+57;
    }

    @Override
    public int compareTo(StockItem o) {
        if(this==o){
            return 0;
        }
        if(o != null){
            return this.getName().compareToIgnoreCase(o.getName());
        }
        throw new NullPointerException("can't compare");
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
