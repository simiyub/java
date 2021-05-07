import java.util.HashMap;
import java.util.Map;

public class StockistImpl implements Stockist {
    Map <Integer,Item> stock;
    public StockistImpl(){
        stock = new HashMap();
        stock.put(1,new Item(1,"Coke", 1));
        stock.put(2, new Item(2,"Crisps",2));
    }
    public int checkStock(int itemCode) {
        Item item = stock.get(itemCode);
        return item!=null ? item.getQuantity() : 0;
    }

    public Item get(int itemCode, int quantity) {
        Item item = stock.get(itemCode);
        if (item.getQuantity() >= quantity) {
            Item boughtItem = new Item(item.getItemCode(), item.getName(), quantity);
            if(item.getQuantity() - quantity > 0 ){
                stock.replace(itemCode,
                        stock.get(itemCode),
                        new Item(item.getItemCode(), item.getName(), item.getQuantity() - quantity)
                );
            }
            else{
                stock.remove(itemCode);
            }
            return boughtItem;
        }
        else{
            System.out.println("Only "+item.getQuantity()+" left");
        }
        return null;
    }
}
