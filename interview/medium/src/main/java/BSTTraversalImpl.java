import java.util.ArrayList;
import java.util.List;

/**
 * O(n) T and O(n) S as we traverse the tree once and and then we have to store
 * the values into an array
 * */
public class BSTTraversalImpl implements BSTTraversal {
    int index =0;
    @Override
    public List<Integer> traverseInOrder(BST tree, List<Integer> values) {


            if (tree.left != null) traverseInOrder(tree.left, values);
            values.add(tree.value);
            if (tree.right != null) traverseInOrder(tree.right, values);


        return values;
    }

    @Override
    public List<Integer> traversePreOrder(BST tree, List<Integer> values) {
        values.add(tree.value);
        if(tree.left!=null) traversePreOrder(tree.left,values);
        if(tree.right!=null) traversePreOrder(tree.right,values);
        return values;
    }

    @Override
    public List<Integer> traversePostOrder(BST tree, List<Integer> values) {
        if(tree.left!=null) traversePostOrder(tree.left,values);
        if(tree.right!=null) traversePostOrder(tree.right,values);
        values.add(tree.value);

        return values;
    }
}
