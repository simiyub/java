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
