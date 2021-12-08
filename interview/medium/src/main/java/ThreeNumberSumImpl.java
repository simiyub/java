/**
 * O(n^2) T and O(1) S . This is because we iterate through the array once but during that iteration,
 * we are going through the iteration with a while loop to find combinations that will add up to
 * the target sum.
 *
 * How it works
 * ------------
 * The first option I considered was:
 * sort the array
 * Store the numbers in a hashtable
 * Select first two numbers in my array and
 * then find a number in the hashmap that would add up to target number.
 * I would then do that for all numbers then shift to the next set of combinations
 *
 * Actual implementation was done with the help of the video explanation from algoexpert.io
 * which is as follows:
 * sort the array
 * select the first number in the array.
 * Set a left pointer to the number after and a right pointer to the last number in the array
 * Add them up and check if they add up to the target sum.
 * It they do, add the three to the array to be returned and then shift both pointers one step forward.
 * If the sum is less than the target sum, then shift the left pointer right to increase the sum
 * If the sum is greater, then shift the right pointer to reduce the sum.
 * We continue with this iteration finding combinations of three numbers that meet our requirement
 * until the left pointer is pointing at an index after the right pointer.
 * At that point we move our left starting point to the next index and reset the left pointer
 * to the index after the starting point. We also reset the right pointer to the end of the array.
 * We repeat the process until we come to the end of the array
 * and return the array of the combinations or an empty array if none.
 * **/

public class ThreeNumberSumImpl implements ThreeNumberSum {
    @Override
    public int[][] sum(int[] array, int targetSum) {
        return new int[0][];
    }
}
