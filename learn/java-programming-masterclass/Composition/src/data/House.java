package data;

public class House {
    private final Room bedroom;
    private final Room livingRoom;
    private final Room kitchen;
    private final Room bathroom;
    private final int numberOfRooms;

    public House(int numberOfRooms, Room bedroom, Room livingRoom, Room kitchen, Room bathroom) {
        this.bedroom=bedroom;
        this.livingRoom =livingRoom;
        this.kitchen=kitchen;
        this.bathroom=bathroom;
        this.numberOfRooms=numberOfRooms;
    }

    public void describe() {
        System.out.println("This is a house with "+numberOfRooms+" rooms.");
        printRoomSize(livingRoom);
        printRoomSize(bedroom);
        printRoomSize(kitchen);
        printRoomSize(bathroom);

    }

    private void printRoomSize(Room room) {
        System.out.println(room.getName()+" is size: "+room.getDimensions().printDimensions());
    }
}
