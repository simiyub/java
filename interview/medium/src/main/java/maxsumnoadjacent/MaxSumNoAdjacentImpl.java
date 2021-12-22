package maxsumnoadjacent;

/**
 * O(n) T O(1) S as we iterate through the array to the end
 * but we do not need additional space as we track the optimal total
 * as we iterate through the array.
 *
 * How it works
 * ------------
 * We iterate through the array determining which combination would give
 * us the highest sum. Every time we find a greater sum we drop previous sum
 * and make the new higher sum our current running sum.
 *
 * */
public class MaxSumNoAdjacentImpl implements MaxSumNoAdjacent {
    @Override
    public int sum(int[] array) {

        if(array.length!=0) {
            if (array.length == 1) return array[0];

            int currentSum = Math.max(array[0], array[1]);
            int previousSum = array[0];
            int newSum;
            for (int i = 2; i <= array.length - 1; i++) {
                newSum = Math.max(currentSum, previousSum + array[i]);
                previousSum = currentSum;
                currentSum = newSum;
            }
            return currentSum;
        }
        else return 0;
    }
}
