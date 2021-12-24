/**
 * O(n) T O(1) S as we iterate through the array only once
 * looking for the greatest sum of sub arrays and
 * only store the current sum and greatest sum so far.
 *
 * How it works
 * ------------
 * Using kadane's algorithm, we iterate through the
 * array and determine what combination of values/subarray
 * gives us the greatest sum. We also keep a record of the
 * greatest sum we have acquired so far and when we reach the
 * end we return the greatest sum we have been keeping.
 * */
public class KadanesAlgorithmImpl implements KadanesAlgorithm{
    @Override
    public int greatestSumFromSubArray(int[] array) {
        int greatestSumSoFar = array[0];
        int currentSum = array[0];

        for(int i=1;i<=array.length-1;i++){
            currentSum = Math.max(array[i], currentSum +array[i]);
            greatestSumSoFar = Math.max(currentSum,greatestSumSoFar);
        }
        return greatestSumSoFar;
    }
}
