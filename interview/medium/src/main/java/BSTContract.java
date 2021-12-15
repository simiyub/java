/**
 *This interface provides the methods implemented by a BST implementation.
 * The class supports inserting,
 * removing and checking if a value is contained in the tree.
 * The tree will always have at least one node which cannot be removed.
 * Each tree has an integer value and potentially a left and right node.
 * The value of a node is strictly greater than the value of the nodes to the left
 * and it is greater than or equal to the values of the nodes to the right.
 *
 * */
public interface BSTContract {
    BSTRecursiveImpl insert(int value);

    BSTRecursiveImpl remove(int value);

    boolean contains(int value);
}