package adventure;

import java.util.Map;
import java.util.Scanner;

/***
 *         // Change the program to allow players to type full words, or phrases, then move to the
 *         // correct location based upon their input.
 *         // The player should be able to type commands such as "Go West", "run South", or just "East"
 *         // and the program will move to the appropriate location if there is one.  As at present, an
 *         // attempt to move in an invalid direction should print a message and remain in the same place.
 *         // Single letter commands (N, W, S, E, Q) should still be available.
 * **/
public class AdventureGameChallenge {
    private static Scanner userInput;

    public static void run() {
        userInput = new Scanner(System.in);
        String[] validChoices = {"W","N","S","E"};

        int loc = 1;
        Map<Integer,AdventureLocation> locations = Adventure.createLocations();
        while(true){
            if(loc==0){
                break;
            }
            else{
                System.out.println("Please choose where you want to go from options below.");
                String choice = userInput.nextLine();

                String direction = getDirection(choice);

                if(direction!=null){
                    Map<String,Integer> exits = locations.get(loc).getExits();
                    if(exits.containsKey(direction)){
                        loc=exits.get(direction);
                    }
                    else{
                        System.out.println("you cannot go that direction.");
                    }
                }
                else{
                    System.out.println("Direction "+choice+" is invalid.");
                }


            }
        }
    }

    private static String getDirection(String userInput) {
        Map<String, String> transformedChoices = Map.of("WEST","W","EAST","E","SOUTH","S","NORTH","N","QUIT","Q");



        for(String input: userInput.split(" ")){
            String direction =null;
            String upperInput=input.toUpperCase();
            if(transformedChoices.keySet().contains(upperInput)){
                direction= transformedChoices.get(upperInput);
            }
            else {
                direction=getValidDirection(upperInput);
            }
            if(direction!=null){
                return direction;
            }
        }
        return null;
    }

    private static String getValidDirection(String text){
        String validChoice=null;
        String[] validChoices = {"W","N","S","E"};
        for(String letter: validChoices){
            if(letter==text){
                //return do something with the loc
                validChoice=letter;
            }
        }
        return validChoice;
    }

    private static void printOptions() {
        System.out.println("Please select where you want to go from the options below:");
    }
}
