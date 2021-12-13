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
        int[][] result = new int[array.length][];
        boolean useResult = false;
        int resultIndex=-1;
        for(int i=0; i<=array.length-2;i++){
            if(!useResult && array[i][0] <= array[i+1][0] && array[i][0] <=array[i+1][1] && array[i+1][0] <= array[i][1] && array[i+1][1] >= array[i][1]){
                System.out.printf(""+Math.min(array[i][0], array[i+1][0]), Math.max(array[i][1], array[i+1][1]));
                result[resultIndex] = new int[]{Math.min(array[i][0], array[i+1][0]), Math.max(array[i][1], array[i+1][1])};
                useResult = true;
                continue;

            }

            if(useResult && result[resultIndex][0] <= array[i+1][0] && result[resultIndex][0] <=array[i+1][1] && array[i+1][0] <= result[resultIndex][1] && array[i+1][1] >= result[resultIndex][1]){
                    System.out.printf(""+Math.min(array[i][0], array[i+1][0]), Math.max(array[i][1], array[i+1][1]));
                    result[resultIndex] = new int[]{Math.min(result[resultIndex][0], array[i+1][0]), Math.max(result[resultIndex][1], array[i+1][1])};
                    useResult = true;
                    continue;
                }
            else{
                resultIndex++;
                result[resultIndex] = array[i];
                useResult =false;

            }



        }
        return new int[0][];
    }
}
