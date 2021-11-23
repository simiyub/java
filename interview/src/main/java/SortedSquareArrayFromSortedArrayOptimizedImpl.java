/**
 *
 * */
public class SortedSquareArrayFromSortedArrayOptimizedImpl implements SortedSquareArrayFromSortedArray {
    @Override
    public int[] sortedSquaredArray(int[] array) {
        int[] squared = new int[array.length];
        int squaredArrayIndex = squared.length-1;
        int arrayLowIndex = 0;
        int arrayHighIndex = array.length-1;
        //1,3,4,5,5,6
        for (int i=0;i<=array.length-1;i++) {
            if (arrayLowIndex <= arrayHighIndex) {
                if (Math.abs(array[arrayLowIndex]) < Math.abs(array[arrayHighIndex])) {
                    squared[squaredArrayIndex] = array[arrayHighIndex] * array[arrayHighIndex];
                    arrayHighIndex--;
                } else {
                    squared[squaredArrayIndex] = array[arrayLowIndex] * array[arrayLowIndex];
                    arrayLowIndex++;
                }

                squaredArrayIndex--;

            }
        }
        return squared;
    }
}
