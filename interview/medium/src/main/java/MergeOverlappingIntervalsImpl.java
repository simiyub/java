import java.util.ArrayList;
import java.util.List;

/***
 * O(n) T O(1) S as we iterate through the array
 * identifying overlapping intervals and updating the array in place and returning the array once we are at the end.
 *
 * How it works
 * ------------
 * My solution considers the following conditions and merges arrays accordingly:
 * Intervals are considered overlapping when:
 *  * considering this array: [[x,y],[a,b]]
 *  * x is less than a and b
 *  * a is less than or equal to y
 *  * b id greater than or equal to y.
 * */

public class MergeOverlappingIntervalsImpl implements MergeOverlappingIntervals{
    @Override
    public int[][] mergeOverlappingIntervals(int[][] array) {
        List<int[]> list = new ArrayList<>();
        int resultIndex=0;
        list.add( array[0]);
        for(int i=1; i<=array.length-1;i++){

            if(list.get(resultIndex)[0] <= array[i][0] && list.get(resultIndex)[0] <=array[i][1] && array[i][0] <= list.get(resultIndex)[1] && array[i][1] >= list.get(resultIndex)[1]){
                    list.set(resultIndex, new int[]{Math.min(list.get(resultIndex)[0], array[i][0]), Math.max(list.get(resultIndex)[1], array[i][1])});
                }
            else{
                list.add(array[i]);
                resultIndex ++;
            }

        }
        return list.toArray(new int[list.size()][]);
    }
}
