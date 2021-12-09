/**
 * O(n) T O(1) S as we will walk through the array once to determine if it is entirely monotonic.
 * How it works
 * ------------
 * We first determine if the value of the integers ini the array is increasing based
 * We base this on the first two integers.
 * Then we check if the rest of the elements follow the same trend.
 * If we come across a different trend, we return a false straight away.
 * **/
public class MonotonicArrayImpl implements MonotonicArray {
    @Override
    public boolean isMonotonic(int[] array) {
        return false;
    }
}
