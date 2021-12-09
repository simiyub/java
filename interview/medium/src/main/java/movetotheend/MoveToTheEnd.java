package movetotheend;

/**
 * This function will receive an array of integers and a number to search for
 * in the array.
 * We then move every instance of the number to the end of the array and return the array.
 * This algorithm will perform this task in place.
 * */
public interface MoveToTheEnd {
    int[] move(int[] array, int numberToMove);
}
