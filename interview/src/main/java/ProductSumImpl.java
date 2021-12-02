public class ProductSumImpl implements ProductSum{

    @Override
    public int productSum(Object[] array) {
        return productSumRecursive(array, 1, 0);
}

    private int productSumRecursive(Object[] array, int multiplier, int sum) {

        for (int i=0; i<=array.length -1;i++){
            if(array[i] instanceof Object[]) {
                multiplier+=1;
                sum += productSumRecursive((Object[]) array[i],multiplier, sum);
                return sum;
            }
            sum += (int) array[i] * multiplier;
            return sum;

        }
        return sum;
    }
    }
