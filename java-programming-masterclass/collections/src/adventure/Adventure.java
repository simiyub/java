package adventure;

import adventure.AdventureLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        //demoMap();
        AdventureGameChallenge.run();
    }

    private static void demoMap() {
        processUserRequest(createLocations());
    }

    private static void processUserRequest(Map<Integer, AdventureLocation> locations) {
        Scanner userInput = new Scanner(System.in);
        int loc = 1;
        while (true){
            System.out.println(locations.get(loc).getDescription());

            if(loc==0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Exits Available are "+ exits.keySet());
            System.out.println();

            String direction = userInput.nextLine().toUpperCase();
            if(exits.containsKey(direction)){
                loc=exits.get(direction);
            }
            else{
                System.out.println("you cannot go that direction.");
            }
        }
    }

     static Map<Integer, AdventureLocation> createLocations() {
        Map<Integer,AdventureLocation> locations = new HashMap<>();
        AdventureLocation location = new AdventureLocation(1, "adventure.Adventure");
        location.addExit("West", 1);
        locations.put(-1,new AdventureLocation(-1,"You are sitting in front of the computer learning Java."))   ;
        locations.put(0,new AdventureLocation(0,"Exit Adventure."));
        locations.put(1, new AdventureLocation(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new AdventureLocation(2, "You are at the top of a hill."));
        locations.put(3,new AdventureLocation(3,"You are inside a building, a well house for a small spring"));
        locations.put(4,new AdventureLocation(4, "You are in a valley beside a stream."));
        locations.put(5, new AdventureLocation(5, "You are in the forest."));

        addLocationExits(locations);
        return locations;
    }

    private static void addLocationExits(Map<Integer, AdventureLocation> locations) {
        locations.get(1).addExit("W",2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N",5);
        locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W" ,2);
        locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        locations.get(5).addExit("Q", 0);
    }

}
