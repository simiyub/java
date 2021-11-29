package implementbinarytree;

import util.Node;

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
        if(value< current.getValue()){
            current.setLeft(addRecursively(current.getLeft(), value));
        }
        else if(value > current.getValue()){
            current.setRight(addRecursively(current.getRight(), value));
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

/**
 * Deletes a node such that:
 * A node without children will be deleted directly
 * For a node with one child, we link the child with the node's parent.
 * For a node with two children, we reorganize the tree
 * */

    @Override
    public Node delete(int value) {
        return deleteRecursively(root, value);
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


    /**
     * Traverses the tree one level at a time and returns the last node in the tree
     * */
    @Override
    public Node traverseLevelOrder() {
        return traverseLevelOrder(root);
    }

    private int findSmallestValue(Node root){
        return root.getLeft() == null ? root.getValue() : findSmallestValue(root.getLeft());
    }

    private Node deleteRecursively(Node current ,int value) {
        if(current == null) return null;
        if(current.getValue() == value){

            if(current.getLeft() == null && current.getRight() == null) return null;
            if(current.getRight() == null) return current.getLeft();
            if(current.getLeft() == null) return current.getRight();

            int smallestValue = findSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(deleteRecursively(current.getRight(), smallestValue));

            return current;

        }
        if(value <current.getValue()) {
            current.setLeft(deleteRecursively(current.getLeft(), value));
        }
        else{
            current.setRight(deleteRecursively(current.getRight(), value));
        }
        return current;
    }
    private Node findRecursively(Node current, int value) {
        if (current == null) return null;
        if (value == current.getValue()) return current;
        return (value < current.getValue()) ?
                findRecursively(current.getLeft(), value)
                : findRecursively(current.getRight(), value);
    }


    private Node traverseLevelOrder(Node root) {

        if(root==null) return null;

        Node lastNode = root;

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()){
            Node node = nodes.remove();
            System.out.println(" "+node.getValue());
            if(node.getLeft() != null) {
                nodes.add(node.getLeft());
                lastNode = node.getLeft();
            }
            if(node.getRight() !=null) {
                nodes.add(node.getRight());
                lastNode = node.getRight();
            }
        }
        return lastNode;
    }


    private Node traverseInOrder(Node node, Node previous) {
        Node lastNode;
        if(node != null){
            lastNode = traverseInOrder(node.getLeft(), node);
            System.out.print(" "+node.getValue());
            lastNode = traverseInOrder(node.getRight(), node);
        }
        else{
            lastNode = previous;
        }
        return lastNode;
    }


    private Node traversePreOrder(Node node, Node previous) {
        Node lastNode;
        if (node!=null){
            System.out.println(" " +node.getValue());
            lastNode = traversePreOrder(node.getLeft(), node);
            lastNode = traversePreOrder(node.getRight(), node);
        }
        else{
            lastNode = previous;
        }
        return lastNode;
    }


    private Node traversePostOrder(Node node, Node previous) {
        Node lastNode;
        if (node !=null){
            lastNode = traversePostOrder(node.getLeft(), node);
            lastNode = traversePostOrder(node.getRight(), node);
            System.out.println(" "+node.getValue());
        }
        else{
            lastNode = previous;
        }
        return lastNode;
    }






}
