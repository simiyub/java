import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubArrayInArrayImpl implements FindSubArrayInArray{
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

    public boolean isSubList(List<Integer> array, List<Integer> candidateSubArray) {
        int currentIndex =0;
        List<Integer> found = new ArrayList<>();
        boolean done = found.size() == candidateSubArray.size();
        for(int i=0; i<=array.size()-1; i++){
            if(!done && currentIndex <=candidateSubArray.size()-1) {
                if (candidateSubArray.get(currentIndex) == array.get(i)) {
                    found.add(candidateSubArray.get(currentIndex));
                    currentIndex ++;
                }
            }
            else {
                break;
            }
        }
        return found.size() == candidateSubArray.size();
    }
}
