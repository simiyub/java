package data;

import java.util.Scanner;

public class GroceryShoppingApp {
    GroceryList groceryList;
    private Scanner userInput;
    public GroceryShoppingApp(){
         groceryList = new GroceryList();
        userInput = new Scanner(System.in);
    }

    public void run() {
        boolean quit = false;
        while(!quit){
            System.out.println("Please select action you require from list below");
            printInstructions();
            System.out.println("Action:");
            int choice = userInput.nextInt();
            userInput.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printGroceryList();
                    break;
                case 2:
                    searchItem();
                    break;
                case 3:
                    addItem();
                    break;
                case 4:
                    updateItem();
                    break;
                case 5:
                    removeItem();
                    break;
                case 6:
                    quit=true;
                    break;
                default:
                    System.out.println("No valid action requested.");
                    quit=true;
                    break;
            }
        }
    }

    private void removeItem() {
            System.out.println("Please enter an item name to remove:");
            String name = userInput.nextLine();
            groceryList.remove(name);
    }

    private void updateItem() {
        System.out.println("Please enter an item name to update:");
        String name = userInput.nextLine();
        System.out.println("How many do you want left on your list?");
        int quantity = userInput.nextInt();
        groceryList.update(name,quantity);
    }

    private void searchItem() {
        System.out.println("Please enter an item name to search:");
        String name = userInput.nextLine();
        groceryList.check(name);
    }

    private void addItem() {
        System.out.println("Please enter an item name to add:");
        String name = userInput.nextLine();
        System.out.println("How many do you need.");
        int quantity = userInput.nextInt();
        groceryList.add(new Product(name,quantity));
    }

    private void printGroceryList() {
        groceryList.print();
    }

    private void printInstructions() {
        System.out.println("0 - Print Instructions.\n" +
                "1 - Print Grocery List.\n" +
                "2 - Search for an Item.\n" +
                "3 - Add Item.\n" +
                "4 - Update Item.\n" +
                "5 - Remove Item.\n" +
                "6 - Quit.\n"+
                "");
    }


}
