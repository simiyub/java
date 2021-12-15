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
        BSTRecursiveImpl actual = new BSTRecursiveImpl(five);
        assertTrue(actual.contains(five));
    }

    @Test
    void insertSmaller() {
        int five = 5;
        BSTRecursiveImpl actual = new BSTRecursiveImpl(five);
        assertTrue(actual.contains(five));

        int smaller = 2;
        actual.insert(smaller);
        assertTrue(actual.contains(smaller));
    }

    @Test
    void insertBigger() {
        int two = 2;
        BSTRecursiveImpl actual = new BSTRecursiveImpl(two);
        assertTrue(actual.contains(two));

        int bigger = 5;
        actual.insert(bigger);
        assertTrue(actual.contains(bigger));
    }


    @Test
    void insertMultiple() {
        int two = 2;
        BSTRecursiveImpl actual = new BSTRecursiveImpl(two);
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
    void remove1() {
        int root = 1;
        int value = 4;
        BSTRecursiveImpl bst = new BSTRecursiveImpl(root);
        bst.insert(value);
        assertTrue(bst.contains(value));
        bst.remove(value);
        assertFalse(bst.contains(value));
    }

    @Test
    void remove2() {
        int root = 15;
        int value = 19;
        BSTRecursiveImpl bst = new BSTRecursiveImpl(root);
        bst.insert(10);
        bst.insert(17);
        bst.insert(22);
        bst.insert(16);
        bst.insert(18);
        bst.insert(20);
        bst.insert(value);
        bst.insert(24);
        assertTrue(bst.contains(value));
        bst.remove(value);
        assertFalse(bst.contains(value));
    }
    @Test
    void contains() {
        int value = 3;
        BSTRecursiveImpl bst = new BSTRecursiveImpl(1);
        bst.insert(value);
        assertTrue(bst.contains(value));
    }
}