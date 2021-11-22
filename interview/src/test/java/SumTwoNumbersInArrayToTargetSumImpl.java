public class SumTwoNumbersInArrayToTargetSumImpl implements SumTwoNumbersInArrayToTargetSum{
    public int[] sum(int[] array, int expectedResult) {
        for (int i=1; i<=array.length-1;i++){
            if (array[i]+array[i-1] ==expectedResult) return new int[]{array[i-1],array[i]};
        }
        return new int[0];
    }
}
