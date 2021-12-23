/**
 *O(n) T O(n) S as we iterate through the array of denominations and
 * combinations to determine the least number of coins.
 * How it works
 * ------------
 * We iterate through the denominations to determine the combination
 * with the least number of denominations required to obtain the target amount.
 * */
public class MinimumCoinsForChangeImpl implements MinimumCoinsForChange{
    @Override
    public int minimumCoinsForChange(int[] denominations, int desiredAmount) {

        if(desiredAmount == 0) return 0;
        int[] coinCount = new int[desiredAmount+1];
        coinCount[0] = 0;

        for (int denomination:denominations){

            for(int index=1;index<coinCount.length;index++){
                if(denomination<=index) {
                    coinCount[index] =Math.min(index,1+coinCount[index-denomination]);
                }
            }
        }
        return coinCount[desiredAmount];
    }
}
