package data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {

    private final Map<String,StockItem> list;

    public StockList() {
        list = new HashMap<>();
    }

    public int addStock(StockItem item) {
        if(item!=null){
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock !=item){
                item.adjustStock(inStock.getQuantity());
            }
            list.put(item.getName(), item);
            return item.getQuantity();
        }
        return 0;
    }

    public StockItem sellStock(String item, int quantity) {
        if(quantity>0){
            StockItem inStock = list.getOrDefault(item,null);
            if(inStock!=null && inStock.getQuantity()>=quantity){
                inStock.adjustStock(-quantity);
                return new StockItem(inStock.getName(), inStock.getPrice(), quantity);
            }
            else {
                System.out.println("Could not sell "+item);
            }
        }

        return null;
    }

    public StockItem get(String itemName) {
        return list.get(itemName);
    }

    public Map<String, StockItem> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String stockList = "\n**************************\n     Stock List    \n--------------------------\n";
        double totalValue = 0;
        for (String itemName: list.keySet()){
            StockItem item = list.get(itemName);
            stockList += item.toString()+"\n";
            totalValue += item.getValue();
        }
        stockList += "-------------------------\n";
        stockList += "Total Stock Value = £"+totalValue+"\n";
        stockList += "=========================";
        return stockList;
    }
}
