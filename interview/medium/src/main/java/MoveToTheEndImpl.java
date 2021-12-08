/**
 * O(n) T O(1) S as we will iterate through the array once
 * finding instances of the given number to move.
 * As our changes are in place, no additional space is required.
 *
 * How it works
 * ------------
 * We place a pointer at the beginning and end of the array
 * and determine if the number we are pointing at is an instance
 * of the number we want to change. If it is,
 * we move it to the end and move the end pointer a step in to the left.
 * This will split the array into an unchecked array and the values at
 * the end that we have already moved.
 * We continue until the pointers meet and then we return the array.
 * */
public class MoveToTheEndImpl implements MoveToTheEnd{
    @Override
    public int[] move(int[] array, int numberToMove) {
        return new int[0];
    }
}
