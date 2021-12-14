import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void insert() {
        int five=5;
        BST actual = new BST(five);
        assertTrue(actual.contains(five));
    }

    @Test
    void insertSmaller() {
        int five = 5;
        BST actual = new BST(five);
        assertTrue(actual.contains(five));

        int smaller = 2;
        actual.insert(smaller);
        assertTrue(actual.contains(smaller));
    }

    @Test
    void insertBigger() {
        int two = 2;
        BST actual = new BST(two);
        assertTrue(actual.contains(two));

        int bigger = 5;
        actual.insert(bigger);
        assertTrue(actual.contains(bigger));
    }


    @Test
    void insertMultiple() {
        int two = 2;
        int expected = 2;
        BST actual = new BST(two);
        assertTrue(actual.contains(two));

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