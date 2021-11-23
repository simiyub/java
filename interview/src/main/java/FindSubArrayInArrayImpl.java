/***
 * O(n) T and O(1) S of space
 * Implementation uses one loop and no additional data structure
 * */
public class FindSubArrayInArrayImpl implements FindSubArrayInArray {
    @Override
    public boolean isSubArray(int[] array, int[] candidateSubArray) {
        int currentIndex = 0;
        for (int i=0;i<=array.length;i++){
            boolean foundAll = currentIndex == candidateSubArray.length-1;
            if(!foundAll){
                if(candidateSubArray[currentIndex] == array[i]) currentIndex ++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
