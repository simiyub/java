package tandembicycle;

/**
 * Greedy algorithm
 * Pair up cyclists from two teams to determine
 * the fastest and slowest speed that you can achieve between the two teams.
 * The fastest flag determines whether we are looking for the fastest speed or slowest.
 * The team Arrays will always be the same length.
 * */

public interface TandemBicycle {
    int speed(int[] teamA, int[] teamB, boolean fastest);
}
