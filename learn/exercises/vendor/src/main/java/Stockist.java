public interface Stockist {
    int checkStock(int itemCode);

    Item get(int itemCode, int i);
}
