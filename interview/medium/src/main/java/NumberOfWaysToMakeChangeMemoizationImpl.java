import java.util.HashMap;
import java.util.Map;

/**
 *
 * */
public class NumberOfWaysToMakeChangeMemoizationImpl implements NumberOfWaysToMakeChange{
    @Override
    public int numberOfWaysToMakeChange(int[] array,int desiredAmount) {

        return recursive(array, desiredAmount, 0, new HashMap<>());

    }

    private int recursive(int[] denominations, int desiredAmount, int index, Map<String, Integer> memo) {
        if(desiredAmount == 0) return 1;

        if(index>=denominations.length) return 0;

        String key = desiredAmount+"-"+index;
        if(memo.containsKey(key)) return memo.get(key);
        int amountWithCoins =0;
        int ways = 0;

        while (amountWithCoins <=desiredAmount){
            int remaining = desiredAmount - amountWithCoins;
            ways += recursive(denominations, remaining,index+1, memo);
            amountWithCoins += denominations[index];
        }
        memo.put(key,ways);
        return ways;
    }
}
