package arrays;

import java.util.Arrays;

/**
 * We sort the array then iterate through it comparing the sum of the largest and smallest element
 * until we find a sum that is equal to the target sum and return or return an empty array.
 * Time Complexity: O(nlogn) T O(1) S storage
 * */
public class TwoNumberSumWithSortingImpl implements TwoNumberSum{
    public int[] findSum(int[] array, int target) {
        Arrays.sort(array);
        int end = array.length-1;
        int start = 0;
        for(int i=0;i<=array.length-1;i++){
            int sum = array[start] + array[end];
            if (sum == target) return new int[]{array[start], array[end]};
            else {
                if (sum < target) start+=i;
                if(sum > target) end -=i;
            }

        }
        return new int[0];
    }
}
