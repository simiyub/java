package productsum;

/**
 * Given an array of objects that can contain arrays of a mixture of integers and arrays, this function
 * should return product of the depth and sum of each array.
 * As an example: new Object[]{5,2,new Object[]{7,-1},3,new Object[]{6, new Object[]{-13,8},4}}
 * should return 12 because:  5 + 2 + (7-1)*2(This array is 2 levels deep) + 3
 * + (6 + (-5)3* + 4)*2
 * */
public interface ProductSum {
    int productSum(Object[] array);
}
