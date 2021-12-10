/**
 * Solution based on suggestion from algoexpert.io
 * O(n) T O(n) S
 * How it works
 * ------------
 * We iterate through the array searching for tips of peaks starting from index 1.
 * A tip of the peak is an integer with a lower value either end of it.
 * When we find a tip, we have found a peak.
 * We check how far the integers drop on either side before they either start increasing or plateau.
 * The distance between these points is the length of our peak.
 * We replace the value of the length if we have a new peak that is longer.
 * We then continue with our search for peaks starting at the end of the
 * peak we have just identified and analysed.
 * We repeat this process for any peaks we find along the way until we reach
 * the end of the array and return the current length that we stored or -1 if we did not find any peaks.
 * **/
public class LongestPeakPeakFirstImpl implements LongestPeak{
    @Override
    public int longestPeak(int[] array) {

        if(array.length>=3) {

            int longestPeak = -1;

            for (int i = 1; i <= array.length - 2; i++) {
                if (array[i] > array[i - 1] && array[i] > array[i + 1]) {

                    System.out.println(array[i]);
                }
            }

            return longestPeak;
        }
        return -1;
    }
}
