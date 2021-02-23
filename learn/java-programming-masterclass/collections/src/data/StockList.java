package data;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String,StockItem> list;
    public static final String INCREASE = "INCREASE";
    public static final String REDUCE = "REDUCE";

    public StockList() {
        list = new LinkedHashMap<>();
    }

    public StockItem add(StockItem item) {
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

    public StockItem adjustStock(String item, float quantity, String action) {
        if(quantity>0){
            if(action.equalsIgnoreCase(REDUCE)) {
                System.out.println("Reducing stock..");
            }
            StockItem inStock = list.getOrDefault(item,null);
            if(inStock!=null){
                System.out.println("Current stock level: "+inStock);

                if(action.equalsIgnoreCase(REDUCE) && inStock.getQuantity()>=quantity){
                    System.out.println("Reducing stock..");
                    inStock.adjustStock(-quantity);
                }
                if(action.equalsIgnoreCase(INCREASE) && inStock.getQuantity()>=quantity){
                    System.out.println("Increasing stock..");
                    inStock.adjustStock(quantity);
                }

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

    public void print(){
        System.out.println(list);
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
