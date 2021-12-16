/**
 * O(N) T O(D) S as we run through the tree once and space
 * required to store the stack going to the depth of the tree.
 *
 * */
public class ValidateBSTRecursiveImpl implements ValidateBST{
    @Override
    public boolean isValid(BST tree) {
        return isValid(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isValid(BST tree, int minValue, int maxValue){
        if (tree.value<minValue || tree.value>=maxValue) return false;
        if(tree.left !=null && !isValid(tree.left, minValue, tree.value)) return false;
        return tree.right == null || isValid(tree.right, tree.value, maxValue);
    }
}
