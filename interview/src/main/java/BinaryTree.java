public interface BinaryTree {
    Node insert(int value);
    Node find(int value);
    boolean delete(int value);
    void traverseInOrder(Node node);
    void traversePreOrder(Node node);

}
