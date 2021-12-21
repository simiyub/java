import heightbalancedbinarytree.HeightBalancedBinaryTree;
import heightbalancedbinarytree.HeightBalancedBinaryTreeImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeightBalancedBinaryTreeTest {

    @Test
    void testIsBalanced(){
        HeightBalancedBinaryTree.BinaryTree seven = new HeightBalancedBinaryTree.BinaryTree(7);
        HeightBalancedBinaryTree.BinaryTree eight = new HeightBalancedBinaryTree.BinaryTree(8);
        HeightBalancedBinaryTree.BinaryTree five = new HeightBalancedBinaryTree.BinaryTree(5);
        five.left = seven;
        five.right = eight;
        HeightBalancedBinaryTree.BinaryTree four = new HeightBalancedBinaryTree.BinaryTree(4);
        HeightBalancedBinaryTree.BinaryTree two = new HeightBalancedBinaryTree.BinaryTree(2);
        two.left = four;
        two.right = five;
        HeightBalancedBinaryTree.BinaryTree six = new HeightBalancedBinaryTree.BinaryTree(6);
        HeightBalancedBinaryTree.BinaryTree three = new HeightBalancedBinaryTree.BinaryTree(3);
        three.right = six;
        HeightBalancedBinaryTree.BinaryTree tree = new HeightBalancedBinaryTree.BinaryTree(1);
        tree.left = two;
        tree.right = three;

        assertTrue(new HeightBalancedBinaryTreeImpl().isBalanced(tree));
    }

}