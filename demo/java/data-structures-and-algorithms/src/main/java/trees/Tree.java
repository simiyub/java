package trees;

public interface Tree {
    Node insert(String value);
    Node search(String value);
    void traverse();
}
