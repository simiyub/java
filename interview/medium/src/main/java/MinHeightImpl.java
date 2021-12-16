import java.util.List;

/**
 * O(n) T O(n) S will go through the array once,
 * creating the tree and using the storage equivalent to the
 * number of nodes.
 * */
public class MinHeightImpl implements MinHeightBST{
    @Override
    public BST minHeightBST(List<Integer> array) {
        MinHeightBST.BST bst = new MinHeightBST.BST(array.get(0));
        return minHeightBST(array,bst);

    }

    private BST minHeightBST(List<Integer> array, BST bst) {
        for(int i=1; i<=array.size()-1;i++){

            bst.insert(array.get(i));
        };
        return bst;
    }
}
