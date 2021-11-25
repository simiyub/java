/***
 * Demonstrate how a binary tree works with all the essential methods of:
 * insert, find, delete, in-order and pre-order traversal
 * */


public interface BinaryTree {

    Node insert(int value);
    Node find(int value);
    boolean delete(int value);
    void traverseInOrder(Node node);
    void traversePreOrder(Node node);

}
