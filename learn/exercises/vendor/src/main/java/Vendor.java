public interface Vendor {
    Item vend(int itemCode, int quantity);

    int checkStock(int itemCode);
}
