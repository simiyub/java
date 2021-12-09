package monotonicarray;

/**
 * O(n) T O(1) S as we will walk through the array once to determine if it is entirely monotonic.
 *
 * How it works
 * ------------
 * This even more minimalist option by algoexpert.io works as follows:
 * We set the decreasing or increasing flag as true, then we iterate through the array and if
 * we find the trend to be false, we reverse the flag .
 * **/

public class MonotonicArrayNoDirectionFlagImpl implements MonotonicArray{
    @Override
    public boolean isMonotonic(int[] array) {
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;
        for (int i=1;i<=array.length-1;i++){
            if(array[i] < array[i-1]) isNonDecreasing = false;
            if (array[i] > array[i-1]) isNonIncreasing = false;
        }
        return isNonDecreasing || isNonIncreasing;
    }
}
