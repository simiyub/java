/**
 * O(n) T and O(n) S as we traverse the tree once and and then we have to store
 * the values into an array
 * */
public class BSTTraversalImpl implements BSTTraversal {
    int index =0;
    @Override
    public int[] traverseInOrder(BST tree, int[] values) {

        while(tree!=null) {
            int value;
            if (tree.left != null) {
                traverseInOrder(tree.left, values);
            }


            values[index] = tree.value;

            if (tree.right != null) {
                traverseInOrder(tree.right, values);
            }
            index +=1;
        }
        return values;
    }

    @Override
    public int[] traversePreOrder(BST tree, int[] values) {
        return new int[0];
    }

    @Override
    public int[] traversePostOrder(BST tree, int[] values) {
        return new int[0];
    }
}
