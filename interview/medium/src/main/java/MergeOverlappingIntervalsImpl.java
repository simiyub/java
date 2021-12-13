/***
 * O(n) T O(1) S as we iterate through the array
 * identifying overlapping intervals and updating the array in place and returning the array once we are at the end.
 *
 * How it works
 * ------------
 * My solution considers the following conditions and merges arrays accordingly:
 * Intervals are considered overlapping when:
 *  * considering this array: [[x,y],[a,b]]
 *  * x is less than a and b
 *  * a is less than or equal to y
 *  * b id greater than or equal to y.
 * */

public class MergeOverlappingIntervalsImpl implements MergeOverlappingIntervals{
    @Override
    public int[][] mergeOverlappingIntervals(int[][] array) {
        return new int[0][];
    }
}
