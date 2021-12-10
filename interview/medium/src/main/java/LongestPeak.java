/**
 * This function will receive an array of integers and return the length of the logest peak.
 * This is the length a set of at least 3 adjacent integers in the array that strictly
 * increase until they reach a tip and then become strictly decreasing.
 * Example: [1,2,3] forms a peak of 3
 * */
public interface LongestPeak {
    int longestPeak(int[] array);
}
