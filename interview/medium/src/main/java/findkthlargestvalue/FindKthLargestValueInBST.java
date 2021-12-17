package findkthlargestvalue;

/**
 * This function will return the kth largest integer in a bst provided.
 * If there are duplicates, each of them will be considered unique.
 * */
public interface FindKthLargestValueInBST {
    int kthLargestValue(BST bst, int k);

    class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
}
