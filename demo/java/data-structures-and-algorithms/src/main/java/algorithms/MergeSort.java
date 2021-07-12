package algorithms;

import java.util.Arrays;

public class MergeSort {
    public int[]  mergeSort(int[] array){
        System.out.println("To sort:"+ Arrays.toString(array));
        int[] sorted = sort(array, 0, array.length-1);
        System.out.println("Sorted:"+Arrays.toString(array));
        return sorted;
    }

    private int[] sort(int[] array, int start, int end) {
        if(start >=end) return array;
         int mid = (end+start)/2;
         sort(array, start, mid);
         sort(array, mid+1, end);
         merge(array, new int[array.length], start, end);
        return array;
    }

    private void merge(int[] array, int[] result, int start, int end) {
        int leftEnd = (end+start)/2;
        int rightStart = leftEnd + 1;
        int size = (end - start) + 1;
        int index = start;
        int left = start;
        int right = rightStart;

        while(left <= leftEnd && right <= end){
            if(array[left] <= array[right]){
                result[index] = array[left];
                left ++;
            }
            else{
                result[index]  = array[right];
                right ++;
            }
            index ++;

        }

        System.arraycopy(array, left, result, index, leftEnd-left +1);
        System.arraycopy(array, right, result, index, end-right + 1);
        System.arraycopy(result, start, array, start, size);

    }
}
