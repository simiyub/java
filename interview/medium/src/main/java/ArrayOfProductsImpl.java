/**
 *O(n) T O(n) S We iterate through the array once by
 * This function w
 * */
public class ArrayOfProductsImpl implements ArrayOfProducts{
    @Override
    public int[] products(int[] array) {
        int[] results = new int[array.length];
        int runningProduct = 1;
        for (int i=0; i<=array.length-1;i++){
            results[i] = runningProduct;
            runningProduct *= array[i];
        }
        int runningProductReturn = 1;
        for (int i=array.length-1; i>=0;i--){
            results[i] *= runningProductReturn;
            runningProductReturn *= array[i];
        }


        return results;
    }
}
