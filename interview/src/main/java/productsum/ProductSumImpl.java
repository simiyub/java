package productsum;

/**
 * O(n) T where n is the total number of elements including those in sub arrays.
 * O(d) S where d is the depth we can go to in working out the sum.
 * */
public class ProductSumImpl implements ProductSum{

    @Override
    public int productSum(Object[] array) {
        return productSumRecursive(array, 1);
}

    private int productSumRecursive(Object[] array, int multiplier) {
        int sum =0;

        for (int i=0; i<=array.length -1;i++){
            if(array[i] instanceof Object[]) sum += productSumRecursive((Object[]) array[i],multiplier+1);
            else sum += (int) array[i];
        }


        return sum*multiplier;
    }

    }
