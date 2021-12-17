/**
 * Immediate approach that comes to mind which would be O(n) T (n) S is:
 * Find the largest value in the tree.
 * start a counter
 * check if the counter = k
 * if not, then move on to the parent of the largest value and increment the counter
 * check if the counter = k
 * if counter not = k
 * go to the left of the parent incrementing the counter.
 * If we are still not onto k, we move on to the parent
 * We repeat this process until we get to the root, assuming we are not on the kth largest
 * We go down the left of the tree one level then go all the way down right to the
 * bottom of the branch.
 * We then repeat the process we did on the right branch earlier and walk up the tree till
 * we reach the parent where we started
 * At this point, we go down left one level and repeat traversal down the right, and then
 * walking back up the tree
 * We continue with this approach until we get to the kth largest element or we've inspected all
 * nodes and none is the kth largest
 *
 * */


public class FindKthLargestValueInBSTImpl implements FindKthLargestValueInBST{
    @Override
    public int kthLargestValue(BST bst, int k) {

        return 0;
    }
}
