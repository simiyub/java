import implementbinarytree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class SumOfBSTBranchesTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void sumOfBranches() {
        BinaryTree tree = new BinaryTree();
        int[] values = new int[]{15,16,18,10,11};
        Arrays.stream(values).forEach(tree::add);
        Queue<BinaryTree.BST> wip = new LinkedList<>();
        Queue<BinaryTree.BST> breadthFirstTree = new LinkedList<>();
        System.out.println(tree);
        wip.add(tree.getRoot());
        while (!wip.isEmpty()){
            BinaryTree.BST node = wip.remove();
            breadthFirstTree.add(node);
            if(node.getLeft()!=null) wip.add(node.getLeft());
            if(node.getRight()!=null)wip.add(node.getRight());
        }

        int[] actual = new int[values.length];
        int count = 0;
        while(!breadthFirstTree.isEmpty()) {
            actual[count] = breadthFirstTree.remove().getValue();
            count ++;
        }
        System.out.println(Arrays.toString(actual));

        assertArrayEquals(new int[] {15,10,16,11,18}, actual);
    }
}