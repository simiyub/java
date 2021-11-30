import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.BST;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumOfBSTDepthsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void depths() {
        int[] values = new int[]{1,2,4,8,9,5,10,3,6,7};

        BST tree = new BST();
        Arrays.stream(values).forEach(tree::add);
        int expected =6;
        assertEquals(expected, new SumOfBSTDepthsImpl().depths(tree.getRoot()));
    }
}