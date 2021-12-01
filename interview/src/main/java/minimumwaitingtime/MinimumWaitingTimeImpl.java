package minimumwaitingtime;

import java.util.Arrays;

/**
 * O(nlogn) T O(1) S because of the sorting and the array is the same.
 *  The iteration uses n time, so overall the complexity is nlogn
 * Sort the array
 * Go through the array and add up the execution times of previous functions
 * to determine the waiting time of current function.
 * */

public class MinimumWaitingTimeImpl implements MinimumWaitingTime{
    @Override
    public int minimumWaitingTime(int[] listOfFunctionExecutionTimes) {
        Arrays.sort(listOfFunctionExecutionTimes);
        int remainingCount = listOfFunctionExecutionTimes.length-1;
        int minimumTime = 0;
        for (int i=0; i<=listOfFunctionExecutionTimes.length-1;i++){
            minimumTime += listOfFunctionExecutionTimes[i] * remainingCount;
            remainingCount --;
        }
        return minimumTime;
    }

}
