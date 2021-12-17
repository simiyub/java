package minheightbst;

import java.util.List;

/**
 * O(n) T O(n) S will go through the array starting from the middle
 * and then splitting the array into two each time to find the value that is less than
 *  the middle value and the one that is larger and adding the bst onto the tree for
 *  each of these cases and recursively doing this for all entries in the array.
 * */
public class MinHeightImpl implements MinHeightBST{
    @Override
    public BST minHeightBST(List<Integer> array) {

        return minHeightBST(array, 0, array.size()-1);
    }

    private BST minHeightBST(List<Integer> array,int startIndex, int endIndex) {
        BST bst = null;
        if(startIndex<=endIndex){
        int index = (startIndex+endIndex) / 2;
         bst = new BST(array.get(index));
        bst.left = minHeightBST(array,startIndex,index-1);
        bst.right = minHeightBST(array,index+1,endIndex );
        }

        return bst;
    }
}
