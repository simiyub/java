import java.util.List;

/**
 * This function will take an array of integers and will find
 * all combinations of three numbers that would sum up to a given target number.
 * These combinations will then be returned as part of an array of arrays.
 * Example: given [1,2,3,-8,9,-2,5,6] and a target sum of 6,
 * this function will return [[1,2,3],[-2,1,5]]
 * **/
public interface ThreeNumberSum {
    List<Integer[]> sum(int[] array, int targetSum);
}
