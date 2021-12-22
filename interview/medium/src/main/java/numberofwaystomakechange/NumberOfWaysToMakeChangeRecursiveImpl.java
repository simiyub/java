package numberofwaystomakechange;

/**
 *
 * */
public class NumberOfWaysToMakeChangeRecursiveImpl implements NumberOfWaysToMakeChange{
    @Override
    public int numberOfWaysToMakeChange(int[] array,int desiredAmount) {

        return recursive(array, desiredAmount, 0);

    }

    private int recursive(int[] denominations, int desiredAmount, int index) {
        if(desiredAmount == 0) return 1;

        if(index>=denominations.length) return 0;

        int amountWithCoins =0;
        int ways = 0;
        while (amountWithCoins <=desiredAmount){
            int remaining = desiredAmount - amountWithCoins;
            ways += recursive(denominations, remaining,index+1);
            amountWithCoins += denominations[index];
        }
        return ways;
    }
}
