package data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {

    private final Map<String,StockItem> list;

    public StockList() {
        list = new HashMap<>();
    }

    public StockItem addStock(StockItem item) {
        if(item!=null){
            System.out.println("Adding new stock..");
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock !=item){
                System.out.println(inStock.getName()+" in stock. Quantity="+inStock.getQuantity()+" adjusting quantity by "+item.getQuantity());
                item.adjustStock(inStock.getQuantity());
            }
            else{
                System.out.println(item.getName()+" not in stock. Adding..");
            }
            list.put(item.getName(), item);
            System.out.println("Stock level now: "+list.get(item.getName())+"\n");
            return item;
        }
        return null;
    }

    public boolean remove(String itemName) {
        boolean removed = false;
        if(list.containsKey(itemName)){
            System.out.println("removing "+itemName);
            list.remove(itemName);
            removed = true;
        }
        return removed;

    }

    public StockItem reduceStock(String item, int quantity) {
        if(quantity>0){
            System.out.println("Reducing stock..");
            StockItem inStock = list.getOrDefault(item,null);
            if(inStock!=null && inStock.getQuantity()>=quantity){
                System.out.println("Current stock level: "+inStock);
                inStock.adjustStock(-quantity);
                System.out.println("Stock level now: "+list.get(inStock.getName())+"\n");
                return new StockItem(inStock.getName(), inStock.getPrice(), quantity);
            }
            else {
                System.out.println(item+" does not exist. Could not reduce stock");
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
