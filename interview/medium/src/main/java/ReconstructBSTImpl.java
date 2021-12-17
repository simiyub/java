import java.util.List;
/**
 * O(n) T and O(n) S as we have to create every node.
 * How it works
 * ------------
 * My first solution is to traverse the tree in a pre-order manner,
 * creating the nodes as we go. Given that the array is already in pre-order
 * order, then we append the nodes as appropriate.
 * */
public class ReconstructBSTImpl implements ReconstructBST {
    @Override
    public BST constructTree(List<Integer> array) {
        int index = 0;
        BST root = new BST(array.get(0));

        return constructTree(root, array, index+1);
    }

    private BST constructTree(BST node, List<Integer> array, int index) {
        if(index<=array.size()-1){
        if (node == null) node = new BST(array.get(index));
        else{
                node.left = constructTree(node, array, index+1);
               node.right = constructTree(node, array, index+1);
            }

    }
        return node;
    }
}
