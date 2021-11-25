/**
 * This implementation uses recursion to implement the binary tree
 * **/

public class BinaryTreeImpl implements BinaryTree {

    private Node root;
    @Override
    public Node insert(int value) {
        return addRecursively(root, value);
    }

    private Node addRecursively(Node current, int value) {
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(current == null){
            return new Node(value);
        }
        if(value< current.value){
            current.left = addRecursively(current.left, value);
        }
        else if(value > current.value){
            current.right = addRecursively(current.right, value);
        }
        else {
            return current;
        }
        return current;
    }

    @Override
    public Node find(int value) {

        return findRecursively(root,value);
    }

    private Node findRecursively(Node current, int value) {
        if (current == null) return null;
        if (value == current.value) return current;
        return (value < current.value) ?
                 findRecursively(current.left, value)
                : findRecursively(current.right, value);
    }

    @Override
    public boolean delete(int value) {
        return false;
    }

    @Override
    public void traverseInOrder(Node node) {

    }

    @Override
    public void traversePreOrder(Node node) {

    }
}
