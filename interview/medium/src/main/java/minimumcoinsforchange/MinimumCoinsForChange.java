package minimumcoinsforchange;

/**
 * This function receives an array of positive integers and a target
 * value and returns the smallest number of combinations to make up
 * the target value.
 * Where it is not possible to make the target amount we return -1
 * */
public interface MinimumCoinsForChange {

    int minimumCoinsForChange(int[] denominations, int desiredAmount);

}
