package adventure;

import adventure.AdventureLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Map<Integer,AdventureLocation> locations = new HashMap<>();
        AdventureLocation location = new AdventureLocation(1, "adventure.Adventure");
        location.addExit("West", 1);
        locations.put(0,new AdventureLocation(0,"You are sitting in front of the computer learning Java."));
        locations.put(1, new AdventureLocation(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new AdventureLocation(2, "You are at the top of a hill."));
        locations.put(3,new AdventureLocation(3,"You are inside a building, a well house for a small spring"));
        locations.put(4,new AdventureLocation(4, "You are in a valley beside a stream."));
        locations.put(5, new AdventureLocation(5, "You are in the forest."));

        int loc = 1;
        while (true){
            System.out.println(locations.get(loc).getDescription());

            if(loc==0){
                break;
            }
            loc = userInput.nextInt();
            if(!locations.containsKey(loc)){
                System.out.println("You cannot go in that direction.");
            }
        }
    }

}
