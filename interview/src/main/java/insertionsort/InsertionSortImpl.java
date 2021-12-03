package insertionsort;

/**
 * O(n^2) T O(1) S in average and worst case as we have to iteratively sort the array through loops to
 * have the array sorted.
 * */

public class InsertionSortImpl implements InsertionSort{
    @Override
    public int[] sort(int[] array) {
        for(int i=1; i<=array.length-1;i++){
            if(array[i] < array[i-1]) sort(array, i);
        }
        return array;
    }

    private static void sort(int[] array, int i) {
        int endOfSorted = i -1;
        int newLocation = i;
        while(endOfSorted>=0){
            if (array[newLocation]<= array[endOfSorted]) {
                    int oldValue = array[endOfSorted];
                    array[endOfSorted] = array[newLocation];
                    array[newLocation] = oldValue;
                    newLocation --;
            }
            endOfSorted --;
        }
    }
}
