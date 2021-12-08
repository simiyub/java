import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class ThreeNumberSumTest {

    @Test
    void sum() {
        int[][] expected = {new int[]{1,2,3},new int[]{-2,1,5}};
        int[] array = new int[]{1,2,3,-8,9,-2,5,6};
        assertEquals(expected,new ThreeNumberSumImpl().sum(array,6));
    }
}