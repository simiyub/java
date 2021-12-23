package minimumcoinsforchange;

import java.util.Arrays;

/**
 *O(nd) T O(n) S as we iterate through the array of denominations and
 * combinations of those denominations to determine the least number of coins.
 * How it works
 * ------------
 * We iterate through the denominations to determine the combination
 * with the least count of denominations required to obtain the target amount.
 * */
public class MinimumCoinsForChangeImpl implements MinimumCoinsForChange{
    @Override
    public int minimumCoinsForChange(int[] denominations, int desiredAmount) {

        if(desiredAmount == 0) return 0;
        int[] coinCount = new int[desiredAmount+1];
        Arrays.fill(coinCount,Integer.MAX_VALUE);
        coinCount[0] = 0;



        for (int denomination:denominations){

            for(int amount=0;amount<coinCount.length;amount++){
                if(denomination<=amount) {

                    boolean initialised = coinCount[amount-denomination] ==Integer.MAX_VALUE;
                    int newValue = coinCount[amount-denomination];
                    if(!initialised) newValue +=1;
                    coinCount[amount] =Math.min(coinCount[amount],newValue);
                }
            }
        }
        return coinCount[desiredAmount]==Integer.MAX_VALUE? -1 : coinCount[desiredAmount];
    }

}
