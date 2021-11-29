import implementbinarytree.BinaryTree;
import implementbinarytree.BinaryTreeImpl;
import implementbinarytree.BreadthFirstBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.BST;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Queue;

class SumOfBSTBranchesTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void sumOfBranchesRoot() {
        int[] values = new int[]{1,2,4,8,9,5,10,3,6,7};

        BST tree = new BST();
        Arrays.stream(values).forEach(tree::add);
        int[] expected =new int[]{28,33,34};
        assertArrayEquals(expected, new SumOfBSTBranchesImpl().sumOfBranches(tree));
    }

    @Test
    void sumOfOneBranch(){

    }

    @Test
    void sumOfTwoBranches(){

    }

    @Test
    void sumOfThreeBranches(){

    }

    @Test
    void sumOfFourBranches(){

    }
}