package adventure;

import java.util.HashMap;
import java.util.List;
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

        int loc = -1;
        Map<Integer,AdventureLocation> locations = Adventure.createLocations();
        while(true){
            if(loc==0){
                break;
            }
            else{
                System.out.println("Please choose where you want to go from options below.");
                loc = getValidLocationID(userInput.nextLine());
                System.out.println(loc);

            }
        }
    }

    private static int getValidLocationID(String userInput) {
        Map<String, String> transformedChoices = Map.of("West","W","East","E","South","S","North","N","Quit","Q");
        String[] validChoices = {"W","N","S","E"};
        String loc=null;


        for(String input: userInput.split(" ")){

            for(String in: validChoices){
                if(in==input){
                    //return do something with the loc
                }
            }
            if(transformedChoices.keySet().contains(input)){
                //return transformedChoices.get(input);//do something with loc
            }
        }
        return 0;
    }

    private static void printOptions() {
        System.out.println("Please select where you want to go from the options below:");
    }
}
