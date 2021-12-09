import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralTraverseTest {

    @Test
    void traverse() {
        int[] expected = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

        int[][] array = new int[][]{new int[]{1,2,3,4}, new int[]{12,13,14,5},new int[]{11,16,15,6}, new int[]{10,9,7,8}, };
        assertArrayEquals(expected,new SpiralTraverseImpl().traverse(array));
    }
}