package arrays;

import java.util.*;

/**
 * We iterate through the array, maintaining a map of numbers we have viewed as potential matches.
 * We check in each iteration if the number we are currently looking at would give us the target
 * sum with any of the numbers in our map. If so, we return the two numbers otherwise,
 * we add it to the map.
 * O(n) T O(n) S storage
 * */

public class TwoNumberSumWithStorageImpl {
    public int[] findSum(int[] array, int target) {
        Set<Integer> viewed = new HashSet<>();
        for(int i=0;i<=array.length-1;i++){
            int num1 = array[i];
            int num2 = target-num1;
            if (viewed.contains(num2)) return new int[]{num1,num2};
            viewed.add(num1);
            }
        return new int[0];
    }
}
