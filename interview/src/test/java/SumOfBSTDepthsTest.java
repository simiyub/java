import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sumofbstdepths.SumOfBSTDepthsIterativeImpl;
import sumofbstdepths.SumOfBSTDepthsRecursiveImpl;
import util.BST;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SumOfBSTDepthsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void depthsRecursive() {
        int[] values = new int[]{1,2,4,8,9,5,10,3,6,7};
//        int[] values = new int[]{1,2,4,8,9,5,3,6,7};
        BST tree = new BST();
        Arrays.stream(values).forEach(tree::add);
        int expected =33;
        assertEquals(expected, new SumOfBSTDepthsRecursiveImpl().depths(tree.getRoot()));
    }

    @Test
    void depthsIterative() {
        int[] values = new int[]{1,2,4,8,9,5,10,3,6,7};
//        int[] values = new int[]{1,2,4,8,9,5,3,6,7};
        BST tree = new BST();
        Arrays.stream(values).forEach(tree::add);
        int expected =33;
        assertEquals(expected, new SumOfBSTDepthsIterativeImpl().depths(tree.getRoot()));
    }
}