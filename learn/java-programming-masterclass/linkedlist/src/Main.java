import data.Album;
import data.Song;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    /**Inserts and deletions can be slow with arraylists.
     * Linked lists store a value and a pointer to the
     * next element in the list
     */
    public static void main(String[] args) {

        challenge();
    }

    private static void challenge() {

        MusicPlayer player = new MusicPlayer();
        player.run();

    }

    private static void exampleDoublyLinkedList(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()){
            System.out.println("Nowhere to visit");
        }
        else {
            System.out.println("Now visiting "+listIterator.next());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holiday over");
                    quit=true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting "+listIterator.next());
                    }
                    else{
                        System.out.println("End of list.");
                        goingForward=false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward=false;
                    }
                    if (listIterator.hasPrevious()) {

                        System.out.println("Now visiting "+listIterator.previous());
                    }
                    else{
                        System.out.println("You're reached the beginning of your list.");
                        goingForward=true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("Actions available");
        System.out.println("0-Quit\n" +
                "1-Next Destination\n" +
                "2-Previous Destination\n" +
                "3-Print Menu options.");
    }

    private static void exampleLinkedListOrderedInsert() {


        LinkedList<String> citiesToVisit=new LinkedList<>();
        addInOrder(citiesToVisit,"London");
        addInOrder(citiesToVisit, "Paris");
        addInOrder(citiesToVisit, "Berlin");
        addInOrder( citiesToVisit,"Seoul");
        addInOrder(citiesToVisit,"Monrovia");
        print(citiesToVisit);
    }

    private static void example() {
        LinkedList<String> citiesToVisit=new LinkedList<>();
        citiesToVisit.add("London");
        citiesToVisit.add("Paris");
        citiesToVisit.add("Berlin");
        print(citiesToVisit);
        citiesToVisit.add(0,"New York");
        print(citiesToVisit);
        citiesToVisit.remove(3);
        print(citiesToVisit);
    }

    private static boolean addInOrder(LinkedList<String> list, String city) {
        ListIterator<String> listIterator = list.listIterator();

        while (listIterator.hasNext()){
            int comparison = listIterator.next().compareToIgnoreCase(city);
            if(comparison==0){
                System.out.println(city+" already in the list. Not added.");
                return false;
            }
            else{
                if(comparison>0){
                    listIterator.previous();
                    listIterator.add(city);
                    return true;
                }
            }
        }
        listIterator.add(city);
        return true;

    }

    private static void print(LinkedList<String> list){
        Iterator<String> iterator = list.iterator();
        System.out.println();
        while (iterator.hasNext()){
            System.out.println("I want to visit "+iterator.next());
        }
    }
}
