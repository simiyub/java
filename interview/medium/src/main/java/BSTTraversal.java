import java.util.List;

/**
 * Three functions that access a given BST and return an array of the node values
 * using three traversal methods:
 * in-order traversal
 * pre-order traversal
 * post-order traversal
 * */
public interface BSTTraversal {

    List<Integer> traverseInOrder(BST tree, List<Integer> values);
    List<Integer> traversePreOrder(BST tree, List<Integer> values);
    List<Integer> traversePostOrder(BST tree, List<Integer> values);

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
