package sumofbstdepths;

import util.Node;

/**
 * O(n) T and O( height/depth of the tree)
 *Recursive solution
 * */
public class SumOfBSTDepthsRecursiveImpl implements SumOfBSTDepths {
    @Override
    public int depths(Node tree) {
        return recursivelyCheckDepths(tree, 0);
    }

    private int recursivelyCheckDepths(Node tree, int runningDepth) {
        if (tree ==null) return 0;
            return runningDepth + (recursivelyCheckDepths(tree.getLeft(), runningDepth + 1) +
                    recursivelyCheckDepths(tree.getRight(), runningDepth + 1));
    }
}
