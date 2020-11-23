package data;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats;

    public Theatre(String name, int numRows, int seatsPerRow) {
        this.theatreName = name;
        int lastRow = 'A'+(numRows-1);
        seats = new ArrayList<>();
        for(char row='A'; row<=lastRow;row++){
            for(int seatNum=1; seatNum<=seatsPerRow;seatNum++){
                boolean bestView = (row<'D' && (seatNum >=4 && seatNum<=9));
                boolean restrictedView = (row > 'F' || (seatNum<4 || seatNum>9));
                double price = bestView ? 14 : restrictedView ? 7 : 12;
                seats.add(new Seat(row+String.format("%02d", seatNum), price));
            }
        }

    }

    public String getTheatreName() {
        return theatreName;
    }

    public Collection <Seat> getSeats() {
        return seats;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber, 0);
        int index = Collections.binarySearch(seats,requestedSeat,null);

        //This is the function called when we call Collections.binarySearch
        //int index = indexedBinarySearch(seats,requestedSeat);

        if(index >=0){
            return seats.get(index).reserve();
        }



        //With Collections.binarySearch we can replace this for loop and is more efficient
//        for (Seat seat:seats){
//            count+=1;
//            if(seat.getSeatNumber().equals(seatNumber) && !seat.isReserved()){
//                processPayment();
//                System.out.println(count+" loops");
//                return seat.reserve();
//            }
//        }
        System.out.println("Seat not available.");
        return false;

    }

    /***
     * Copied over from Java source to demo loop count
     * */

    private static <T>
    int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size()-1;
        int count = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);
            count ++;

            if (cmp < 0) {
                low = mid + 1;
            }
            else if (cmp > 0) {
                high = mid - 1;
            }
            else {
                System.out.println(count+" iterations.");
                return mid; // key found
            }
        }
        System.out.println(count+" iterations.");
        return -(low + 1);  // key not found
    }


    private void processPayment() {
        System.out.println("Please pay");
    }

    public void showSeats(){
        List<Seat> available  = new ArrayList<>();
        for(Seat seat:seats){
            if (!seat.isReserved()){
                available.add(seat);
            }
        }
            System.out.println("Available Theatre seats:"+available.toString());
    }
}
