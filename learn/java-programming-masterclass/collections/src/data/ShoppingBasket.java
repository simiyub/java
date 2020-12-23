package data;

import java.util.*;

public class ShoppingBasket {
    private final String name;
    private final Set<StockItem> items;

    public ShoppingBasket(String name) {
        this.name = name;
        this.items = new HashSet<>();
    }

    public boolean addToBasket(StockItem item) {
        boolean added = false;
        if(item!=null && item.getQuantity()>0){
            boolean removed = items.removeIf( dependency -> dependency==item);
            added = items.add(item);
            if(removed){
                System.out.println("updated quantity of "+item.getName()+" to "+item.getQuantity());
            };

        }
        else{
            System.out.println("Item "+item.getName() +" not added ");
        }
        return added;
    }

    public Set<StockItem> getItems() {
        return Collections.unmodifiableSet(items);
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
