package closetvalueinbst;

/**
 * Worst and Average case O(n) T and O(1) S as we do not use more storage
 * */

public class ClosestValueInBSTIterativeImpl implements ClosestValueInBST {

    private int closest(BinaryTree.BST tree, int target,int currentClosest) {
        while(tree!=null){
            if(Math.abs(currentClosest-target) > Math.abs(tree.value-target)) currentClosest = tree.value;

            if(target< tree.value) {
                tree = tree.left;
            }
            else if(target> tree.value){
                tree = tree.right;
            }
            else {
                break;
            }

        }
        return currentClosest;
    }

    @Override
    public int closest(BinaryTree.BST tree, int target) {
        int currentClosest = closest(tree, target, tree.value);
        System.out.printf(" %d is closest to %d ", currentClosest, target);
        return currentClosest;
    }
}
