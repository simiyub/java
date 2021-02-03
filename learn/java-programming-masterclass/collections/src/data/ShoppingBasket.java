package data;

import java.util.*;

public class ShoppingBasket {
    private final String name;
    private final Set<StockItem> items;

    public ShoppingBasket(String name) {
        this.name = name;
        this.items = new HashSet<>();
    }

    public boolean updateBasket(StockItem item) {
        boolean added = false;
        if(item!=null){
            boolean removed = items.removeIf( dependency -> dependency==item);

            if(item.getQuantity()!=0){
                added = items.add(item);
            }

            if(removed){
                if(item.getQuantity()==0){
                    System.out.println("item removed from from basket");
                }
                else{
                    System.out.println("updated quantity of "+item.getName()+" to "+item.getQuantity());
                }
            }

        }
        else{
            System.out.println("Item is null");
        }
        return added;
    }

    public boolean addItem(StockItem stockItem) {
        boolean added = items.add(stockItem);
        System.out.println("Added "+stockItem.getName()+" to basket.");
        System.out.println(this.toString());
        return added;
    }

    public StockItem removeItem(StockItem stockItem) {

        for(StockItem item : items){
            if(item ==stockItem){
                StockItem toRemove = new StockItem(item.getName(),item.getPrice(),item.getQuantity());
                items.remove(stockItem);
                System.out.println("Removed "+toRemove.getName()+" from basket.");
                return toRemove;
            }
        }
        return null;
    }

    public Set<StockItem> getItems() {
        return Collections.unmodifiableSet(items);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        else{
            return this.name.equalsIgnoreCase(((ShoppingBasket) obj).name);
        }

    }

    @Override
    public String toString() {
        String variableName = "*".repeat(name.length());
        String string = variableName+"******************\n"+name+"'s shopping basket\n"+"-".repeat(name.length())+"------------------\n";
        double totalCost = 0.0;
        for(StockItem item : items){
            string = string+item;
            totalCost+=item.getPrice()*item.getQuantity();
        }
        return string+"\n-----------------------\n Total cost = £"+totalCost+"\n=======================";
    }





}
