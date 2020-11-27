package data;

import data.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroceryList {

    private String type;
    private ArrayList<Product> products;

    public GroceryList() {
        type="Shopping";
        products=new ArrayList<>();
    }
    public GroceryList(String type, Product product) {
        this.type=type;
        products=new ArrayList<>();
        products.add(product);
        print();
    }

    /**
     * creating array list with {add}
     * */
    public GroceryList(String type, Product product1, Product product2) {

        this.type=type;
        products=new ArrayList<>(){{add(product1);add(product2);}};
        print();
    }

    /**
     * creating array list with List of
     * */
    public GroceryList(String type, Product[] list) {

        this.type=type;
        products=new ArrayList<>(List.of(list));
        print();
    }

    /**
     * creating array list from a List
     * */
    public GroceryList(String type, Product product1, Product product2, Product product3) {

        this.type=type;
        products=new ArrayList<>(Arrays.asList(product1,product2,product3));
        print();
    }

    /**
     * creating an array list from an Arraylist
     * */
    public GroceryList(String type, ArrayList<Product> list) {

        this.type=type;
        products = new ArrayList<>();
        products.addAll(list);
        print();
    }






    public ArrayList<Product> getProducts() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
        print();
    }

    void print() {
        System.out.println(type+" list");
        System.out.println("==============");
        for(int i=0;i<getProducts().size();i++){
            Product prod=products.get(i);
            System.out.println(prod.getQuantity()+" "+prod.getName());
        }
        System.out.println();
    }

    public void update(String product, int quantity) {
        for(int i=0;i<products.size();i++){
            Product prod = products.get(i);
            if (prod.getName().equalsIgnoreCase(product)){
                prod.setQuantity(quantity);
                products.set(i,prod);
                System.out.println("Updated quantity of "+prod.getName()+" to "+prod.getQuantity());
                print();
                break;
            }
        }


    }

    public void remove(String productName) {
        for(int i=0;i<products.size();i++){
            Product prod = products.get(i);
            if(prod.getName().equalsIgnoreCase(productName)){
                products.remove(prod);
                System.out.println("Removed "+productName);
                System.out.println();
                print();
                break;
            }

        }

    }

    public int check(String productName) {
        for(int i=0;i<products.size();i++){
            Product prod = products.get(i);
            if(prod.getName().equalsIgnoreCase(productName)){
                int quantity=prod.getQuantity();
                System.out.println("There's "+quantity+" of "+prod.getName());
                System.out.println();
                return quantity;
            }
        }
        System.out.println(productName+" is not in the grocery list.");

        return 0;
    }

}
