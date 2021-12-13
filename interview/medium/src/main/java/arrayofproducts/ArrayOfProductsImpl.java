package arrayofproducts;

/**
 *O(n) T O(n) S We iterate through the array twice,
 * to calculate the product each way of every number which is a O(2n) T
 * and dropping the constant leaves us with an O(n) for time, and we need an
 * array to store the result, thus O(n) for space.
 * How it works
 * ------------
 * Effectively, the product of all other numbers except the number in index i
 * is the product of the numbers either side of that index. So calculating the product
 * in either direction and multiplying the two gives us the product that we are looking for
 * in each index.
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
