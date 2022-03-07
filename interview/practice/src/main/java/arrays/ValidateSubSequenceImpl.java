package arrays;

/**
 *We iterate through the array maintaining an index of the element we are interested in finding
 * from the subsequence. Each time we find it, we advance our index until we get to the end of the
 * subsequence or end of the array and return true if we reached the end of the subsequence first
 * or false if we reached the end of the array without finding the full desired subsequence
 *Complexity: O(n) T O(1) S
 * */

public class ValidateSubSequenceImpl implements ValidateSubSequence {
    @Override
    public boolean isSubSequence(int[] array, int[] potentialSubSequence) {
        int currentResultIndex = 0;
        for(int i=0;i<=array.length-1;i++){
            if(currentResultIndex == potentialSubSequence.length) break;
            if(array[i] == potentialSubSequence[currentResultIndex])currentResultIndex ++;

        }
        return currentResultIndex == potentialSubSequence.length;
    }
}
