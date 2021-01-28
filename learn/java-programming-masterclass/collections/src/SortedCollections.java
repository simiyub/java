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
         * 1. Add more of an item to a shopping basket
         * 2. Reduce quantity of an item from a shopping basket
         * 3. Remove an item from a shopping basket
         * 4. Check if the basket quantity can be adjusted up and down
         * 5. Make changes so any basket adjustments adjust stock level accordingly
         * */
    }



    private static ShoppingBasket getBasket(String james) {
        return new ShoppingBasket("James");
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

//    private static void updateItemQuantity(double quantity) {
//
//
//
//        ShoppingBasket basket = new ShoppingBasket("James");
//
//        //Add new item
//        StockItem buyItem = new StockItem("buyItem", 10.5, 10);
//
//
//        //Remove item
//      //  basket.removeItem();
//
//        //Add more
//     //   basket.addMoreQuantity();
//
//        //Buy less
//     //   basket.removeQuantity();
//
//        StockItem removedStockItem1= reduceStock("Item1",5);
//        if(removedStockItem1!=null){
//            basket.updateBasket(removedStockItem1);
//        }
//
//        StockItem removedStockItem2= reduceStock("Item1",2);
//        if(removedStockItem2!=null){
//            basket.updateBasket(removedStockItem2);
//        }
//
//        System.out.println(basket);
//
//        System.out.println(stockList.toString());
//    }

    private static void buyItem(String shopperName, String itemName, float quantity) {
        ShoppingBasket basket;
        StockItem item = reduceStock(itemName,quantity);
        if(item!=null){

            if(baskets.contains(shopperName)){
                for(ShoppingBasket bk: baskets){
                    if(bk.equals(new ShoppingBasket(shopperName))){
                        bk.addItem(item);
                    }
                }
            }
            else{
                basket = new ShoppingBasket(shopperName);
                basket.addItem(item);
                baskets.add(basket);
            }
        }
        else{
            System.out.println("Item not available.");
        }

    }

    private static void removeItem(String shopperName, String item){

    }

    private static void buyMore(String shopperName, String item, int quantity) {

    }

    private static void buyLess(String shopperName, String item, int quantity) {

    }

}
