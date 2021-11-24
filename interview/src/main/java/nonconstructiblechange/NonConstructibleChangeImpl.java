package nonconstructiblechange;

import java.util.Arrays;

/**
 * O(nlogn) T and O(1) S assuming we can sort the array in place
 * How it works
 * ------------
 *     Walking through the collection of coins:
 * 		hold a value that is the lowest in value
 * 		Store every value in the collection in a hash table
 * 		When done walking through the collection
 * 		increment the lowest value by one and find the equivalent in the hash table
 * 		if it doesn't exist, then that is the value of the lowest change you cannot make.
 * **/
public class NonConstructibleChangeImpl implements NonConstructibleChange{
    @Override
    public int nonConstructibleChange(int[] change) {

        Arrays.sort(change);
        int lowestChange = 0;
        if(change.length >0) {
            for (int i = 0; i <= change.length - 1; i++) {
                int currentValue = change[i];

                if (currentValue <= lowestChange + 1) {
                    lowestChange += currentValue;
                } else {
                    return lowestChange += 1;
                }

            }
        }
        else{
            return 1;
        }
        return lowestChange +1;
    }
}
