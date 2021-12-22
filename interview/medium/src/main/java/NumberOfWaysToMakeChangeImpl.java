/**
 * Used the algoexpert
 * */
public class NumberOfWaysToMakeChangeImpl implements NumberOfWaysToMakeChange{

    @Override
    public int numberOfWaysToMakeChange(int[] array,int desiredAmount) {
        int [] ways = new int[desiredAmount+1];
        ways[0] = 1;
        for(int denom:array){
            for(int amount=1;amount<desiredAmount+1;amount++){
                if(denom<=amount) ways[amount] += ways[amount-denom];
            }
        }
        return ways[desiredAmount];
    }
}
