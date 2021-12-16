import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BSTTraversalTest {
    BSTTraversal.BST tree;

    @BeforeEach
    void setUp() {

        BSTTraversal.BST ten = new BSTTraversal.BST(10);
        BSTTraversal.BST fifteen = new BSTTraversal.BST(15);
        BSTTraversal.BST twentyTwo = new BSTTraversal.BST(22);
        BSTTraversal.BST five1 = new BSTTraversal.BST(5);
        BSTTraversal.BST five2 = new BSTTraversal.BST(5);
        BSTTraversal.BST two = new BSTTraversal.BST(2);

        fifteen.right = twentyTwo;
        five1.right = five2;
        five1.left = two;
        two.left = new BSTTraversal.BST(1);
        ten.left = five1;
        ten.right = fifteen;
        tree = ten;
    }

    @Test
    void traverseInOrder() {
        List<Integer> expected = List.of(1,2,5,5,10, 15, 22);
        assertEquals(expected,new BSTTraversalImpl().traverseInOrder(tree, new ArrayList<>()));
    }

    @Test
    void traversePreOrder() {
        List<Integer> expected =  List.of(10, 5, 2, 1, 5, 15,22);
        assertEquals(expected, new BSTTraversalImpl().traversePreOrder(tree, new ArrayList<>()));
    }

    @Test
    void traversePostOrder() {
        List<Integer> expected = List.of(1, 2, 5, 5, 22, 15, 10);
        assertEquals(expected, new BSTTraversalImpl().traversePostOrder(tree, new ArrayList<>()));
    }
}