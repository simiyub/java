import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import implementbinarytree.BreadthFirstBinaryTree;
import util.Node;

import java.util.Arrays;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeBreadthFirstTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void orderTest() {
        int[] values = new int[]{15,16,18,10,11};
        Queue<Node> breadthFirstTree = BreadthFirstBinaryTree.breadthFirstBinaryTree(values);

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