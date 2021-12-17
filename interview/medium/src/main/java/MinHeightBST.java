import java.util.List;

/**
 * This function will create a valid BST from an array of
 * sorted integers and returns the root of the BST.
 * This bst will be the shortest height we can obtain.
 * */
public interface MinHeightBST {
    BST minHeightBST(List<Integer> array);

    class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
