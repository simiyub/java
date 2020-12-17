import data.StockItem;
import data.StockList;

public class SortedCollections {

    public static void main(String[] args) {
        StockList list = new StockList();
       list.addStock(new StockItem("Item1", 23.5, 0));
       list.sellStock("Item1", 5);
       list.get("Item1");
        System.out.println(list.items().toString());
    }

}
