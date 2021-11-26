public class ClosestValueInBSTImpl implements ClosestValueInBST{
    @Override
    public int closest(BinaryTree.BST tree, int target) {
        int diff = Math.abs(target - tree.value);
        BinaryTree.BST closest = tree;
        if (tree.left == null && tree.right == null) {
            System.out.printf("Closest to %d is %d with a difference of %d ",target, tree.value, diff);
            return tree.value;
        }
//        if (tree.left == null) {
//            if(diff < Math.abs(target - tree.right.value)
//            closest(tree, target);
//        }
        return target;
    }

}
