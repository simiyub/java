package classphoto;

/**
 * Taking a class photo where children are either in a jumper of not.
 * Requirements:
 * 1. Children in a jumper must stand in the same row and children without the jumper in a different row.
 * 2. Each child in the front row must be shorter than the child in the back row.
 *You are provided with two arrays representing the heights.
 * Determine whether the photo arrangement id feasible or not.
 * You are allowed to change the arrays.
 *
 * */
public interface ClassPhoto {
    boolean feasible(int[] jumper, int[] noJumper);
}
