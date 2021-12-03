package binarysearch;

/**
 * O(logn) T and O(logn) S as we split the array in two at each iteration and we are adding frames on the call stack
 * Recursive implementation
 * */
public class BinarySearchRecursiveImp implements BinarySearch{
    @Override
    public int indexOf(int[] array, int requiredNumber) {
        int elementCount = array.length-1;
        return indexOf(array,0, elementCount, requiredNumber);
    }

    private int indexOf(int[] array, int start,int end, int requiredNumber) {
        if (start>end) return -1;
        int mid = Math.round((end+start)/2);

        if (array[mid]>requiredNumber) return indexOf(array,start, mid-1, requiredNumber);
        else if (array[mid]<requiredNumber) return indexOf(array,mid+1,end,requiredNumber);
        else return mid;
    }
}
