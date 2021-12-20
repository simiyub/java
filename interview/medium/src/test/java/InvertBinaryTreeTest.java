import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {

    @Test
    public void invertTest(){
        InvertBinaryTree.BinaryTree eight = new InvertBinaryTree.BinaryTree(8);
        InvertBinaryTree.BinaryTree nine =  new InvertBinaryTree.BinaryTree(9);
        InvertBinaryTree.BinaryTree seven = new InvertBinaryTree.BinaryTree(7);
        InvertBinaryTree.BinaryTree six = new InvertBinaryTree.BinaryTree(6);
        InvertBinaryTree.BinaryTree five = new InvertBinaryTree.BinaryTree(5);
        InvertBinaryTree.BinaryTree four = new InvertBinaryTree.BinaryTree(4);
        InvertBinaryTree.BinaryTree three = new InvertBinaryTree.BinaryTree(3);
        InvertBinaryTree.BinaryTree two  = new InvertBinaryTree.BinaryTree(2);
        InvertBinaryTree.BinaryTree tree = new InvertBinaryTree.BinaryTree(1);


        four.left = eight;
        four.right = nine;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        tree.left = two;
        tree.right = three;

        InvertBinaryTree.BinaryTree eightOut = new InvertBinaryTree.BinaryTree(8);
        InvertBinaryTree.BinaryTree nineOut =  new InvertBinaryTree.BinaryTree(9);
        InvertBinaryTree.BinaryTree sevenOut = new InvertBinaryTree.BinaryTree(7);
        InvertBinaryTree.BinaryTree sixOut = new InvertBinaryTree.BinaryTree(6);
        InvertBinaryTree.BinaryTree fiveOut = new InvertBinaryTree.BinaryTree(5);
        InvertBinaryTree.BinaryTree fourOut = new InvertBinaryTree.BinaryTree(4);
        InvertBinaryTree.BinaryTree threeOut = new InvertBinaryTree.BinaryTree(3);
        InvertBinaryTree.BinaryTree twoOut  = new InvertBinaryTree.BinaryTree(2);
        InvertBinaryTree.BinaryTree expected = new InvertBinaryTree.BinaryTree(1);


        fourOut.left = nineOut;
        fourOut.right = eightOut;
        twoOut.right = fourOut;
        twoOut.left = fiveOut;
        threeOut.left = sevenOut;
        threeOut.right = sixOut;
                expected.right = twoOut;
                expected.left = three;

        InvertBinaryTree.BinaryTree actual = new InvertBinaryTreeImpl().invert(tree);
                assertEquals(expected.value, actual.value);
        assertEquals(expected.right.value, actual.right.value);
        assertEquals(expected.left.value, actual.left.value);
    }

}