package sumofbstdepths;

import util.Node;

/**
 * Placeholder for iterative implementation
 * */
public class SumOfBSTDepthsIterativeImpl implements SumOfBSTDepths {


    @Override
    public int depths(Node tree) {
        int depthSum = 0;
        depthSum = calculateDepthSum(tree, 0);

        return depthSum;
    }

    private int calculateDepthSum(Node tree, int currentDepth) {
        return 0;
    }
}
