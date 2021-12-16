/**
 * Three functions that access a given BST and return an array of the node values
 * using three traversal methods:
 * in-order traversal
 * pre-order traversal
 * post-order traversal
 * */
public interface BSTTraversal {

    int[] traverseInOrder(BST tree, int[] values);
    int[] traversePreOrder(BST tree, int[] values);
    int[] traversePostOrder(BST tree, int[] values);

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
