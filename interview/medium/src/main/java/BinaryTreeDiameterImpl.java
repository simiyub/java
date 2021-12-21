/**
 * O(n) T and O(h) S as we traverse through the tree to the end
 * and would need space the size of the stack.
 *
 * How it works
 * ------------
 * This is a copy of the algoexpert.io solution which works as follows:
 * We iterate through the tree, determining the diameter for every branch
 * */
public class BinaryTreeDiameterImpl implements BinaryTreeDiameter {


    @Override
    public int diameter(BinaryTree tree) {

        return getDiameter(tree).diameter;
    }

    private TreeTraversalStatus getDiameter(BinaryTree tree) {
        if(tree==null){
            return new TreeTraversalStatus(0,0);
        }

        TreeTraversalStatus leftTreeTraversalStatus = getDiameter(tree.left);
        TreeTraversalStatus rightTreeTraversalStatus = getDiameter(tree.right);

        int longestPathThroughRoot = leftTreeTraversalStatus.height + rightTreeTraversalStatus.height;
        int currentMaxDiameter = Math.max(leftTreeTraversalStatus.diameter,rightTreeTraversalStatus.diameter);
        int currentDiameter = Math.max(longestPathThroughRoot, currentMaxDiameter);
        int currentHeight = 1 + Math.max(leftTreeTraversalStatus.height, rightTreeTraversalStatus.height);
        return new TreeTraversalStatus(currentDiameter, currentHeight);
    }

}
