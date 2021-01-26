import data.ShoppingBasket;
import data.StockItem;
import data.StockList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortedCollections {

    private static StockList stockList;
    private static Set<ShoppingBasket> baskets;
    public static void main(String[] args) {

        stockList = new StockList();
       baskets = new HashSet<>();

        //Adding new item
        boolean added = addItem("item1", 23.5, 14);

        //Removing item
        boolean removed = removeItem("item1");

        //Reducing stock
        stockList.reduceStock("item1",4);

        //Add more stock
        StockItem buyItem2 = new StockItem("item1", 23.5, 6);

        stockList.addStock(buyItem2);

        //Remove an item that doesn't exist
        stockList.reduceStock("missingItem",4);


        //add item for a new shopper
        addItem("newShopperItem", 3.5, 10);
        buyItem("newShopper", "newShopperItem", 5);


        //add item for an existing shopper
        addItem("existingShopperItem", 23.5, 14);
        buyItem("existingShopper", "existingShopperItem", 5);
        buyItem("existingShopper", "existingShopperItem", 1);

        //Add more of an item

        //Reduce quantity of an item

        //Remove an item




        /**
         * Next:
         * 1. Check if the basket quantity can be adjusted up and down
         * 2. Make changes so any basket adjustments adjust stock level accordingly
         * */
    }

    private static ShoppingBasket getBasket(String james) {
        return new ShoppingBasket("James");
    }

    private static boolean removeItem(String itemName) {
        return stockList.remove(itemName);
    }

    private static boolean addItem(String itemName, double price, int quantity) {
        StockItem buyItem1 = new StockItem(itemName, price, quantity);
        StockItem item = stockList.addStock(buyItem1);
        return item!=null;
    }

    private static void lessOfItem(StockItem item) {

        updateItemQuantity(2);
    }

    private static void updateItemQuantity(double quantity) {



        ShoppingBasket basket = new ShoppingBasket("James");

        //Add new item
        StockItem buyItem = new StockItem("buyItem", 10.5, 10);


        //Remove item
      //  basket.removeItem();

        //Add more
     //   basket.addMoreQuantity();

        //Buy less
     //   basket.removeQuantity();

        StockItem removedStockItem1=stockList.reduceStock("Item1",5);
        if(removedStockItem1!=null){
            basket.updateBasket(removedStockItem1);
        }

        StockItem removedStockItem2=stockList.reduceStock("Item1",2);
        if(removedStockItem2!=null){
            basket.updateBasket(removedStockItem2);
        }

        System.out.println(basket);

        System.out.println(stockList.toString());
    }

    private static void buyItem(String shopperName, String ItemName, float quantity) {
        if(!baskets.contains(shopperName)){
            baskets.add(new ShoppingBasket(shopperName));
        }
        StockItem added = stockList.addStock(item);
        if(added!=null){
            basket.addItem(item);
        }
        else{
            System.out.println("Item not available.");
        }

    }

}
