import java.util.Arrays;

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
