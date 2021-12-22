/**
 *
 * */
public class NumberOfWaysToMakeChangeImpl implements NumberOfWaysToMakeChange{
    @Override
    public int numberOfWaysToMakeChange(int[] array,int desiredAmount) {
        int count = 0;
        int plausibleCombinations=0;
        int additionCombinationIndex = 0;
        for(int i=0;i<=array.length-1;i++){
            if(array[i]<=desiredAmount) {
                additionCombinationIndex = i+1;
                count += desiredAmount % array[i] == 0 ? 1 : 0;
                while(additionCombinationIndex<=array.length-1){
                    count += desiredAmount % (array[i]+array[additionCombinationIndex]) == 0 ? 1 : 0;
                    count += desiredAmount % (array[i]*array[additionCombinationIndex]) == 0 ? 1 : 0;
                    additionCombinationIndex++;
                }
            }
        }
        return count;
    }
}
