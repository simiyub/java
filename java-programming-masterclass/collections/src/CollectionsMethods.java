import data.Seat;
import data.Theatre;

import java.util.*;
import java.util.Collections;

/**
*Demo some useful Collections methods
**/

public class CollectionsMethods {

    private static ArrayList<Seat> manipulatedSeatList;
    public static void demo() {
        Theatre theatre = new Theatre("Theatre 1", 25,  10);
            manipulatedSeatList = new ArrayList<>(theatre.getSeats());
            printManipulatedSeatList(null);
            manipulatedSeatList.get(1).reserve();
            if(theatre.reserveSeat("A02")){
                System.out.println("Pay");
            }
            else{
                System.out.println("Seat not available");
            }

            theatre.showSeats();

            Collections.reverse(manipulatedSeatList);
            printManipulatedSeatList("reversed");

            Collections.shuffle(manipulatedSeatList);
            printManipulatedSeatList("shuffled");
            System.out.println("min seat"+Collections.min(manipulatedSeatList));
            System.out.println("max seat"+Collections.max(manipulatedSeatList));

            sortList(manipulatedSeatList);
            printManipulatedSeatList("sorted");




    }

    private static void sortList(List<? extends Seat> list) {
        for(int i=0; i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).compareTo(list.get(j))>0){
                    Collections.swap(list,i,j);
                }
            }
        }
    }

    private static void printManipulatedSeatList(String action) {
        if(action!=null){
            System.out.println("Seat copy "+action+":"+manipulatedSeatList);
        }
        else{
            System.out.println("Seat copy:"+manipulatedSeatList);
        }

    }
}
