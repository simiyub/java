import data.ShoppingBasket;
import data.StockItem;
import data.StockList;

import java.util.HashSet;
import java.util.Set;

public class SortedCollections {

    private static StockList stockList;
    private static Set<ShoppingBasket> baskets;
    public static void main(String[] args) {

        stockList = new StockList();
       baskets = new HashSet<>();

        //Adding new item
        boolean added = addStockItem("item1", 23.5, 14);

        //Removing item
        boolean removed = removeStockItem("item1");

        //Reducing stock
        reduceStock("item1",4);

        //Add more stock
        StockItem buyItem2 = new StockItem("item1", 23.5, 6);

        stockList.add(buyItem2);

        //Remove an item that doesn't exist
       StockItem removedItem = reduceStock("missingItem",4);


        //add item for a new shopper
        addStockItem("newShopperItem", 3.5, 10);
        buyItem("newShopper", "newShopperItem", 5);


        //add item for an existing shopper
        addStockItem("existingShopperItem", 23.5, 14);
        buyItem("existingShopper", "existingShopperItem", 5);
        buyItem("existingShopper", "existingShopperItem", 1);

        buyMore("existingShopper", "existingShopperItem", 1);



        /**Outstanding:
         * -----------
         * Next:
         * 1. Add more of an item to a shopping basket - DONE
         * 2. Reduce quantity of an item from a shopping basket - DONE
         * 3. Remove an item from a shopping basket - DONE
         * 4. Check if the basket quantity can be adjusted up and down
         * 5. Make changes so any basket adjustments adjust stock level accordingly
         * */
    }

    private static StockItem getItem(String item){
        return stockList.get(item);
    }

    private static boolean removeStockItem(String itemName) {
        return stockList.remove(itemName);
    }

    private static boolean addStockItem(String itemName, double price, int quantity) {
        StockItem buyItem1 = new StockItem(itemName, price, quantity);
        StockItem item = stockList.add(buyItem1);
        return item!=null;
    }

    private static StockItem reduceStock(String itemName, float quantity) {

        return stockList.adjustStock(itemName,quantity, StockList.REDUCE);
    }

    private static StockItem increaseStock(String itemName, float quantity) {

        return stockList.adjustStock(itemName,quantity, StockList.INCREASE);
    }

    private static void buyItem(String shopperName, String itemName, float quantity) {

        StockItem item = reduceStock(itemName,quantity);
        if(item!=null){
            ShoppingBasket basket = getBasket(shopperName);
            basket.addItem(item);
            baskets.add(basket);
        }
        else{
            System.out.println("Item not available.");
        }

    }

    private static ShoppingBasket getBasket(String shopperName) {
        ShoppingBasket basket;
        if(baskets.contains(shopperName)){
            for(ShoppingBasket bk: baskets){
                if(bk.equals(new ShoppingBasket(shopperName))){
                    return bk;
                }
            }
        }
        return new ShoppingBasket(shopperName);

    }

    private static boolean removeItemFromBasket(String shopperName, String itemName){

        ShoppingBasket basket = getBasket(shopperName);
        StockItem basketItem = basket.removeItem(getItem(itemName));
        StockItem removed = increaseStock(basketItem.getName(), basketItem.getQuantity());
        return removed!=null;
    }

    private static boolean buyMore(String shopperName, String item, int quantity) {
        StockItem itemInStock = reduceStock(item,quantity);
        ShoppingBasket basket = getBasket(shopperName);
        return basket.addItem(itemInStock);
    }

    private static void buyLess(String shopperName, String itemName, int quantity) {
        ShoppingBasket basket = getBasket(shopperName);
        StockItem item = getItem(itemName);
        basket.removeItem(item);
        reduceStock(itemName,quantity);
    }

}
