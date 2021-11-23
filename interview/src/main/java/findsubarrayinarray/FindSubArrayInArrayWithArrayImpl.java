package findsubarrayinarray;

import java.util.ArrayList;
import java.util.List;

/**
 *O(n) T and O(n) S solution of  finding a subsequence in an array
 * **/
public class FindSubArrayInArrayWithArrayImpl implements FindSubArrayInArray{
    @Override
    public boolean isSubArray(int[] array, int[] candidateSubArray) {
        int currentIndex =0;
        List<Integer> found = new ArrayList<>();
        boolean done = found.size() == candidateSubArray.length;
        for(int i=0; i<=array.length-1; i++){
            if(!done && currentIndex <=candidateSubArray.length-1) {
                if (candidateSubArray[currentIndex] == array[i]) {
                    found.add(candidateSubArray[currentIndex]);
                    currentIndex ++;
                }
            }
            else {
                break;
            }
        }
        return found.size() == candidateSubArray.length;
    }

}
