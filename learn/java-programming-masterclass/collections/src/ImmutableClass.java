import adventure.AdventureLocation;

import java.util.HashMap;
import java.util.Map;

import static adventure.Adventure.processUserRequest;

public class ImmutableClass {

    public static void main(String[] args) {
        demoImmutability();
    }

    private static void demoImmutability() {
        processUserRequest(createLocations());
    }

    private static Map<Integer, AdventureLocation> createLocations() {
        Map<Integer,AdventureLocation> locations = new HashMap<>();
        locations.put(0,new AdventureLocation(0,"You are sitting in front of the computer learning Java.",getExits(0)));
        locations.put(1, new AdventureLocation(1, "You are standing at the end of a road before a small brick building",getExits(1)));
        locations.put(2, new AdventureLocation(2, "You are at the top of a hill.", getExits(2)));
        locations.put(3,new AdventureLocation(3,"You are inside a building, a well house for a small spring", getExits(3)));
        locations.put(4,new AdventureLocation(4, "You are in a valley beside a stream.", getExits(4)));
        locations.put(5, new AdventureLocation(5, "You are in the forest.",getExits(5)));
        return locations;
    }

    private static Map<String, Integer> getExits(Integer roomNumber) {
        Map<String, Integer> exits = new HashMap<>();
        exits.put("Q", 0);

        switch (roomNumber){
            case(0):
                break;
            case(1):
                exits.put("W",2);
                exits.put("E", 3);
                exits.put("S", 4);
                exits.put("N",5);
                break;
            case (2):
                exits.put("N", 5);
                break;
            case (3):
                exits.put("W", 1);
                break;
            case(4):
                exits.put("N", 1);
                exits.put("W" ,2);
                break;
            case(5):
                exits.put("S", 1);
                exits.put("W", 2);
                break;
            default:
                System.out.println("invalid room number:"+roomNumber);
                break;
        }
        return exits;
    }

}
