import data.ShoppingBasket;
import data.StockItem;
import data.StockList;

public class SortedCollections {

    private static StockList stockList;
    public static void main(String[] args) {

        stockList = new StockList();

        //Adding new item
        StockItem buyItem1 = new StockItem("item1", 23.5, 14);
        stockList.addStock(buyItem1);

        //remove existing item
        stockList.removeStock("item1",4);

        //Add more of an item
        StockItem buyItem2 = new StockItem("item1", 23.5, 6);
        stockList.addStock(buyItem2);

        //remove an item that doesn't exist

        stockList.removeStock("missingItem",4);

        ShoppingBasket basket = new ShoppingBasket("James");

        //Add new item
        StockItem buyItem = new StockItem("buyItem", 10.5, 10);

        buyItem(basket,buyItem);

        StockItem lessItem = new StockItem("lessItem", 10.5, 10);
        stockList.addStock(lessItem);
        lessOfItem(new StockItem(lessItem.getName(),lessItem.getPrice(),2));

        moreOfItem();

        removeItem();



        /**
         * Next:
         * 1. Check if the basket quantity can be adjusted up and down
         * 2. Make changes so any basket adjustments adjust stock level accordingly
         * */
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

        StockItem removedStockItem1=stockList.removeStock("Item1",5);
        if(removedStockItem1!=null){
            basket.updateBasket(removedStockItem1);
        }

        StockItem removedStockItem2=stockList.removeStock("Item1",2);
        if(removedStockItem2!=null){
            basket.updateBasket(removedStockItem2);
        }

        System.out.println(basket);

        System.out.println(stockList.toString());
    }

    private static void buyItem(ShoppingBasket basket, StockItem item) {

        StockItem added = stockList.addStock(item);
        if(added!=null){
            basket.addItem(item);
        }
        else{
            System.out.println("Item not available.");
        }

    }

}
