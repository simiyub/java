import org.junit.jupiter.api.Test;
import spiraltraversal.SpiralTraverseImpl;

import static org.junit.jupiter.api.Assertions.*;

class SpiralTraverseTest {
    @Test
    void traverseTest1() {
        int[] expected = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

        int[][] array = new int[][]{new int[]{1,2,3,4}, new int[]{12,13,14,5},new int[]{11,16,15,6}, new int[]{10,9,8,7}, };
        assertArrayEquals(expected,new SpiralTraverseImpl().traverse(array));
    }

    @Test
    void traverseTest2() {
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int[][] array = new int[][]{new int[]{1,2,3,4}, new int[]{10,11,12,5},new int[]{9,8,7,6}};
        assertArrayEquals(expected,new SpiralTraverseImpl().traverse(array));
    }

    @Test
    void traverseTest3() {
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13,14,15};

        int[][] array = new int[][]{new int[]{1,2,3}, new int[]{12,13,4},new int[]{11,14,5},new int[]{10,15,6},new int[]{9,8,7}};
        assertArrayEquals(expected,new SpiralTraverseImpl().traverse(array));
    }


}