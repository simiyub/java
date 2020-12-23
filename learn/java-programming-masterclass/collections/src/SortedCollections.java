import data.ShoppingBasket;
import data.StockItem;
import data.StockList;

public class SortedCollections {

    public static void main(String[] args) {
        StockList list = new StockList();
       list.addStock(new StockItem("Item1", 23.5, 14));
       list.sellStock("Item1", 2);
       list.get("Item1");
        System.out.println(list.items().toString());
        System.out.println(list.toString());

        ShoppingBasket basket = new ShoppingBasket("James");
        StockItem soldItem=list.sellStock("Item1",10);
        if(soldItem!=null){
            basket.addToBasket(soldItem);
        }
        System.out.println(basket);

        System.out.println(list.toString());

        /**
         * Next:
         * 1. Check if the basket quantity can be adjusted up and down
         * 2. Make changes so any basket adjustments adjust stock level accordingly
         * */
    }

}
