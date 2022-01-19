package singlecyclecheck;

/**
 *This function receives an array of integers that represents a jump of its value in the array with
 * negative numbers representing a jump in the reverse direction. If the jump goes past the bounds of the array
 * in either direction, we wrap around to the other end.
 * So for example in [2, 3, 1, -4, -4, 2] a jump of 3 from index 0 lands us on -4 and a jump of -1 from there
 * lands us on the next -4. The function will return a boolean representation of whether the jumps in the array
 * form a single cycle from any index in the cycle.
 * Every element in the array is visited exactly once before returning to the starting index.
 * */
public interface SingleCycleCheck {
    boolean hasSingleCycle(int[] array);
}
