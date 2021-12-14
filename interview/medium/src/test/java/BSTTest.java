import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void insert() {
        int expected = 5;
        assertEquals(expected, new BSTImpl().insert(5));
    }

    @Test
    void remove() {
        int value = 4;
        BST bst = new BSTImpl();
        bst.insert(value);
        assertTrue(bst.contains(value));
        bst.remove(value);
        assertFalse(bst.contains(value));
    }

    @Test
    void contains() {
        int value = 3;
        BST bst = new BSTImpl();
        bst.insert(value);
        assertTrue(bst.contains(value));
    }
}