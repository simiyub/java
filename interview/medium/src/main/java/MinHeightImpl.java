import java.util.List;

/**
 * O(nlogn) T O(n) S will go through the array starting from the middle
 * and then splitting the array into two each time to find the value that is less than
 *  the middle value and the one that is larger and adding the bst onto the tree for
 *  each of these cases and recursively doing this for all entries in the array.
 * */
public class MinHeightImpl implements MinHeightBST{
    @Override
    public BST minHeightBST(List<Integer> array) {

        return minHeightBST(array,null, 0, array.size()-1);
    }

    private BST minHeightBST(List<Integer> array, BST bst, int startIndex, int endIndex) {
        int index = Math.round((startIndex+endIndex) / 2);

        if (startIndex<=endIndex) {
            if (bst == null) bst = new BST(array.get(index));
            else bst.insert(array.get(index));

            minHeightBST(array,bst,startIndex,index-1);
            minHeightBST(array,bst,index+1,endIndex );

        }

        return bst;
    }
}
