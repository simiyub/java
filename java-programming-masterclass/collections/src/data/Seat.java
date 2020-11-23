package data;

import java.util.*;


public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private final double price;
        private boolean reserved=false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public boolean reserve() {
            if(this.isReserved()) {
                System.out.println("Seat already reserved.");
                return false;
            }
            this.reserved = true;
            System.out.println("seat "+seatNumber+ " reserved");
            return isReserved();
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean isReserved() {
            return reserved;
        }

        public boolean cancel(){
            if(!reserved){
                System.out.println("Did not cancel as seat is not reserved");
                return false;
            }
            this.reserved=false;
            System.out.println("reservation cancelled");
            return isReserved();
        }

        public double getPrice() {
            return price;
        }

    public static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            return seat1.getPrice() < seat2.getPrice() ? -1 :
                    seat1.getPrice() > seat2.getPrice() ? 1 :
                            0;
        }
    };

        @Override
        public String toString() {
            return this.getSeatNumber()+" £"+this.getPrice();
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
