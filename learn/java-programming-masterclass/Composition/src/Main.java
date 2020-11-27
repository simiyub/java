import data.*;

import java.lang.module.ResolutionException;

public class Main {

    //models has a relationship.
    public static void main(String[] args) {
        example();
        challenge();
    }

    private static void challenge() {
        Room bedroom = new Room("bedroom",4,5,4);

        House house = new House(4,
                new Room("bedroom",4,5,8),
                new Room("livingRoom",6,7,8),
                new Room("kitchen",3,2,8),
                new Room("bathroom",2,1,8));
        house.describe();
    }

    private static void example() {
        Motherboard motherboard = new Motherboard("intel 10", "intel", 3,2,"UEFI");
        //monitor is composed of resolution
        Monitor monitor= new Monitor("samsung", "samsung", 21,new Resolution(1080,200));
        //Computer case has dimensions
        Case computerCase=new Case("intech", "intech", "main",new Dimensions(70,200,400));


        Computer computer = new Computer(computerCase,monitor,motherboard);
        computer.powerUp();
    }
}
