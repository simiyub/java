package minimumwaitingtime;

/**
 * Greedy algorithm
 * Calculate the amount of time it takes to get to a function in a list of functions.
 * This is the sum of how long each of the functions preceding it took.
 * No additional space should be used.
 * e.g. [ 1,4,5] executed in order 5, 1, 4  would take: 0 + 5 + (5+1) = 11
 * */
public interface MinimumWaitingTime {
    int minimumWaitingTime(int[] listOfFunctionExecutionTimes);

}
