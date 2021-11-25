import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * Traverses the tree from the left branch, then node and finally the right branch
     * and returns the last node in the tree
     * **/
    @Override
    public Node traverseInOrder() {
        return traverseInOrder(root, null);
    }


    /**
     * Traverses the tree printing out the root node, then the left branch, right branch
     * and then returns last node in the traversal
     * **/
    @Override
    public Node traversePreOrder() {
        return traversePreOrder(root, null);
    }

    /**
     * Traverses the tree and prints out the tree left branch first, then right branch
     * and finally the root node returning the last node
     * **/
    @Override
    public Node traversePostOrder() {
        return traversePostOrder(root, null);
    }

    @Override
    public Node traverseLevelOrder() {
        return traverseLevelOrder(root);
    }

    private Node traverseLevelOrder(Node root) {

        if(root==null) return null;

        Node lastNode = root;

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()){
            Node node = nodes.remove();
            System.out.println(" "+node.value);
            if(node.left != null) {
                nodes.add(node.left);
                lastNode = node.left;
            }
            if(node.right !=null) {
                nodes.add(node.right);
                lastNode = node.right;
            }
        }
        return lastNode;
    }


    private Node traverseInOrder(Node node, Node previous) {
        Node lastNode;
        if(node != null){
            lastNode = traverseInOrder(node.left, node);
            System.out.print(" "+node.value);
            lastNode = traverseInOrder(node.right, node);
        }
        else{
            lastNode = previous;
        }
        return lastNode;
    }


    private Node traversePreOrder(Node node, Node previous) {
        Node lastNode;
        if (node!=null){
            System.out.println(" " +node.value);
            lastNode = traversePreOrder(node.left, node);
            lastNode = traversePreOrder(node.right, node);
        }
        else{
            lastNode = previous;
        }
        return lastNode;
    }


    private Node traversePostOrder(Node node, Node previous) {
        Node lastNode;
        if (node !=null){
            lastNode = traversePostOrder(node.left, node);
            lastNode = traversePostOrder(node.right, node);
            System.out.println(" "+node.value);
        }
        else{
            lastNode = previous;
        }
        return lastNode;
    }




}
