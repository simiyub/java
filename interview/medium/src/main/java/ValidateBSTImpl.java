
public class ValidateBSTImpl implements ValidateBST{
    @Override
    public boolean isValid(BST tree) {
        return isValid(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isValid(BST tree, int minValue, int maxValue){
        if (tree.value<minValue || tree.value>maxValue) return false;
        if(tree.left !=null && !isValid(tree.left, minValue, tree.value)) return false;
        if (tree.right !=null && !isValid(tree.right, tree.value, maxValue)) return false;
        return true;
    }
}
