package closetvalueinbst;

import util.BinaryTree;

/**
 * Worst O(n) T O(n) S where there's only one branch of the tree.
 * Average O(log(n)) T and O(log(n) S because of the stack in the recursion)
 *
 * This implementation uses recursion to determine the closest value to the target.
 * Completed with a bit of online help as I was it was taking long to deal with edge cases
 * */

public class ClosestValueInBSTRecursiveImpl implements ClosestValueInBST{

    public int closestRecursively(BinaryTree.BST tree, int target, int closest) {


        if (tree==null) return closest;
        if(Math.abs(target - closest) > Math.abs(target - tree.getValue())) closest = tree.getValue();

        if (tree.getValue() < target) return closestRecursively(tree.getRight(),target, closest);

        if (tree.getValue() > target)  return closestRecursively(tree.getLeft(), target, closest);

        return closest;
    }

    public int closest(BinaryTree.BST tree, int target){
        int currentClosest=tree.getValue();
        if(tree!=null) {
            currentClosest = closestRecursively(tree, target, currentClosest);
        }
        System.out.printf("closest to %d is %d ", target, currentClosest);
        return currentClosest;
    }

}
