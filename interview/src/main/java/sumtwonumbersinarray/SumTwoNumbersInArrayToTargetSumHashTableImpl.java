package sumtwonumbersinarray;

import java.util.HashMap;
import java.util.Map;

/**
 * O(n) T O(n) S
 * Most efficient time complexity but has a space trade-off
 *
 * How it works
 * ------------
 * 1. Walk through the loop to find an integer that gives us the desired result
 * 2. Everytime we find a value, we add to the hash table
 * 3. When we find the right combination we exit.
 */

public class SumTwoNumbersInArrayToTargetSumHashTableImpl implements SumTwoNumbersInArrayToTargetSum {
    public int[] sum(int[] array, int target) {


        Map<Integer, Boolean> found = new HashMap();

        for(int i= 0; i<=array.length-1;i++){
            if(found.get(target - array[i])!=null){
                System.out.printf("%d + %d = %d %n",array[i],target-array[i],target);
                return new int[]{array[i],target-array[i]};
            }
            else {
                System.out.printf("adding %d %n", array[i]);
                found.put(array[i], true);
            }
        }


        return new int[2];
    }
}
