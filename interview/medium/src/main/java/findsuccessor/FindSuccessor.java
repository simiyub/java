package findsuccessor;

/**
 * This function takes a binary tree and a node value
 * and returns the successor of the given node using
 * the in order traversal.
 * If the there's no successor - the node is
 * the last in the traversal, the function will
 * return null.
 * */
public interface FindSuccessor {

    BinaryTree successor(BinaryTree tree, BinaryTree node);

     class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
