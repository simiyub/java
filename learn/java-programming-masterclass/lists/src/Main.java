
import data.GroceryList;
import data.GroceryShoppingApp;
import data.Product;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static Scanner userInput;
    private GroceryShoppingApp shop;
    public static void main(String[] args) {
        exampleArrayList();
        exampleGroceryList();
        //remove multiple
        //update multiple
        GroceryShoppingApp groceryApp=new GroceryShoppingApp();
        groceryApp.run();
    }

    private static void exampleGroceryList() {
        Product product = new Product("tomatoes", 2);
        GroceryList oneItemGroceryList = new GroceryList("Vegetable",new Product("tomatoes", 2));
        GroceryList twoItemGroceryList = new GroceryList("Vegetable",new Product("onion", 1), new Product("mushroom", 1));
        GroceryList cupboardProductsGroceryList = new GroceryList("Cupboard",
                new Product[]{new Product("bread", 1),
                        new Product("milk", 1),
                        new Product("eggs", 6),
                        new Product("bag of nuts", 2),
                        new Product("jar of sauce", 1)});
        GroceryList fruitsGroceryList = new GroceryList("Fruit",new Product("oranges", 5), new Product("bananas", 3), new Product(" Pack of grapes", 1));
        ArrayList<Product> frozenProducts= new ArrayList<>();
        frozenProducts.add(new Product("ice cream cone", 4));
        frozenProducts.add(new Product("Pack frozen fruits", 2));
        frozenProducts.add(new Product("Pack of frozen fish",1));
        GroceryList frozenFoodGroceryList=new GroceryList("Frozen products", frozenProducts);
        cupboardProductsGroceryList.update("eggs",4);
        frozenFoodGroceryList.remove("Pack frozen fruits");
        cupboardProductsGroceryList.check("bag of nuts");
    }

    private static void exampleArrayList() {

        //ArrayList Resize automatically.
        ArrayList<String> list = new ArrayList<>();
        list.add("Peter");
        System.out.println(list);
        list.set(0,"Henry");
        System.out.println(" contains Peter= "+list.contains("Peter"));
        System.out.println(list);
        list.add("George");
        System.out.println(" George is at index:"+list.indexOf("George"));
        list.remove(0);
        System.out.println(list);
    }


}
