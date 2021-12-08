import java.util.Arrays;

/**
 *O(nlogn + mlogm) T and O(1). We sort each array
 * then we walk through one finding the values we want from the second
 * with no need for additional space.
 * How it works?
 * -------------
 * We start by sorting the two arrays.
 * This will help us to know when to stop searching as values are out of the range we are looking for.
 * Once sorted, we choose the array with the smallest value as our anchor or base to compare with,
 * again this helps us to know when to stop sooner.
 * we start by finding the absolute difference between the base number and the first number
 * in the second array.
 * If the difference is zero, then we return the pair.If not, we progress to the next number in the
 * second array and then iterate through the array identifying any number with a greater difference.
 * When the number in the second array is larger than current base number in the first array
 * and the difference greater than the difference we currently know,
 * we move on to the next number in the second array.
 * We continue with this iteration until we get to the end of the shortest array
 * and then return our currently known pair with the smallest difference
 * in the order int from first array, then int in the second array.
 * Example:
 * input - [-1, 5, 10, 20, 28 ,3], [26, 134, 135, 15, 17]
 * output - [28,26] - difference of 2
 * */
public class SmallestDifferenceImpl implements SmallestDifference {
    @Override
    public int[] difference(int[] firstArray, int[] secondArray) {
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        int[] primaryArray, secondaryArray;


        if (firstArray[0] <= secondArray[0]){
            primaryArray = firstArray;
            secondaryArray = secondArray;
        }
        else {
            primaryArray = secondArray;
            secondaryArray = firstArray;
        }


        int currentSmallestPrimary = Integer.MIN_VALUE;
        int currentSmallestSecondary = Integer.MIN_VALUE;
        int difference = Integer.MAX_VALUE;
        for(int i=0;i<=primaryArray.length-1;i++){

            for(int j=0;j<=secondaryArray.length-1;j++){
                int currentDifference = primaryArray[i] - secondaryArray[j];
                if (currentDifference == 0) return new int[]{primaryArray[i],secondaryArray[j]};
                else {

                    if(Math.abs(currentDifference)<Math.abs(difference)){
                        difference = currentDifference;
                        currentSmallestPrimary = primaryArray[i];
                        currentSmallestSecondary = secondaryArray[j];
                    }
                    if (secondaryArray[j] > primaryArray[i] && currentDifference>difference) break;

                }

            }

        }
        return new int[]{currentSmallestPrimary,currentSmallestSecondary};
    }
}
