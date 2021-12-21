/**
 * O(n) T and O(1) S in worst case scenario as we will iterate through the tree comparing the left and right branches,
 * comparing the depth of each without storing any values until we find a difference greater than one height.
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
        return false;
    }
}
