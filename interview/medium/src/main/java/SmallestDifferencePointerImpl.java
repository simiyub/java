import java.util.Arrays;

/**
 *O(nlogn + mlogm) T and O(1). We sort each array
 * then we walk through the two arrays simultaneously identifying the numbers with the smallest difference
 * with no need for additional space. Thus, the sorting is the most expensive step in our algorithm.
 *
 * How it works?
 * -------------
 * We start by sorting the two arrays.
 * This will help us to know when to stop searching as values are out of the range we are looking for.
 * Once sorted, we place our pointers starting at the beginning of the arrays.
 * We compute the difference between the first two numbers and identify it as the smallest difference.
 * We then shift the pointers to obtain a smaller difference.
 * We continue until we get to the end of the arrays, at which point we return the smallest difference.
 * Example:
 * input - [-1, 5, 10, 20, 28 ,3], [26, 134, 135, 15, 17]
 * output - [28,26] - difference of 2
 * */
public class SmallestDifferencePointerImpl implements SmallestDifference {
    @Override
    public int[] difference(int[] firstArray, int[] secondArray) {

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        int firstArrayValueIndex = 0;
        int secondArrayValueIndex = 0;
        int difference = Integer.MAX_VALUE;
        int currentSmallestFirstArray = Integer.MIN_VALUE;
        int currentSmallestSecondArray = Integer.MIN_VALUE;
        int[] result = new int[2];


        while(firstArrayValueIndex<firstArray.length && secondArrayValueIndex<secondArray.length){

            int firstArrayValue = firstArray[firstArrayValueIndex];
            int secondArrayValue = secondArray[secondArrayValueIndex];
            int currentDifference;


            if(secondArrayValue > firstArrayValue) {
                currentDifference = secondArrayValue - firstArrayValue;
                firstArrayValueIndex ++;
            }
            else if(secondArrayValue < firstArrayValue){
                currentDifference = firstArrayValue - secondArrayValue;
                secondArrayValueIndex ++;
            }
            else  {
                result[0] = firstArrayValue;
                result[1] = secondArrayValue;
                return result;
            }

            if (currentDifference<difference) {
                difference = currentDifference;
                currentSmallestFirstArray = firstArrayValue;
                currentSmallestSecondArray = secondArrayValue;

            }

    }
        result[0] = currentSmallestFirstArray;
        result[1] = currentSmallestSecondArray;

        return result;
}
}
