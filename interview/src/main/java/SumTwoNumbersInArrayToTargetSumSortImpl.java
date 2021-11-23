import java.util.Arrays;

/**
 * O(logn) T O(1) S
 * Slightly less efficient than the hashtable implementation for time complexity but doesn't use additional space
 *
 *  How it works:
 * -------------
 * 1. Sort the array
 * 2. Walk through with two markers front and back until we find a combination that adds up to the target
 *
 * **/
public class SumTwoNumbersInArrayToTargetSumSortImpl implements SumTwoNumbersInArrayToTargetSum {
    @Override
    public int[] sum(int[] array, int target) {
        int[] result = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(result));
        int leftIndex = 0;
        int rightIndex= result.length-1;
        for(int i=0;i<result.length-1;i++){
            if ( result[leftIndex] + result[rightIndex] == target) return new int[] {result[leftIndex], result[rightIndex]};
            else if (result[leftIndex] + result[rightIndex] < target) leftIndex++;
            else rightIndex--;
        }
        return new int[2];
    }
}
