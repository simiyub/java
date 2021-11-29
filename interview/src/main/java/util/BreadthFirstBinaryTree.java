package util;

import implementbinarytree.BinaryTree;
import implementbinarytree.BinaryTreeImpl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstBinaryTree {

    public static Queue<Node> breadthFirstBinaryTree(int[] values){
        Queue<Node> breadthFirstTree = null;
        if(values!=null && values.length>0) {
            BST tree = new BST();
            Arrays.stream(values).forEach(tree::add);
            Queue<Node> wip = new LinkedList<>();
            breadthFirstTree = new LinkedList<>();
            System.out.println(tree);
            wip.add(tree.getRoot());
            while (!wip.isEmpty()) {
                Node node = wip.remove();
                breadthFirstTree.add(node);
                if (node.getLeft() != null) wip.add(node.getLeft());
                if (node.getRight() != null) wip.add(node.getRight());
            }
        }
        return breadthFirstTree;
    }
    public static BinaryTree tree (int[] values){

        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach(tree::insert);
        return tree;
    }
}
