import java.util.HashMap;
import java.util.Map;

public class SumTwoNumbersInArrayToTargetSumHashTableImpl implements SumTwoNumbersInArrayToTargetSum {
    public int[] sum(int[] array, int target) {

        /**
         * O(n) T
         * O(n) S
         * Walk through the loop to find an integer that gives us the desired result
         * and everytime we find a value, we add to the hash table
         * when we find the right combination we exit.
         */
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
