package numberofwaystomakechange;

/**
 *
 * O(nd) T and O(n) S as we iterate through the denominations and the total number of amounts
 * we can get from 0-desiredAmount
 *
 * How it works
 * ------------
 * Effectively, we use dynamic programming in this solution:
 * We consider every amount between zero and the desired amount and create an
 * array where we store the number of combinations we can have of the
 * different denominations.
 * We initialise this array with the value of combinations for a zero amount
 * which is 1 as to have no amount, there's only one action and that is do nothing.
 * Then for every index >= the denomination we are looking for,
 * the value of the combinations will be one more than the
 * combination in the current index - denomination.
 * This solution comes from watching the tutorial with Stephen Oneill on youtube which helped me understand
 * the dynamic programming solution best.
 * */
public class NumberOfWaysToMakeChangeDynamicImpl implements NumberOfWaysToMakeChange{

    @Override
    public int numberOfWaysToMakeChange(int[] array,int desiredAmount) {

        int index = 0;


        return dynamic(array,desiredAmount);
    }

    private int dynamic(int[] denominations, int desiredAmount) {

        int[] combinations = new int[desiredAmount+1];
        combinations[0] = 1;

        for(int denomination:denominations){

            for(int index=1; index<combinations.length;index++){
                if(index>=denomination) combinations[index] += combinations[index-denomination];
            }
        }

        return combinations[desiredAmount];

    }
}
