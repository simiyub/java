package selectionsort;

/**
 *O(n^2) T O(1) S as we have to iterate through the array several times to sort the elements.
 * There's no additional space required as we sort the array in place.
 * */
public class SelectionSortImpl implements SelectionSort {

    @Override
    public int[] sort(int[] array) {
        int unsortedStartIndex = 0;
        int currentSmallestIndex =0;
        int smallerNumberIndex = 0;
        while(unsortedStartIndex<array.length-1) {

            for (int i = unsortedStartIndex; i <= array.length - 1; i++) {
                if (array[i] < array[smallerNumberIndex]) smallerNumberIndex = i;
            }
            if(smallerNumberIndex>currentSmallestIndex) {
                int smallerNumber = array[smallerNumberIndex];
                array[smallerNumberIndex] = array[currentSmallestIndex];
                array[currentSmallestIndex] = smallerNumber;
            }
            currentSmallestIndex ++;
            smallerNumberIndex ++;
            unsortedStartIndex ++;
        }
        return array;
    }
}
