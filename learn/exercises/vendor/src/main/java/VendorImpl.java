public class VendorImpl implements Vendor {
    Stockist stockist;
    public VendorImpl(){
        stockist = new StockistImpl();
    }

    public Item vend(int itemCode, int quantity) {
        Item item = stockist.get(itemCode, quantity);
        System.out.println("Vending "+quantity+" of "+item.getName());
        return item;
    }

    public int checkStock(int itemCode) {
        return stockist.checkStock(itemCode);
    }
}
