public interface BinaryTree {
    Node insert(int value);
    boolean find(int value);
    boolean delete(int value);
    void traverseInOrder(Node node);
    void traversePreOrder(Node node);

}
