public class SumTwoNumbersInArrayToTargetSumTwoLoopImpl implements SumTwoNumbersInArrayToTargetSum{

    /**
     * Most inefficient solution that uses two loops: O(n^2) T and O(1) S
     *
     * How it works
     * ------------
     * Go through the loop and find a combination that adds up to the target value.
     * If no match is found the first time, we advance our starting point
     * Iterate through the sub array after the starting point
     * Repeat until we get to the end of the array
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
