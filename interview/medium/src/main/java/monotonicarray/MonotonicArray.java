package monotonicarray;

/**
 * This function will receive an array of integers and
 * will determine whether the integers are entirely non-increasing or entirely non-decreasing.
 * An array of one element or an empty array is considered monotonic.
 * integers of equal value are considered non-decreasing, non-increasing.
 *Example: [1,5 7,8,10] is monotonic and so is [ -7, -9, -12, -15, -19].
 *
 * */
public interface MonotonicArray {
    boolean isMonotonic(int[] array);
}
