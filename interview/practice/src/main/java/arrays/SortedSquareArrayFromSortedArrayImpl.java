package arrays;

import java.util.Arrays;
/***
 * O(n) T and O(n) S but also has a sort function which is O(nlogn), so overall O(nlogn)
 * We square then sort the result
 * */
public class SortedSquareArrayFromSortedArrayImpl implements SortedSquareArrayFromSortedArray {
    @Override
    public int[] sortedSquaredArray(int[] array) {
        int[] squared = new int[array.length];
        for(int i=0;i<= array.length-1;i++){
            squared[i] = array[i]*array[i] ;
        }
        Arrays.sort(squared);
        return squared;
    }
}
