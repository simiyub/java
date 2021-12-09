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
        if (array.length == 0 || array.length == 1) return true;

        int startingIndex = 1;
        int increasing = 0;


        while(startingIndex<=array.length - 1){
            if (array[startingIndex] == array[startingIndex-1]) startingIndex ++;

            else if (array[startingIndex] > array[startingIndex-1]){
                increasing = 1;
                break;
            }
            else if(array[startingIndex] < array[startingIndex-1]){
                increasing = -1;
                break;
            }

        }

        if (increasing == 0) return true;


        for (int i=1; i<=array.length-1;i++){
            if(increasing == 1){
                if(array[i] < array[i-1]) return false;
            }
            else if(array[i] > array[i-1]) return false;

        }
        return true;
    }
}
