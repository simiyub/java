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
        BST actual = new BST(5);
        assertEquals(expected, actual.getValue());
    }

    @Test
    void insertSmaller() {
        int expected = 5;
        BST actual = new BST(5);
        assertEquals(expected, actual.getValue());

        int smaller = 2;
        actual.insert(smaller);
        assertTrue(actual.contains(smaller));
    }

    @Test
    void insertBigger() {
        int expected = 2;
        BST actual = new BST(2);
        assertEquals(expected, actual.getValue());

        int bigger = 5;
        actual.insert(bigger);
        assertTrue(actual.contains(bigger));
    }


    @Test
    void insertMultiple() {
        int expected = 2;
        BST actual = new BST(2);
        assertEquals(expected, actual.getValue());

        int five = 5;
        actual.insert(five);
        assertTrue(actual.contains(five));

        int one = 1;
        actual.insert(one);
        assertTrue(actual.contains(one));

        int nine = 9;
        actual.insert(nine);
        assertTrue(actual.contains(nine));

        int three = 3;
        actual.insert(three);
        assertTrue(actual.contains(three));
    }



    @Test
    void remove() {
        int root = 1;
        int value = 4;
        BST bst = new BST(root);
        bst.insert(value);
        assertTrue(bst.contains(value));
        bst.remove(value);
        assertFalse(bst.contains(value));
    }

    @Test
    void contains() {
        int value = 3;
        BST bst = new BST(1);
        bst.insert(value);
        assertTrue(bst.contains(value));
    }
}