package bubblesort;

/**
 * O(n^2) T and O(1) in worst case and average as we are looping through until the array is sorted.
 * No additional space required as we sorted in place
 * */
public class BubbleSortImpl implements BubbleSort{
    @Override
    public int[] sort(int[] array) {
        boolean sorted = true;
        int end = array.length-2;
        while(sorted) {

            sorted = false;
            for (int i=0;i<=end;i++) {
                if(array[i]>array[i+1])
                {
                    int oldValue = array[i];
                    array[i] = array[i+1];
                    array[i+1] = oldValue;
                    sorted = true;
                }

            }
            end --;
        }
        return array;
    }
}
