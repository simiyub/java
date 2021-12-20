package invertbinarytree;

/**
 * O(n) T O(d) S because we go through the full length of the tree only once
 * and would use some space to store the recursive stack.
 *
 * How it works
 * ------------
 * This function takes a binary tree and returns an inverted version of the tree.
 * We do this by recursively calling a function that swaps left and right nodes
 * for each node and does this for all nodes.
 * */

import java.util.ArrayList;
import java.util.List;

public class InvertBinaryTreeImpl implements InvertBinaryTree{
    List<Integer> array = new ArrayList<>();
    @Override
    public BinaryTree invert(BinaryTree tree) {


        if(tree!=null) {
            swap(tree);
            invert(tree.left);
            invert(tree.right);
        }
        return tree;
    }

    private BinaryTree swap(BinaryTree tree) {
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        return tree;
    }
}
