/**
 * O(n) T O(1) S because we iterate through the array once until we get to the beginning
 * of the cycle or until we find we've run through the length of the array
 * without getting to the beginning.
 *
 * How it works
 * ------------
 * We track the current index to determine if we have gone back to the beginning of the
 * cycle in which case we return true, meaning we have a single cycle. On the other hand
 * if we run through the array up to the length of the array and haven't returned to the
 * beginning, we know we do not have a single cycle.
 * */

public class SingleCycleCheckImpl implements SingleCycleCheck{
    @Override
    public boolean hasSingleCycle(int[] array) {
        int steps=0;
        int startingIndex=0;
        int index=0;

        while(steps<array.length){

            if( steps >0 && index==startingIndex) return false;
            steps ++;

            index = index + array[index];
            index = index%array.length;
            if(index<0) index = index+array.length;
        }
        return index == startingIndex;
    }
}
