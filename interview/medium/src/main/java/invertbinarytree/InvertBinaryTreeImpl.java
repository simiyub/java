package invertbinarytree;

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
