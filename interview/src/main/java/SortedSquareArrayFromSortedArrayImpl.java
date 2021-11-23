import java.util.Arrays;

public class SortedSquareArrayFromSortedArrayImpl implements SortedSquareArrayFromSortedArray {
    @Override
    public int[] sortedSquaredArray(int[] array) {
        int[] squared = new int[array.length];
        for(int i=0;i<= array.length-1;i++){
            squared[i] = array[i]*array[i] ;
        }
        Arrays.sort(squared);
        System.out.println(Arrays.toString(squared));
        return squared;
    }
}
