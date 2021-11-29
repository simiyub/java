package util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstBinaryTree {

    public static Queue<BinaryTree.BST> tree (int[] values){
        Queue<BinaryTree.BST> breadthFirstTree = null;
        if(values!=null && values.length>0) {
            BinaryTree tree = new BinaryTree();
            Arrays.stream(values).forEach(tree::add);
            Queue<BinaryTree.BST> wip = new LinkedList<>();
            breadthFirstTree = new LinkedList<>();
            System.out.println(tree);
            wip.add(tree.getRoot());
            while (!wip.isEmpty()) {
                BinaryTree.BST node = wip.remove();
                breadthFirstTree.add(node);
                if (node.getLeft() != null) wip.add(node.getLeft());
                if (node.getRight() != null) wip.add(node.getRight());
            }
        }
        return breadthFirstTree;
    }
}
