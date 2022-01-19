package util;

public class BST{
    private Node root;

    private Node add(Node bst, int newValue){

        if (bst == null) return new Node(newValue);
        if (newValue <= bst.value) bst.left = add(bst.left, newValue);
        if (newValue > bst.value) bst.right = add(bst.right, newValue);
        return bst;
    }

    public Node add(int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        return add(root, value);
    }

    public Node getRoot() {
        return root;
    }
}
