/***
 * Demonstrate how a binary tree works with all the essential methods of:
 * insert, find, delete, in-order and pre-order traversal
 * */


public interface BinaryTree {

    Node insert(int value);

    Node find(int value);

    Node delete(int value);

    /**
     * Depth first traversal starting with the left branch, then root and finally right.
     * */
    Node traverseInOrder();

    /**
     * Depth first traversal starting with the root, then left branch and finally right.
     * */
    Node traversePreOrder();

    /***
     * Depth first traversal starting with left branch, then right branch and finally the root
     * **/
    Node traversePostOrder();

    /**
     * Breadth first search aka level-order traversal
     * */

    Node traverseLevelOrder();



}
