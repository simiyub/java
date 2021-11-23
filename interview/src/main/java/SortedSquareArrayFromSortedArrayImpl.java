public class SortedSquareArrayFromSortedArrayImpl implements SortedSquareArrayFromSortedArray {
    @Override
    public int[] sortedSquaredArray(int[] array) {
        int[] squared = new int[array.length];
        for(int i=0;i<= array.length-1;i++){
            squared[i] = array[i]*array[i] ;
        }
        return squared;
    }
}
