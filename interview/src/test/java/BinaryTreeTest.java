import implementbinarytree.BinaryTree;
import implementbinarytree.BinaryTreeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void insert() {
        int[] values = new int[]{6,4,8,3,5, 7, 9};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach(tree::insert);
        assertEquals(7, tree.find(8).getLeft().getValue());
    }

    @Test
    void find() {
        int[] values = new int[]{12,15,3,7,13,5};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach( tree::insert);
        assertNotNull(tree.find(15));
    }

    @Test
    void delete() {

        int[] values = new int[]{12,15,3,7,13,5};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach(tree::insert);
        assertEquals(12,tree.delete(7).getValue());
    }

    @Test
    void traverseInOrder() {
        int[] values = new int[]{12,15,3,7,13,5};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach(tree::insert);
        assertEquals(15,tree.traverseInOrder().getValue());
    }

    @Test
    void traversePreOrder() {
        int[] values = new int[]{12,15,3,7,13,5};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach(tree::insert);
        assertEquals(15,tree.traversePreOrder().getValue());
    }

    @Test
    void traversePostOrder() {
        int[] values = new int[]{12,15,3,7,13,5};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach(tree::insert);
        assertEquals(15,tree.traversePostOrder().getValue());
    }

    @Test
    void traverseLevelOrder1() {
        int[] values = new int[]{12,15,3,7,13,5};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach( tree::insert);
        assertEquals(5,tree.traverseLevelOrder().getValue());
    }

    @Test
    void traverseLevelOrder2() {
        int[] values = new int[]{1,2,3,4,5,6,7,8,9,10};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach(tree::insert);
        assertEquals(10,tree.traverseLevelOrder().getValue());
    }


}