public class SumTwoNumbersInArrayToTargetSumTwoLoopImpl implements SumTwoNumbersInArrayToTargetSum{

    /**
     * Solution uses two loops: O(n2) Time complexity
     * */
    public int[] sum(int[] array, int expectedResult) {
        int start = 0;
        if(array.length > 2) {
            while (start <= array.length - 2) {
                for (int i = start + 1; i <= array.length - 1; i++) {
                    int sum = array[start] + array[i];
                    if (sum == expectedResult) {
                        System.out.printf("%d + %d = %d %n", array[start], array[i] , expectedResult);
                        return new int[]{array[start], array[i]};
                    }

                }
                start++;
            }
        }
        else if (array.length == 2 && array[0] + array[1] == expectedResult) return new int[]{array[0], array[1]};
        return new int[2];
    }
}
