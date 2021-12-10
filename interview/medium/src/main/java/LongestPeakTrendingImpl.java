/**
 * TODO: Code this out when you have some free time.
 * O(n) T and O(1) S as we traverse through the array once identifying the peaks
 * and do not require any additional space.
 *
 * How it works
 * ------------
 * Starting from the beginning of the array,
 * we check if the array has at least 3 integers
 * We then compare the current integer to the one before, starting at index 1
 * If we find the sequence strictly increasing,
 * then we flag as increasing and start a count of the integers,
 * taking note of the starting integer.
 * If we find a plateau, we nullify the trend, stop counting
 * TODO: ?Do we change the increasing flag to false at a plateau?
 * If the trend starts increasing again, then we restart the count.
 * Soon as we hit an integer smaller than current tip, we change the increasing flag as false.
 * We continue with the count even when strictly decreasing
 * until we come across a plateau or another increasing trend.
 * At this point, we take note of the last integer before the plateau or new increase.
 * We then compare the length of current peak to the length of the new peak
 * and swap if it is greater or store if it is the only one.
 * TODO: *Whenever we catch a new strictly increasing trend after a plateau or decrease,
 * TODO: *Remember to count the new peak inclusive of the last integer in the the plateau or drop.
 * TODO: ?Do we need to track the tip?
 * If
 * */
public class LongestPeakTrendingImpl implements LongestPeak {
    @Override
    public int longestPeak(int[] array) {
        throw new UnsupportedOperationException("To be implemented");
    }
}
