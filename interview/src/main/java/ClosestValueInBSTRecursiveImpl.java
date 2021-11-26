/**
 * Worst O(n) T O(n) S where there's only one branch of the tree.
 * Average O(log(n)) T and O(log(n) S because of the stack in the recursion)
 *
 * This implementation uses recursion to determine the closest value to the target.
 * Completed with a bit of online help as I was it was taking long to deal with edge cases
 * */

public class ClosestValueInBSTRecursiveImpl implements ClosestValueInBST{

    public int closestRecursively(BinaryTree.BST tree, int target,int closest) {


        if (tree==null) return closest;
        if(Math.abs(target - closest) > Math.abs(target - tree.value)) closest = tree.value;

        if (tree.value < target) return closestRecursively(tree.right,target, closest);

        if (tree.value > target)  return closestRecursively(tree.left, target, closest);

        return closest;
    }

    public int closest(BinaryTree.BST tree, int target){
        int currentClosest=Integer.MAX_VALUE;
        if(tree!=null) {
            currentClosest = closestRecursively(tree, target, currentClosest);
        }
        System.out.printf("closest to %d is %d ", target, currentClosest);
        return currentClosest;
    }

}
