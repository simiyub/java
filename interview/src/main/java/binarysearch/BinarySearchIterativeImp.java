package binarysearch;

/**
 * O(logn) T and O(1) S as we split the array in two at each iteration and no need for additional data structure
 * Iterative implementation
 * */
public class BinarySearchIterativeImp implements BinarySearch{
    @Override
    public int indexOf(int[] array, int requiredNumber) {

        int start = 0;
        int end = array.length-1;

        while(start <= end){
            int mid = Math.round((end+start)/2);

            if (array[mid]>requiredNumber) end = mid-1;
            else if (array[mid]<requiredNumber) start = mid+1;
            else return mid;
        }
        return -1;
    }
}
