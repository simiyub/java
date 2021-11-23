package findsubarrayinarray;

/***
 * O(n) T and O(1) S of space
 * Implementation uses one loop and no additional data structure
 * */
public class FindSubArrayInArrayImpl implements FindSubArrayInArray {
    @Override
    public boolean isSubArray(int[] array, int[] candidateSubArray) {
        int currentIndex = 0;
        for (int i=0;i<=array.length-1;i++){
            if(candidateSubArray[currentIndex] == array[i]) currentIndex ++;
            if (currentIndex > candidateSubArray.length-1) return true;
        }
        return false;
    }
}
