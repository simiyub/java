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
        Arrays.stream(values).forEach( value-> tree.insert(value));
        assertTrue(tree.find(8).left.value ==7);
    }

    @Test
    void find() {
        int[] values = new int[]{12,15,3,7,13,5};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach( value-> tree.insert(value));
        assertNotNull(tree.find(15));
    }

    @Test
    void delete() {
    }

    @Test
    void traverseInOrder() {
        int[] values = new int[]{12,15,3,7,13,5};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach( value-> tree.insert(value));
        assertEquals(15,tree.traverseInOrder().value);
    }

    @Test
    void traversePreOrder() {
        int[] values = new int[]{12,15,3,7,13,5};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach( value-> tree.insert(value));
        assertEquals(15,tree.traversePreOrder().value);
    }

    @Test
    void traversePostOrder() {
        int[] values = new int[]{12,15,3,7,13,5};
        BinaryTree tree = new BinaryTreeImpl();
        Arrays.stream(values).forEach( value-> tree.insert(value));
        assertEquals(15,tree.traversePostOrder().value);
    }
}