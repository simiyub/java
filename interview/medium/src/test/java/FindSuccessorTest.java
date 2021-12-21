import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindSuccessorTest {

    @Test
    void testSuccessor(){
        int expected = 1;
        FindSuccessor.BinaryTree six =  new FindSuccessor.BinaryTree(6);
        FindSuccessor.BinaryTree two = new FindSuccessor.BinaryTree(2);
        FindSuccessor.BinaryTree four = new FindSuccessor.BinaryTree(4);
        FindSuccessor.BinaryTree five = new FindSuccessor.BinaryTree(5);
        FindSuccessor.BinaryTree three = new FindSuccessor.BinaryTree(3);

        FindSuccessor.BinaryTree tree = new FindSuccessor.BinaryTree(1);
        five.parent = two;
        six.parent = four;

        four.left = six;
        four.parent = two;

        two.left = four;
        two.right = five;
        two.parent = tree;

        three.parent = tree;

        tree.left = two;
        tree.right = three;
        FindSuccessor.BinaryTree node = five;
        assertEquals(expected, new FindSuccessorImpl().successor(tree,node).value);
    }

}