package data;

public class Sale implements Comparable<Sale> {
    private final String saleDate;
    private final Item item;
    private final String buyer;
    private final double sellingPrice;
    private Sale next;
    private Sale previous;

    private Sale(String saleDate, Item item, String buyer, double sellingPrice) {
        this.saleDate=saleDate;
        this.item=item;
        this.buyer=buyer;
        this.sellingPrice=sellingPrice;
    }

    public static Sale newSale(String saleDate, Item item, String buyer, double sellingPrice) {
        return new Sale(saleDate,item,buyer,sellingPrice);
    }

    public String getSaleDate() {
        return saleDate;
    }

    public Item getItem() {
        return item;
    }

    public String getBuyer() {
        return buyer;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public Sale getNext() {
        return next;
    }

    public void setNext(Sale next) {
        this.next = next;
    }

    public Sale getPrevious() {
        return previous;
    }

    public void setPrevious(Sale previous) {
        this.previous = previous;
    }

    @Override
    public int compareTo(Sale sale) {
        return this.sellingPrice>sale.sellingPrice ? 1
                : this.sellingPrice<sale.sellingPrice ? -1
                : 0;
    }
}
