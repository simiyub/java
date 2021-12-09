package monotonicarray;

/**
 * O(n) T O(1) S as we will walk through the array once to determine if it is entirely monotonic.
 * How it works
 * ------------
 * We first determine if the value of the integers in the array is increasing
 * We base this on the first two integers or the first difference.
 * Then we check if the rest of the elements follow the same trend.
 * If we come across a different trend, we return a false straight away.
 * **/
public class MonotonicArrayWithDirectionFlagImpl implements MonotonicArray {
    @Override
    public boolean isMonotonic(int[] array) {
        if (array.length > 1) {

        int index = 1;
        int increasing = 0;

        while (index <= array.length - 1) {

            if (increasing == 0 ){
                increasing = array[index] - array[index - 1];
            }

            if (increasing >0 && array[index] < array[index - 1]) return false;
            else if (increasing <0 && array[index] > array[index - 1]) return false;

            index++;
        }
    }
        return true;
    }
}
