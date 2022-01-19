package closestvalueinbst;

import util.Node;

/**
 * Worst and Average case O(n) T and O(1) S as we do not use more storage
 * */

public class ClosestValueInBSTIterativeImpl implements ClosestValueInBST {


    @Override
    public int closest(Node tree, int target) {
        int currentClosest = tree.getValue();

        while(tree!=null){
            if(Math.abs(currentClosest-target) > Math.abs(tree.getValue()-target)) currentClosest = tree.getValue();

            if(target< tree.getValue())tree = tree.getLeft();
            else if(target> tree.getValue()) tree = tree.getRight();
            else break;

        }

        System.out.printf(" %d is closest to %d ", currentClosest, target);
        return currentClosest;
    }
}
