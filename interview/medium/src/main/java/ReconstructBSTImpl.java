import java.util.List;
/**
 * O(n^2) T and O(n) S as we have to create every node.
 * How it works
 * ------------
 * My first solution is to traverse the tree in a pre-order manner,
 * creating the nodes as we go. Given that the array is already in pre-order
 * order, then we append the nodes as appropriate.
 * */
public class ReconstructBSTImpl implements ReconstructBST {
    @Override
    public BST constructTree(List<Integer> array) {

        BST root = new BST(array.get(0));

        for(int i=1;i<=array.size()-1;i++) root.insert(array.get(i));

        return root;
    }

}
