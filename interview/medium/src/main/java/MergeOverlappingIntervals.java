/**
 * This function takes in a non-empty array of intervals and finds
 * overlapping intervals, merging them and returning the array with
 * the intervals in no particular order.
 * Each interval consists of two numbers where number in index 0 is
 * smaller or equal to the number in index 1.
 * Intervals are considered overlapping when:
 * considering this array: [[x,y],[a,b]]
 * x is less than a and b
 * a is less than or equal to y
 * b id greater than or equal to y.
 *
 *
 * */
public interface MergeOverlappingIntervals {

    int[][] mergeOverlappingIntervals(int[][] array);
}
