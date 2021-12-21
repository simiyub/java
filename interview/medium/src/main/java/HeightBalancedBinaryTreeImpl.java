/**
 * O(n) T and O(h) S in worst case scenario as we will iterate through the tree comparing the left and right branches,
 * comparing the depth of each. The space required is the space to store the stack down the height of the tree.
 * We do this until we find a difference greater than one height.
 *
 * How it works
 * ------------
 * We iterate through the tree, comparing the depth of the left branch to the height of the
 * right branch. Soon as we find a difference more than 1, we break and return false. Otherwise
 * we continue comparing to the end of the tree and return true.
 * */
public class HeightBalancedBinaryTreeImpl implements HeightBalancedBinaryTree{
    @Override
    public boolean isBalanced(BinaryTree tree) {
        return getBalancedStatus(tree).isBalanced;
    }

    BalancedStatus getBalancedStatus(BinaryTree tree) {
        if (tree !=null){
            BalancedStatus leftBalancedStatus = getBalancedStatus(tree.left);
            BalancedStatus rightBalancedStatus = getBalancedStatus(tree.right);

            boolean isBalanced = leftBalancedStatus.isBalanced
                    && rightBalancedStatus.isBalanced
                    && Math.abs(leftBalancedStatus.height-rightBalancedStatus.height) <=1;


            return new BalancedStatus(isBalanced,Math.max(leftBalancedStatus.height, rightBalancedStatus.height)+1);

        }
        return new BalancedStatus(true,-1);
    }

}
